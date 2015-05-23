import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.converters.JSON

class ClienteController {
    
    def cadastroService

    static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Cliente.list(params), model:[clienteInstanceCount: Cliente.count()]
    }

    def show(Cliente clienteInstance) {
        respond clienteInstance
    }

    private Pessoa inicializarPessoa() {
        def pessoaInstance = new PessoaFisica()
        pessoaInstance.dataInclusao = new Date()
        return pessoaInstance
    }
    
    def create() {
        params.pessoa = inicializarPessoa()
        params.dataInclusao = new Date()
        respond new Cliente(params), model: [somenteLeitura: true]
    }
    
    def save = {
        def clienteInstance = cadastroService.salvarCliente(params)
        if (clienteInstance.hasErrors()) {
            render(view:'create', model:[clienteInstance: clienteInstance, somenteLeitura: true])
            return
        }    
        redirect(action: "edit", params: [id: clienteInstance.id])
    }

    def edit = {
        def clienteInstance = Cliente.get(params.id)
         render(view:'edit', model:[clienteInstance: clienteInstance])
    }

    def update = {
        def clienteInstance = cadastroService.salvarCliente(params)
        if (clienteInstance.hasErrors()) {
            render(view:'edit', model:[clienteInstance: clienteInstance])
            return
        }    
        redirect(action: "show", id: clienteInstance?.id)
    }

    @Transactional
    def delete(Cliente clienteInstance) {

        if (clienteInstance == null) {
            notFound()
            return
        }

        clienteInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Cliente.label', default: 'Cliente'), clienteInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'cliente.label', default: 'Cliente'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
           
}