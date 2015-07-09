

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PedidoController {
    
    def cadastroService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Pedido.list(params), model:[pedidoInstanceCount: Pedido.count()]
    }

    def show(Pedido pedidoInstance) {
        respond pedidoInstance
    }

    def create() {
        def listaClientes = Cliente.list()
        Collections.sort(listaClientes)
        def listaEntregadores = Entregador.list()
        Collections.sort(listaEntregadores)
        def pedido = new Pedido()
        pedido.dataCadastro = new Date()
        pedido.valorPago = new BigDecimal(0);
        return render(view: 'create', model: [pedido: pedido, clientes: listaClientes, entregadores: listaEntregadores])
    }

    def save = {
        def pedidoInstance = cadastroService.criarPedido(params)
        if (pedidoInstance.hasErrors()) {
            pedidoInstance.errors
            def listaClientes = Cliente.list()
            Collections.sort(listaClientes)
            def listaEntregadores = Entregador.list()
            Collections.sort(listaEntregadores)
            def itensPedido = cadastroService.definirItensPedido(params)
            render(view:'create', model: [pedido: pedidoInstance, clientes: listaClientes, entregadores: listaEntregadores, itensPedido: itensPedido])
            return
        }
        redirect(action: "edit", params: [id: pedidoInstance.id])
    }

    def edit = {
        def pedidoInstance = Pedido.get(params.id)
        render(view:'edit', model:[pedido: pedidoInstance])
    }

    @Transactional
    def update(Pedido pedidoInstance) {
        if (pedidoInstance == null) {
            notFound()
            return
        }

        if (pedidoInstance.hasErrors()) {
            respond pedidoInstance.errors, view:'edit'
            return
        }

        pedidoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Pedido.label', default: 'Pedido'), pedidoInstance.id])
                redirect pedidoInstance
            }
            '*'{ respond pedidoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Pedido pedidoInstance) {

        if (pedidoInstance == null) {
            notFound()
            return
        }

        pedidoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Pedido.label', default: 'Pedido'), pedidoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pedido.label', default: 'Pedido'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
