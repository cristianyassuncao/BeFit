import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CategoriaProdutoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CategoriaProduto.list(params), model:[categoriaProdutoInstanceCount: CategoriaProduto.count()]
    }

    def show(CategoriaProduto categoriaProdutoInstance) {
        respond categoriaProdutoInstance
    }

    def create() {
        respond new CategoriaProduto(params)
    }

    @Transactional
    def save(CategoriaProduto categoriaProdutoInstance) {
        if (categoriaProdutoInstance == null) {
            notFound()
            return
        }

        if (categoriaProdutoInstance.hasErrors()) {
            respond categoriaProdutoInstance.errors, view:'create'
            return
        }

        categoriaProdutoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'categoriaProduto.label', default: 'CategoriaProduto'), categoriaProdutoInstance.id])
                redirect categoriaProdutoInstance
            }
            '*' { respond categoriaProdutoInstance, [status: CREATED] }
        }
    }

    def edit(CategoriaProduto categoriaProdutoInstance) {
        respond categoriaProdutoInstance
    }

    @Transactional
    def update(CategoriaProduto categoriaProdutoInstance) {
        if (categoriaProdutoInstance == null) {
            notFound()
            return
        }

        if (categoriaProdutoInstance.hasErrors()) {
            respond categoriaProdutoInstance.errors, view:'edit'
            return
        }

        categoriaProdutoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'CategoriaProduto.label', default: 'CategoriaProduto'), categoriaProdutoInstance.id])
                redirect categoriaProdutoInstance
            }
            '*'{ respond categoriaProdutoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(CategoriaProduto categoriaProdutoInstance) {

        if (categoriaProdutoInstance == null) {
            notFound()
            return
        }

        categoriaProdutoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'CategoriaProduto.label', default: 'CategoriaProduto'), categoriaProdutoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'categoriaProduto.label', default: 'CategoriaProduto'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
