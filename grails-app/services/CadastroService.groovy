import grails.transaction.Transactional
import java.text.DecimalFormatSymbols
import java.text.SimpleDateFormat
import java.sql.Time

@Transactional
class CadastroService {

    SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy")
    
    def messageSource
           
    boolean transactional = true
    
    def definirCliente(params, pessoaInstance) {
        def clienteInstance = Cliente.get(params.id)
        if (!clienteInstance) {
            clienteInstance = new Cliente()
        }
        clienteInstance.properties = params
        clienteInstance.dataInclusao = new Date()
        clienteInstance.pessoa = pessoaInstance
        clienteInstance.validate()
        if (pessoaInstance.hasErrors()) {
            pessoaInstance.errors.getAllErrors().each {
                clienteInstance.errors.rejectValue('pessoa', 'pessoaError', messageSource.getMessage(it, null))
            }
        }
        if (!clienteInstance.hasErrors()) {
            clienteInstance.save(flush: true)
        }
        return clienteInstance
    }
    
    def criarCliente(params) {
        def pessoaInstance = definirCadastroCompletoPessoa(params)
        return definirCliente(params, pessoaInstance)
    }
       
    private Pessoa definirCadastroCompletoPessoa(params) {
        def parametros = [:]
        params.each {
            if (it.key.contains('pessoa.')) {
                parametros[it.key.replace('pessoa.', '')] = it.value
            }    
        }
        def pessoaInstance = Pessoa.get(parametros.id)
        def enderecoInstance = null
        def telefoneInstance = null
        if (!pessoaInstance){
            pessoaInstance = new PessoaFisica()
            enderecoInstance = definirEndereco(params)
            telefoneInstance = definirTelefone(params)
        }
        pessoaInstance.properties = parametros
        pessoaInstance.validate()
        if (enderecoInstance != null && !enderecoInstance?.validate()) {
            enderecoInstance.errors.getAllErrors().each {
                if (!it.getField().equals("pessoa")) {
                    pessoaInstance.errors.rejectValue('enderecos', 'enderecoError', messageSource.getMessage(it, null))
                }
            }
        }
        if (telefoneInstance != null && !telefoneInstance?.validate()) {
            telefoneInstance.errors.getAllErrors().each {
                if (!it.getField().equals("pessoa")) {
                    pessoaInstance.errors.rejectValue('telefones', 'telefoneError', messageSource.getMessage(it, null))
                }
            }
        }
        if (!pessoaInstance.hasErrors()) {
            pessoaInstance.save(flush: true)
            def idPessoa = pessoaInstance.id
            pessoaInstance = Pessoa.get(idPessoa)
            if (enderecoInstance != null) {
                pessoaInstance.addToEnderecos(enderecoInstance)
            }
            if (telefoneInstance != null) {
                pessoaInstance.addToTelefones(telefoneInstance)
            }
        }
        return pessoaInstance
    }
    
    public Endereco definirEndereco(params) {
        def enderecoInstance = new Endereco()
        enderecoInstance.rua = params?.rua
        enderecoInstance.numero = params?.numero
        enderecoInstance.complemento = params?.complemento
        def idBairro = params['bairro.id']
        if (idBairro != null) {
            enderecoInstance.bairro = Bairro.get(idBairro)
        }    
        enderecoInstance.cep = params?.cep?.replace("-","") 
        enderecoInstance.pontoReferencia = params?.pontoReferencia
        def idTipoEndereco = params['tipoEndereco.id']
        if (idTipoEndereco != null) {
            enderecoInstance.tipoEndereco = TipoEndereco.get(idTipoEndereco)
        }    
        return enderecoInstance
    }
    
    public Telefone definirTelefone(params) {
        def telefoneInstance = new Telefone()
        telefoneInstance.numero = Telefone.removerMascara(params?.numeroTelefone)
        telefoneInstance.whatsapp = (params?.whatsapp == null ? false : params?.whatsapp)
        def idTipoTelefone = params['tipoTelefone.id']
        if (idTipoTelefone != null) {
            telefoneInstance.tipoTelefone = TipoTelefone.get(idTipoTelefone)
        }    
        return telefoneInstance
    }
    
    def salvarCliente(params) {
        def pessoaInstance = definirCadastroBasicoPessoa(params)
        return definirCliente(params, pessoaInstance)
    }
    
    private Pessoa definirCadastroBasicoPessoa(params) {
        def parametros = [:]
        params.each {
            if (it.key.contains('pessoa.')) {
                parametros[it.key.replace('pessoa.', '')] = it.value
            }    
        }
        def pessoaInstance = Pessoa.get(parametros.id)
        if (!pessoaInstance){
            pessoaInstance = new PessoaFisica()
        }
        pessoaInstance.properties = parametros
        pessoaInstance.validate()
        if (!pessoaInstance.hasErrors()) {
            pessoaInstance.save(flush: true)
            def idPessoa = pessoaInstance.id
            pessoaInstance = Pessoa.get(idPessoa)
        }
        return pessoaInstance
    }
    
    public criarProduto(params) {
        def produtoInstance = definirProduto(params)
        def precoInstance = definirPreco(params.valor)
        if (precoInstance != null && !precoInstance?.validate()) {
            precoInstance.errors.getAllErrors().each {
                if (!it.getField().equals("produto")) {
                    produtoInstance.errors.rejectValue('precos', 'precoError', messageSource.getMessage(it, null))
                }
            }
        }
        if (!produtoInstance.hasErrors()) {
            produtoInstance.save flush:true
            produtoInstance.addToPrecos(precoInstance)
        }
        return produtoInstance
    }
    
    private definirProduto(params) {
        def produtoInstance = Produto.get(params.id)
        if (!produtoInstance) {
            produtoInstance = new Produto()
        }
        def imagemAnterior = produtoInstance?.imagem
        def tipoImagemAnterior = produtoInstance?.tipoImagem
        produtoInstance.properties = params
        produtoInstance.imagem = imagemAnterior
        produtoInstance.tipoImagem = tipoImagemAnterior
        def novaImagem = params.imagemFile
        if (!novaImagem.isEmpty()) { 
            produtoInstance.imagem = novaImagem.getBytes()
            produtoInstance.tipoImagem = novaImagem.contentType
        } 
        produtoInstance.validate()
        return produtoInstance
    }
    
    public salvarProduto(params) {
        def produtoInstance = definirProduto(params)
        if (!produtoInstance.hasErrors()) {
            produtoInstance.save flush:true
        }
        return produtoInstance
    }
    
    public Preco definirPreco(valor) {
        def precoInstance = new Preco()
        precoInstance.aPartirDe = new Date()
        precoInstance.valor = toBigDecimal(valor)
        return precoInstance
    }
    
    public BigDecimal toBigDecimal(String valor) {
        if (valor == "" || valor == null) {
            return null;
        }
        return Util.parseCurrency(valor)
    }   
    
    def atualizarPedido(params) {
		def pedidoInstance = Pedido.get(params.id)
		if (!pedidoInstance) {
			pedidoInstance = new Pedido()
		}
        Date entregarAPartirDaHora = null
        Date entregarAteHora = null
        if (!params.entregarAPartirDaHora.equals('')) {
            entregarAPartirDaHora = Time.valueOf(params.entregarAPartirDaHora + ':00')
        }
        if (!params.entregarAteHora.equals('')) { 
            entregarAteHora = Time.valueOf(params.entregarAteHora + ':00')
        }
        pedidoInstance.cliente = (params?.cliente?.id == null) ? null : Cliente.get(params?.cliente?.id)
        pedidoInstance.dataCadastro = formatoData.parse(params?.dataCadastro)
        pedidoInstance.dataEntrega = formatoData.parse(params?.dataEntrega)
        pedidoInstance.valorAPagar = toBigDecimal(params?.valorAPagar)
        pedidoInstance.trocoPara = toBigDecimal(params?.trocoPara)
        pedidoInstance.valorTroco = toBigDecimal(params?.valorTroco)
        pedidoInstance.valorPago = toBigDecimal(params?.valorPago)
        pedidoInstance.requerTalher = (params?.requerTalher == null ? false : params?.requerTalher)
        pedidoInstance.observacao = params?.observacao
        pedidoInstance.numeroVolumes = toBigDecimal(params?.numeroVolumes)
        pedidoInstance.entregador = (params?.entregador?.id == null) ? null : Entregador.get(params?.entregador?.id)
        pedidoInstance.entregarAPartirDaHora = entregarAPartirDaHora
        pedidoInstance.entregarAteHora = entregarAteHora
        pedidoInstance.status = params?.status
		pedidoInstance.formaPagamento = (params?.formaPagamento == null) ? null : FormaPagamento.get(params?.formaPagamento)
        pedidoInstance.endereco = definirEnderecoPedido(params)
        pedidoInstance.telefone = definirTelefonePedido(params)
        pedidoInstance.validate()
		incluirItensPedido(pedidoInstance, params)
        if (!pedidoInstance.hasErrors()) {
			pedidoInstance.save(flush: true)
        }
        return pedidoInstance
    }
	
	private incluirItensPedido(pedidoInstance, params) {
		removerItensPedido(pedidoInstance)
		def itensPedido = definirItensPedido(params)
		validarItensDoPedido(itensPedido, pedidoInstance)
		if (!pedidoInstance.hasErrors()) {
			itensPedido?.each {i ->
				pedidoInstance.addToItens(i)
			}
		}	
	}
	
	private removerItensPedido(Pedido pedidoInstance) {
		pedidoInstance?.itens?.clear()
	}

	private validarItensDoPedido(itensPedido, Pedido pedidoInstance) {
		if (itensPedido.size() > 0) {
			itensPedido.each {i ->
				i.validate();
				i.errors.getAllErrors().each {e ->
					if (!e.getField().equals("pedido")) {
						pedidoInstance.errors.rejectValue('itens', 'itemError', messageSource.getMessage(e, null))
					}
				}
			}
		}
	}
    
    def definirItensPedido(params) {
		def produto = params.list("itemPedido.produto")
		def quantidade = params.list("itemPedido.quantidade")
		def valorUnitario = params.list("itemPedido.valorUnitario")
		def valorTotalItem = params.list("itemPedido.valorTotalItem")
		def alteracaoPrato = params.list("itemPedido.alteracaoPrato")
		def alteracaoMolho = params.list("itemPedido.alteracaoMolho")
				
		def numeroItens = produto?.size()
		def itens = []
		for (int i = 0; i < numeroItens; i++) {
			itens << definirItemPedido(produto[i], quantidade[i], valorUnitario[i], valorTotalItem[i], alteracaoPrato[i], alteracaoMolho[i])
		}	
        return itens
    }
	
	def definirItemPedido(produto, quantidade, valorUnitario, valorTotalItem, alteracaoPrato, alteracaoMolho) {
		def itemPedido = new ItemPedido()
		if (produto != null) {
			itemPedido.produto = Produto.get(produto)
		}
		itemPedido.quantidade = toBigDecimal(quantidade)
		itemPedido.valorUnitario = toBigDecimal(valorUnitario)
		itemPedido.alteracaoPrato = alteracaoPrato
		itemPedido.alteracaoMolho = alteracaoMolho
		return itemPedido
	}
    
    def definirTelefonePedido(params) {
        def telefonePedido = new TelefonePedido()
        telefonePedido.numero = Telefone.removerMascara(params["telefone.numeroTelefone"])
        return telefonePedido
    }
    
    def definirEnderecoPedido(params) {
        def enderecoPedido = new EnderecoPedido()
        enderecoPedido.rua = params["endereco.rua"]
        enderecoPedido.numero = params["endereco.numero"]
        enderecoPedido.complemento = params["endereco.complemento"]
        enderecoPedido.pontoReferencia = params["endereco.pontoReferencia"]
		def idBairro = params["endereco.bairro.id"]
		if (idBairro != null && !idBairro.equals("")) {
			enderecoPedido.idBairro = new Long(idBairro)
		}
        return enderecoPedido
    }
	
	def criarEntregador(params) {
		def pessoaInstance = definirCadastroCompletoPessoa(params)
		return definirEntregador(params, pessoaInstance)
	}
	
	def definirEntregador(params, pessoaInstance) {
		def entregadorInstance = Entregador.get(params.id)
		if (!entregadorInstance) {
			entregadorInstance = new Entregador()
		}
		entregadorInstance.properties = params
		entregadorInstance.pessoa = pessoaInstance
		entregadorInstance.validate()
		if (pessoaInstance.hasErrors()) {
			pessoaInstance.errors.getAllErrors().each {
				entregadorInstance.errors.rejectValue('pessoa', 'pessoaError', messageSource.getMessage(it, null))
			}
		}
		if (!entregadorInstance.hasErrors()) {
			entregadorInstance.save(flush: true)
		}
		return entregadorInstance
	}
	
	def salvarEntregador(params) {
		def pessoaInstance = definirCadastroBasicoPessoa(params)
		return definirEntregador(params, pessoaInstance)
	}
	
}