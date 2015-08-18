import static org.springframework.http.HttpStatus.*

import java.text.SimpleDateFormat;
import java.util.Collections.ReverseComparator

import org.apache.jasper.compiler.Node.ParamsAction;

import grails.transaction.Transactional
import grails.converters.JSON

@Transactional(readOnly = true)
class PedidoController {
    
    def cadastroService
	
	static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index = {
		def max = Math.min( params.max ? params.max.toInteger() : 10, 100)
		def offset = params.offset ?: 0
		def sort = params.sort
		def order = params.order
		params?.max = null
		params?.offset = null
		if (params?.sort in ['cliente']) {
			params?.sort = null
			params?.order = null
		}
		def result = Pedido.createCriteria().list(params) {
		}
		def totalRegistros = result.totalCount
		def comparator = null
		if (sort.equals('cliente')) {
			comparator = new Comparator<Pedido>() {
				public int compare(Pedido p1, Pedido p2) {
					return p1.cliente.compareTo(p2.cliente)
				}
			}
			if (order.equals("desc")) {
				comparator = Collections.reverseOrder(comparator)
			}
		}
		if (comparator != null) {
			Collections.sort(result, comparator)
		}
		result = ((max as Integer) <= 0 || (offset as Integer) < 0) ? [] : result.subList( Math.min( offset as Integer, totalRegistros), Math.min((offset as Integer) + (max as Integer), totalRegistros))
		params?.max = max
		params?.offset = offset
		params?.sort = sort
		params?.order = order
		return render(view: 'index', model: [pedidoInstanceList: result, pedidoInstanceTotal: totalRegistros])
	}
	
	def show = {
        def pedidoInstance = Pedido.get(new Long(params.id))
		def objetosInicializados = inicializarObjetosFormulario()
        return render(view: 'show', model:[pedido: pedidoInstance, clientes: objetosInicializados['clientes'], entregadores: objetosInicializados['entregadores'], produtos: objetosInicializados['produtos'], itensPedido: pedidoInstance.itens])
    }
	
	private inicializarObjetosFormulario() {
		def objetos = [:]
		objetos['clientes'] = inicializarClientes()
		objetos['entregadores'] = inicializarEntregadores()
		objetos['produtos'] = inicializarProdutos()
		return objetos
	}

	private List<Produto> inicializarProdutos() {
		return Produto.findAll("from Produto p where p in (select produto from ItemDia i where i.produto = p) order by nome")
	}

	private List<Entregador> inicializarEntregadores() {
		def listaEntregadores = Entregador.list()
		Collections.sort(listaEntregadores)
		return listaEntregadores
	}

	private List<Cliente> inicializarClientes() {
		def listaClientes = Cliente.list()
		Collections.sort(listaClientes)
		return listaClientes
	}

    def create() {
		def objetosInicializados = inicializarObjetosFormulario()
        def pedido = new Pedido()
        pedido.dataCadastro = new Date()
        pedido.valorPago = new BigDecimal(0);
        return render(view: 'create', model: [pedido: pedido, clientes: objetosInicializados['clientes'], entregadores: objetosInicializados['entregadores'], produtos: objetosInicializados['produtos']])
    }

    def save = {
        def pedidoInstance = cadastroService.criarPedido(params)
        if (pedidoInstance.hasErrors()) {
			def objetosInicializados = inicializarObjetosFormulario()
            def itensPedido = cadastroService.definirItensPedido(params)
            render(view:'create', model: [pedido: pedidoInstance, clientes: objetosInicializados['clientes'], entregadores: objetosInicializados['entregadores'], produtos: objetosInicializados['produtos'], itensPedido: itensPedido])
            return
        }
        redirect(action: "index")
    }

    def edit = {
        def pedidoInstance = Pedido.get(params.id)
		def objetosInicializados = inicializarObjetosFormulario()
        render(view:'edit', model:[pedido: pedidoInstance, clientes: objetosInicializados['clientes'], entregadores: objetosInicializados['entregadores'], produtos: objetosInicializados['produtos'], itensPedido: pedidoInstance.itens])
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
		def telefones = Telefone.findAll("FROM Telefone WHERE pessoa = :pessoa ORDER BY COALESCE(whatsapp, FALSE)", [pessoa: cliente.pessoa])
		def numeroRegistros = telefones.size()
		render ((numeroRegistros == 0) ? null : telefones[numeroRegistros - 1].numeroComMascara) as String
	}
	
	def carregarValorUnitario = {
		def preco = Preco.find("FROM Preco p1 WHERE p1.produto.id = :idProduto AND aPartirDe = (SELECT MAX(aPartirDe) FROM Preco p2 WHERE p2.produto.id = p1.produto.id AND p2.aPartirDe <= :data)", ['idProduto': new Long(params?.idProduto), 'data': Util.parse(params?.data)])
		render Util.formatCurrency(preco?.valor) as String
	}
    
}