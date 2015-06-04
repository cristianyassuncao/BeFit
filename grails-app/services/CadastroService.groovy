import grails.transaction.Transactional

@Transactional
class CadastroService {
    
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
        def file = params.imagem
        produtoInstance.properties = params
        produtoInstance.imagem = file.getBytes()
        produtoInstance.tipoImagem = file.contentType
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
        precoInstance.valor = valor
        return precoInstance
    }
           
}