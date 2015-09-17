class Entregador implements Comparable {
    
    Pessoa pessoa
    String nome
    Date dataContratacao
	String observacoes
    
    static transients=['nome']
    
    static constraints = {
		observacoes(nullable: true, blank: true)
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
        table 'tb_entregador'
        version false
        id column: 'SEQ_ENTREGADOR', generator: 'increment'
        pessoa column: 'SEQ_PESSOA'
        dataContratacao column: 'DAT_CONTRATACAO'
		observacoes column: 'TXT_OBSERVACOES'
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