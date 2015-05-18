import grails.transaction.Transactional

@Transactional
class CadastroService {
    
    boolean transactional = true
    
    def salvarCliente(params) {
        def pessoaInstance = definirPessoa(params)
        def clienteInstance = Cliente.get(params.id)
        if (!clienteInstance) {
            clienteInstance = new Cliente()
        }
        clienteInstance.properties = params
        clienteInstance.dataInclusao = new Date()
        clienteInstance.pessoa = pessoaInstance
        
        if (pessoaInstance.hasErrors()) {
            pessoaInstance.errors.getAllErrors().each {
                clienteInstance.errors.rejectValue('pessoa', 'pessoaError', it.toString())
            }
        }
        clienteInstance.save(flush: true)
        return clienteInstance
    }
       
    private Pessoa definirPessoa(params) {
        def parametros = [:]
        params.each {
            if (it.key.contains('pessoa.')) {
                parametros[it.key.replace('pessoa.', '')] = it.value
            }    
        }
        def pessoaInstance = Pessoa.get(parametros.id)
        def enderecoInstance = null
        if (!pessoaInstance){
            pessoaInstance = new PessoaFisica()
            enderecoInstance = definirEndereco(params)
        }
        pessoaInstance.properties = parametros
        if (pessoaInstance.save(flush: true)) {
            def idPessoa = pessoaInstance.id
            pessoaInstance = Pessoa.get(idPessoa)
            if (enderecoInstance != null) {
                pessoaInstance.addToEnderecos(enderecoInstance)
            }
        }    
        return pessoaInstance
    }
    
    private Endereco definirEndereco(params) {
        if (!params?.rua) return null
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
        def idTipoEndereco = params['tipo.id']
        if (idTipoEndereco != null) {
            enderecoInstance.tipo = TipoEndereco.get(idTipoEndereco)
        }    
        return enderecoInstance
    }
    
}
