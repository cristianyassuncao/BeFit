import static org.springframework.http.HttpStatus.*

import com.bertramlabs.plugins.SSLRequired;

import grails.transaction.Transactional

@SSLRequired
@Transactional(readOnly = true)
class BairroController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Bairro.list(params), model:[bairroInstanceCount: Bairro.count()]
    }

    def show(Bairro bairroInstance) {
        respond bairroInstance
    }

    def create() {
        respond new Bairro(params)
    }

    @Transactional
    def save(Bairro bairroInstance) {
        if (bairroInstance == null) {
            notFound()
            return
        }

        if (bairroInstance.hasErrors()) {
            respond bairroInstance.errors, view:'create'
            return
        }

        bairroInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'bairro.label', default: 'Bairro'), bairroInstance.id])
                redirect bairroInstance
            }
            '*' { respond bairroInstance, [status: CREATED] }
        }
    }

    def edit(Bairro bairroInstance) {
        respond bairroInstance
    }

    @Transactional
    def update(Bairro bairroInstance) {
        if (bairroInstance == null) {
            notFound()
            return
        }

        if (bairroInstance.hasErrors()) {
            respond bairroInstance.errors, view:'edit'
            return
        }

        bairroInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Bairro.label', default: 'Bairro'), bairroInstance.id])
                redirect bairroInstance
            }
            '*'{ respond bairroInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Bairro bairroInstance) {

        if (bairroInstance == null) {
            notFound()
            return
        }

		try {
			bairroInstance.delete flush:true
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'bairro.label'), bairroInstance.id])
		} catch(org.springframework.dao.DataIntegrityViolationException e) {
			flash.message = "Este bairro não pode ser excluído porque já está sendo utilizado em outros cadastros"
		}	
        request.withFormat {
            form multipartForm {
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'bairro.label'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
