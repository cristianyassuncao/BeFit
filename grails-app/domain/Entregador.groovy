class Entregador {
    
    Pessoa pessoa
    String nome
    
    static transients=['nome']
    
    static constraints = {
    }
    
    String getNome() {
        if (pessoa != null) {
            if (pessoa.instanceOf(PessoaFisica)) {
                return pessoa?.nome?.toUpperCase()
            }
            return pessoa?.razaoSocial?.toUpperCase()
        }
        return null
    }
    
    static mapping = {
        table 'TB_ENTREGADOR'
        version false
        id column: 'SEQ_ENTREGADOR', generator: 'sequence', params:[sequence:'SEQ_ENTREGADOR']
        pessoa column: 'SEQ_PESSOA'
    }
    
}