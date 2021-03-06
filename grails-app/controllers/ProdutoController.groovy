import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.converters.JSON

@Transactional(readOnly = true)
class ProdutoController {
    
    def cadastroService

    static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Produto.list(params), model:[produtoInstanceCount: Produto.count()]
    }

    def show(Produto produtoInstance) {
        respond produtoInstance
    }

    def create() {
        respond new Produto(params)
    }

    def save = {
        def produtoInstance = cadastroService.criarProduto(params)
        if (produtoInstance.hasErrors()) {
            def precoInstance = cadastroService.definirPreco(params?.valor)
            render(view:'create', model:[produtoInstance: produtoInstance, precoInstance: precoInstance])
            return
        }    
        redirect(action: "edit", params: [id: produtoInstance.id])
    }
    
    def exibirImagem = {
        def produtoInstance = Produto.get(params.id)
        if (produtoInstance != null) {
            response.outputStream << produtoInstance.imagem // write the image to the outputstream
            response.outputStream.flush()
        }    
    }

    def edit = {
        def produtoInstance = Produto.get(params.id)
        render(view:'edit', model:[produtoInstance: produtoInstance])
    }

    def update = {
        def produtoInstance = cadastroService.salvarProduto(params)
        if (produtoInstance.hasErrors()) {
            render(view:'edit', model:[produtoInstance: produtoInstance])
            return
        }    
        redirect(action: "show", id: produtoInstance?.id)
    }

    @Transactional
    def delete(Produto produtoInstance) {

        if (produtoInstance == null) {
            notFound()
            return
        }

        produtoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Produto.label', default: 'Produto'), produtoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'produto.label', default: 'Produto'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    
    def loadPreco = {
        def precoInstance = null
        if (params.idPreco == null) {
            def produtoInstance = Produto.get(params.idProduto)
            if (produtoInstance == null) {
                response.setStatus(500)
                render("Produto não cadastrado!!!") as JSON
                return 
            }
            precoInstance = new Preco(produto: Produto.get(params.idProduto))
        } else {
            precoInstance = Preco.get(params.idPreco)
        }
        render(view: '/preco/create', model: [precoInstance: precoInstance])        
    }
    
    def updatePreco = {
        def produtoInstance = Produto.get(params["produto.id"])
        def precoInstance = Preco.get(params.id) 
        if (!precoInstance) {
           precoInstance = new Preco()
        }
        precoInstance.properties = params
        if (!precoInstance.validate()) {
            render(view:'/preco/create', model:[precoInstance: precoInstance])
            response.setStatus(500)
            return
        }
        precoInstance.save flush:true
        produtoInstance.refresh()
        render(template:'/preco/list', model:[produtoInstance: produtoInstance])
    }
    
    def deletePreco = {
        def precoInstance = Preco.get(params.id) 
        def produtoInstance = precoInstance.produto
        precoInstance.delete(flush: true)
        produtoInstance.refresh()
        render(template:'/preco/list', model:[produtoInstance: produtoInstance])
    }
    
}