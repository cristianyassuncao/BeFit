import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.converters.JSON

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
        redirect(action: "index")
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
    
    def consultarClientePorTelefone = {
        if (params.telefone == null || params.telefone == "") {
            render "[]" as JSON
        }
        def clientes = Cliente.createCriteria().list(params) {
            pessoa {
                telefones {
                    eq("numero", Telefone.removerMascara(params.telefone))
                }
            }
        }   
        Collections.sort(clientes)
        String clientesJSON = clientes.collect {
                                    [id: it?.id,
                                     nome: it?.nome]
                            } as JSON
        render clientesJSON
    }
    
    def carregarDadosComplementares = {
        def idCliente = new Long(params?.idCliente)
        def cliente = Cliente.get(idCliente)
        def enderecoEntrega = null
        def enderecos = cliente?.pessoa?.enderecos
        if (enderecos.size() > 0) {
            enderecoEntrega = cliente?.pessoa?.enderecos[0]
        }    
        render(template: 'dadosComplementares', model: ['cliente': cliente, 'endereco': enderecoEntrega, 'telefones': cliente?.pessoa?.telefones])
    }
    
    def carregarEnderecos = {
        def idCliente = new Long(params?.idCliente)
        def cliente = Cliente.get(idCliente)
        render(view: 'selecaoEndereco', model: ['enderecos': cliente?.pessoa?.enderecos])
    }
	
	def carregarTelefonePrincipal = {
		def cliente = Cliente.get(new Long(params?.idCliente))
		def telefone = Telefone.find("FROM Telefone WHERE pessoa = :pessoa AND whatsapp", [pessoa: cliente.pessoa])
		return telefone?.numero
	}
    
}