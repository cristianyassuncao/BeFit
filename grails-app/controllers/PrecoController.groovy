import static org.springframework.http.HttpStatus.*

import com.bertramlabs.plugins.SSLRequired;

import grails.transaction.Transactional

@SSLRequired
@Transactional(readOnly = true)
class PrecoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Preco.list(params), model:[precoInstanceCount: Preco.count()]
    }

    def show(Preco precoInstance) {
        respond precoInstance
    }

    def create() {
        respond new Preco(params)
    }

    @Transactional
    def save(Preco precoInstance) {
        if (precoInstance == null) {
            notFound()
            return
        }

        if (precoInstance.hasErrors()) {
            respond precoInstance.errors, view:'create'
            return
        }

        precoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'preco.label', default: 'Preco'), precoInstance.id])
                redirect precoInstance
            }
            '*' { respond precoInstance, [status: CREATED] }
        }
    }

    def edit(Preco precoInstance) {
        respond precoInstance
    }

    @Transactional
    def update(Preco precoInstance) {
        if (precoInstance == null) {
            notFound()
            return
        }

        if (precoInstance.hasErrors()) {
            respond precoInstance.errors, view:'edit'
            return
        }

        precoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Preco.label', default: 'Preco'), precoInstance.id])
                redirect precoInstance
            }
            '*'{ respond precoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Preco precoInstance) {

        if (precoInstance == null) {
            notFound()
            return
        }

        precoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Preco.label', default: 'Preco'), precoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'preco.label', default: 'Preco'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
