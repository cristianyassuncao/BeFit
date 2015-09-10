import static org.springframework.http.HttpStatus.*

import java.util.List;

import grails.transaction.Transactional

@Transactional(readOnly = true)
class EntregadorController {
	def cadastroService
	
	static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]
	
	private List<Entregador> inicializarEntregadores() {
		def listaEntregadores = Entregador.list()
		Collections.sort(listaEntregadores)
		return listaEntregadores
	}

    def index(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		def result = Entregador.createCriteria().list(params) {
			if (params['entregador'] != null && params['entregador'] != "") {
				eq("id", new Long(params['entregador']))
			}
		}
		def totalRegistros = result.totalCount
		respond result, model:['entregadores': inicializarEntregadores(), entregadorInstanceCount: totalRegistros]
    }

    def show(Entregador entregadorInstance) {
        respond entregadorInstance
    }
	
	private Pessoa inicializarPessoa() {
		def pessoaInstance = new PessoaFisica()
		pessoaInstance.dataInclusao = new Date()
		return pessoaInstance
	}

    def create() {
        params.pessoa = inicializarPessoa()
        respond new Entregador(params), model: [somenteLeitura: true]
    }

   def save = {
        def entregadorInstance = cadastroService.criarEntregador(params)
        if (entregadorInstance.hasErrors()) {
            def enderecoInstance = cadastroService.definirEndereco(params)
            def telefoneInstance = cadastroService.definirTelefone(params)
            render(view:'create', model:[entregadorInstance: entregadorInstance, enderecoInstance: enderecoInstance, telefoneInstance: telefoneInstance, somenteLeitura: true])
            return
        }    
        redirect(action: "edit", params: [id: entregadorInstance.id])
    }

    def edit = {
        def entregadorInstance = Entregador.get(params.id)
        render(view:'edit', model:[entregadorInstance: entregadorInstance])
    }

    def update = {
        def entregadorInstance = cadastroService.salvarEntregador(params)
        if (entregadorInstance.hasErrors()) {
            render(view:'edit', model:[entregadorInstance: entregadorInstance])
            return
        }    
        redirect(action: "show", id: entregadorInstance?.id)
    }

    @Transactional
    def delete(Entregador entregadorInstance) {

        if (entregadorInstance == null) {
            notFound()
            return
        }

        entregadorInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Entregador.label', default: 'Entregador'), entregadorInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'entregador.label', default: 'Entregador'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
