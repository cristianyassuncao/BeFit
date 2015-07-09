class Entregador implements Comparable {
    
    Pessoa pessoa
    String nome
    Date dataContratacao
    
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
        dataContratacao column: 'DAT_CONTRATACAO'
    }
    
    int compareTo(Object obj) {
        def entregador = (Entregador) obj
        def resultado = getNome().compareTo(entregador?.nome)
        if (resultado == 0) {
            resultado = getId().compareTo(entregador?.id)
        }
        return resultado
    }
    
}