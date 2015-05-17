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
        if (!pessoaInstance){
            pessoaInstance = new PessoaFisica()
        }
        pessoaInstance.properties = parametros
        pessoaInstance.save(flush: true)
        def idPessoa = pessoaInstance.id
        pessoaInstance = Pessoa.get(idPessoa)
        return pessoaInstance
    }
    
}
