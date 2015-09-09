import static org.springframework.http.HttpStatus.*

import java.text.SimpleDateFormat;
import java.util.Collections.ReverseComparator

import org.apache.jasper.compiler.Node.ParamsAction;

import grails.transaction.Transactional
import grails.converters.*;

@Transactional(readOnly = true)
class PedidoController {
    
	SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy")
	
    def cadastroService
	
	static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]

    def index = {
		def max = Math.min( params.max ? params.max.toInteger() : 30, 100)
		def offset = params.offset ?: 0
		def sort = params.sort
		def order = params.order
		params?.max = null
		params?.offset = null
		if (params?.sort in ['cliente', 'entregador', 'bairro']) {
			params?.sort = null
			params?.order = null
		}
		def statusList = definirFiltroPorStatus(params.list('status'))
		def result = Pedido.createCriteria().list(params) {
			if (params.numeroTelefone != null && params.numeroTelefone != "") {
                cliente {
					pessoa {
	                    telefones {
	                        eq("numero", Telefone.removerMascara(params.numeroTelefone))
	                    }
					}	
                }
            }
			if (params.cliente != null && params.cliente != "") {
				cliente {
					eq("id", new Long(params.cliente))
				}
			}
			if (params.entregador != null && params.entregador != "") {
				entregador {
					eq("id", new Long(params.entregador))
				}
			}
			if (params.dataEntrega != null && params.dataEntrega != "") {
				eq("dataEntrega", formatoData.parse(params.dataEntrega))
			}
			if (params.status != null) {
				inList("status", statusList)
			}
			if (params.pago != null) {
				eqProperty("valorAPagar", "valorPago")
			}
		}
		def totalRegistros = result.totalCount
		def comparator = definirComparator(sort, order)
		if (comparator != null) {
			Collections.sort(result, comparator)
		}
		result = ((max as Integer) <= 0 || (offset as Integer) < 0) ? [] : result.subList( Math.min( offset as Integer, totalRegistros), Math.min((offset as Integer) + (max as Integer), totalRegistros))
		params?.max = max
		params?.offset = offset
		params?.sort = sort
		params?.order = order
		
		return render(view: 'index', model: [pedidoInstanceList: result, pedidoInstanceTotal: totalRegistros, clientes: inicializarClientes(), entregadores: inicializarEntregadores()])
	}
	
	boolean hasParametrosDefinidos(params) {
		
	}
	
	private List<StatusPedido> definirFiltroPorStatus(statusSelecionados) {
		def statusList = []
		statusSelecionados.each {
			statusList.add(StatusPedido.valueOf(it))
		}
		return statusList
	}
	
	private Comparator definirComparator(String sort, String order) {
		def comparator = null
		if (sort.equals('cliente')) {
			comparator = new Comparator<Pedido>() {
				public int compare(Pedido p1, Pedido p2) {
					return p1?.cliente?.compareTo(p2?.cliente)
				}
			}
		}
		if (sort.equals('entregador')) {
			comparator = new Comparator<Pedido>() {
				public int compare(Pedido p1, Pedido p2) {
					return p1?.entregador?.compareTo(p2?.entregador)
				}
			}
		}
		if (sort.equals('bairro')) {
			comparator = new Comparator<Pedido>() {
				public int compare(Pedido p1, Pedido p2) {
					return p1?.endereco?.bairro?.compareTo(p2?.endereco?.bairro)
				}
			}
		}
		if (comparator != null && order.equals("desc")) {
			comparator = Collections.reverseOrder(comparator)
		}
		return comparator 
    }
	
	def show = {
        def pedidoInstance = Pedido.get(new Long(params.id))
        return render(view: 'show', model:[pedido: pedidoInstance, clientes: [pedidoInstance.cliente], entregadores: [pedidoInstance.entregador], itensPedido: pedidoInstance.itens])
    }
	
	private inicializarObjetosFormulario(Date data) {
		def objetos = [:]
		objetos['clientes'] = inicializarClientes()
		objetos['entregadores'] = inicializarEntregadores()
		objetos['produtos'] = inicializarProdutos(data)
		return objetos
	}

	private List<Produto> inicializarProdutos(Date data) {
		if (data == null) {
			return carregarTodosProdutos();
		}
		return carregarItemsDoDia(data);
	}
	
	private List<Produto> carregarTodosProdutos() {
		return Produto.findAll("from Produto p order by nome")
	}
	
	private List<Produto> carregarItemsDoDia(Date data) {
		return Produto.findAll("from Produto as p where p in (select produto from ItemDia as i where i.data = :data) order by nome", ['data': data])
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

    def create = {
        def pedido = new Pedido()
        pedido.dataCadastro = new Date()
        pedido.valorPago = new BigDecimal(0)
		pedido.status = StatusPedido.A
		def objetosInicializados = inicializarObjetosFormulario(pedido.dataCadastro)
        return render(view: 'create', model: [pedido: pedido, clientes: objetosInicializados['clientes'], entregadores: objetosInicializados['entregadores'], produtos: objetosInicializados['produtos']])
    }

    def save = {
        def pedidoInstance = cadastroService.atualizarPedido(params)
        if (pedidoInstance.hasErrors()) {
			def objetosInicializados
			if (params.exibirSomenteOpcoesDia) {
				objetosInicializados = inicializarObjetosFormulario(pedidoInstance?.dataEntrega)
			} else { 
				objetosInicializados = inicializarObjetosFormulario()
			}
			def itensPedido = cadastroService.definirItensPedido(params)
            render(view:'create', model: [pedido: pedidoInstance, clientes: objetosInicializados['clientes'], entregadores: objetosInicializados['entregadores'], produtos: objetosInicializados['produtos'], itensPedido: itensPedido])
            return
        }
        redirect(action: "index")
    }

    def edit = {
        def pedidoInstance = Pedido.get(params.id)
		def objetosInicializados = inicializarObjetosFormulario(pedidoInstance?.dataEntrega)
        render(view:'edit', model:[pedido: pedidoInstance, clientes: objetosInicializados['clientes'], entregadores: objetosInicializados['entregadores'], produtos: objetosInicializados['produtos'], itensPedido: pedidoInstance.itens])
    }

    def update =  {
		def pedidoInstance = cadastroService.atualizarPedido(params)
		if (pedidoInstance.hasErrors()) {
			def objetosInicializados
			if (params.exibirSomenteOpcoesDia) {
				objetosInicializados = inicializarObjetosFormulario(pedidoInstance?.dataEntrega)
			} else {
				objetosInicializados = inicializarObjetosFormulario()
			}
			def itensPedido = cadastroService.definirItensPedido(params)
			render(view:'edit', model: [pedido: pedidoInstance, clientes: objetosInicializados['clientes'], entregadores: objetosInicializados['entregadores'], produtos: objetosInicializados['produtos'], itensPedido: itensPedido])
			return
		}
		redirect(action: "index")
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
        render(template: 'dadosComplementares', model: ['cliente': cliente, 'endereco': enderecoEntrega, 'telefones': cliente?.pessoa?.telefones, 'observacoes': cliente?.observacoes])
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
		if (preco == null) {
			render "" as String
		} else {
			render Util.formatCurrency(preco?.valor) as String
		}	
	}
	
	def recarregarListaProdutos = {
		def resultado = []
		if (params.data == null) {
			resultado = carregarTodosProdutos()
		} else {
			resultado = carregarItemsDoDia(formatoData.parse(params.data))
		}
		String produtosJSON = resultado.collect {
			[codigo: it?.id,
			 nome: it?.nome
			]
		} as JSON
		render produtosJSON
	}
    
}