import static org.springframework.http.HttpStatus.*

import java.text.SimpleDateFormat;

import com.bertramlabs.plugins.SSLRequired;

import grails.transaction.Transactional

@SSLRequired
@Transactional(readOnly = true)
class ItemDiaController {
	
	SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy")

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		def result = ItemDia.createCriteria().list(params) {
			if (params.data != null && params.data != "") {
				eq("data", formatoData.parse(params.data))
			}
			if (params['produto.id'] != null && params['produto.id'] != "") {
				produto {
					eq("id", new Long(params['produto.id']))
				}
			}
		}
		def totalRegistros = result.totalCount
		respond result, model:[itemDiaInstanceCount: totalRegistros]
    }

    def show(ItemDia itemDiaInstance) {
        respond itemDiaInstance
    }

    def create() {
        respond new ItemDia(params)
    }

    @Transactional
    def save(ItemDia itemDiaInstance) {
        if (itemDiaInstance == null) {
            notFound()
            return
        }

        if (itemDiaInstance.hasErrors()) {
            respond itemDiaInstance.errors, view:'create'
            return
        }

        itemDiaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'itemDia.label', default: 'ItemDia'), itemDiaInstance.id])
                redirect itemDiaInstance
            }
            '*' { respond itemDiaInstance, [status: CREATED] }
        }
    }

    def edit(ItemDia itemDiaInstance) {
        respond itemDiaInstance
    }

    @Transactional
    def update(ItemDia itemDiaInstance) {
        if (itemDiaInstance == null) {
            notFound()
            return
        }

        if (itemDiaInstance.hasErrors()) {
            respond itemDiaInstance.errors, view:'edit'
            return
        }

        itemDiaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ItemDia.label', default: 'ItemDia'), itemDiaInstance.id])
                redirect itemDiaInstance
            }
            '*'{ respond itemDiaInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ItemDia itemDiaInstance) {

        if (itemDiaInstance == null) {
            notFound()
            return
        }

        itemDiaInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ItemDia.label', default: 'ItemDia'), itemDiaInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'itemDia.label', default: 'ItemDia'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
