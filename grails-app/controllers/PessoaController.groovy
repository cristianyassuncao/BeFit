import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.converters.JSON

class PessoaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        return [pessoaInstanceList: Pessoa.list(params), pessoaInstanceCount: Pessoa.count()]
    }

    def show = {
        def pessoaInstance = Pessoa.get(params.id)
        return [pessoaInstance: pessoaInstance]
    }

    def create() {
        respond new PessoaFisica(params), model: [somenteLeitura: true]
    }

    def save = {
        def pessoaInstance = new PessoaFisica()
        pessoaInstance.properties = params
        
        if (pessoaInstance == null) {
            notFound()
            return
        }

        if (!pessoaInstance.validate()) {
            render(view:'create', model:[pessoaInstance: pessoaInstance, somenteLeitura: true])
            return
        }

        pessoaInstance.save flush:true
        
        redirect(action: "edit", params: [id: pessoaInstance.id])
    }

    def edit = {
        def pessoaInstance = Pessoa.get(params.id)
        render(view:'edit', model:[pessoaInstance: pessoaInstance])
    }

    def update = {
        def pessoaInstance = Pessoa.get(params.id)
                      
        if (pessoaInstance == null) {
            notFound()
            return
        }
        
        pessoaInstance.properties = params
        if (!pessoaInstance.validate()) {
            render(view:'edit', model:[pessoaInstance: pessoaInstance])
            return
        }
        
        pessoaInstance.save flush:true

        redirect(action: show, id: pessoaInstance?.id)
    }

    def delete = {
        def pessoaInstance = Pessoa.get(params.id)
        
        if (pessoaInstance == null) {
            notFound()
            return
        }

        pessoaInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Pessoa.label', default: 'Pessoa'), pessoaInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pessoa.label', default: 'Pessoa'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    
    def loadEndereco = {
        def enderecoInstance = null
        if (params.idEndereco == null) {
            def pessoaInstance = Pessoa.get(params.idPessoa)
            if (pessoaInstance == null) {
                response.setStatus(500)
                render("Pessoa não cadastrada!!!") as JSON
                return 
            }
            enderecoInstance = new Endereco(pessoa: Pessoa.get(params.idPessoa))
        } else {
            enderecoInstance = Endereco.get(params.idEndereco)
        }
        render(view: '/endereco/create', model: [enderecoInstance: enderecoInstance])        
    }
    
    def updateEndereco = {
        def pessoaInstance = Pessoa.get(params["pessoa.id"])
        def enderecoInstance = Endereco.get(params.id) 
        if (!enderecoInstance) {
           enderecoInstance = new Endereco()
        }
        enderecoInstance.properties = params
        enderecoInstance.cep = enderecoInstance?.cep?.replace("-","") 
        if (!enderecoInstance.validate()) {
            render(view:'/endereco/create', model:[enderecoInstance: enderecoInstance])
            response.setStatus(500)
            return
        }
        enderecoInstance.save flush:true
        pessoaInstance.refresh()
        render(template:'/endereco/list', model:[pessoaInstance: pessoaInstance])
    }
    
    def deleteEndereco = {
        def enderecoInstance = Endereco.get(params.id) 
        def pessoaInstance = enderecoInstance.pessoa
        enderecoInstance.delete(flush: true)
        pessoaInstance.refresh()
        render(template:'/endereco/list', model:[pessoaInstance: pessoaInstance])
    }
    
    def loadTelefone = {
        def telefoneInstance = null
        if (params.idTelefone == null) {
            def pessoaInstance = Pessoa.get(params.idPessoa)
            if (pessoaInstance == null) {
                response.setStatus(500)
                render("Pessoa não cadastrada!!!") as JSON
                return 
            }
            telefoneInstance = new Telefone(pessoa: Pessoa.get(params.idPessoa))
        } else {
            telefoneInstance = Telefone.get(params.idTelefone)
        }
        render(view: '/telefone/create', model: [telefoneInstance: telefoneInstance])        
    }
    
    def updateTelefone = {
        def pessoaInstance = Pessoa.get(params["pessoa.id"])
        def telefoneInstance = Telefone.get(params.id) 
        if (!telefoneInstance) {
           telefoneInstance = new Telefone()
        }
        telefoneInstance.properties = params
        telefoneInstance.numero = Telefone.removerMascara(params?.numeroTelefone)
        telefoneInstance.whatsapp = (params?.whatsapp == null ? false : params?.whatsapp)
        if (!telefoneInstance.validate()) {
            render(view:'/telefone/create', model:[telefoneInstance: telefoneInstance])
            response.setStatus(500)
            return
        }
        telefoneInstance.save flush:true
        pessoaInstance.refresh()
        render(template:'/telefone/list', model:[pessoaInstance: pessoaInstance])
    }
    
    def deleteTelefone = {
        def telefoneInstance = Telefone.get(params.id) 
        def pessoaInstance = telefoneInstance.pessoa
        telefoneInstance.delete(flush: true)
        pessoaInstance.refresh()
        render(template:'/telefone/list', model:[pessoaInstance: pessoaInstance])
    }
    
}