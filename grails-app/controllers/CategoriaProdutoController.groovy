import groovy.json.*
import grails.converters.JSON
import grails.web.JSONBuilder
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CategoriaProdutoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        return render(view: 'index', model: [categorias: getTodasCategorias()])
    }
    
    String getTodasCategorias(CategoriaProduto categoriaSelecionada) {
        def categoriasList = CategoriaProduto.findAll("FROM CategoriaProduto")
        String categoriasJSON = categoriasList.collect {
                                    [id: it?.id,
                                     parent: (it?.categoriaPai?.id == null) ? '#' : it?.categoriaPai?.id,
                                     text: it?.nome,
                                     state: [
                                        disabled : (categoriaSelecionada == null) ? false : it?.equals(categoriaSelecionada),
                                        selected : (categoriaSelecionada?.categoriaPai == null) ? false : it?.equals(categoriaSelecionada?.categoriaPai)
                                     ]
                                    ]
                            } as JSON
        return categoriasJSON
    }
    
    def show(CategoriaProduto categoriaProdutoInstance) {
        respond categoriaProdutoInstance
    }

    def create() {
        return render(view: 'create', model: [categorias: getTodasCategorias()])
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
        return render(view: 'edit', model: [categoriaProdutoInstance: categoriaProdutoInstance, categorias: getTodasCategorias(categoriaProdutoInstance)])
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
