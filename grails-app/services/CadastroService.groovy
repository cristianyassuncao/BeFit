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
        def decimalFormat = new java.text.DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale ("pt", "BR")));
        return decimalFormat.parse(valor)
    }   
    
    def criarPedido(params) {
        def pedidoInstance = new Pedido()
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
        pedidoInstance.valorTroco = toBigDecimal(params?.trocoPara) - pedidoInstance.valorAPagar
        pedidoInstance.valorPago = toBigDecimal(params?.valorPago)
        pedidoInstance.requerTalher = params?.requerTalher
        pedidoInstance.observacao = params?.observacao
        pedidoInstance.numeroVolumes = params?.numeroVolumes
        pedidoInstance.entregador = (params?.entregador?.id == null) ? null : Entregador.get(params?.entregador?.id)
        pedidoInstance.enderecoEntrega = (params?.enderecoEntrega?.id == null) ? null : Endereco.get(params?.enderecoEntrega?.id)
        pedidoInstance.telefone = (params?.telefone?.id == null) ? null : Telefone.get(params?.telefone?.id)
        pedidoInstance.entregarAPartirDaHora = entregarAPartirDaHora
        pedidoInstance.entregarAteHora = entregarAteHora
        pedidoInstance.validate()
        if (!pedidoInstance.hasErrors()) {
            pedidoInstance.save(flush: true)
        }
        println pedidoInstance.errors
        return pedidoInstance
    }
    
    def definirItensPedido(params) {
        return []
    }
   
}