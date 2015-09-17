class Cliente implements Comparable {
    
    Pessoa pessoa
    Date dataInclusao
    String nome
	String observacoes
    
    static transients=['nome']
 
    static constraints = {
        pessoa(unique: true)
		observacoes(nullable: true, blank: true)
    }
    
    static mapping = {
        table 'TB_CLIENTE'
        version false
        id column: 'SEQ_CLIENTE', generator: 'increment'
        pessoa column: 'SEQ_PESSOA'
        dataInclusao column: 'DAT_INCLUSAO'
		observacoes column: 'TXT_OBSERVACOES'
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
    
    int compareTo(Object obj) {
        def cliente = (Cliente) obj
        def resultado = getNome().compareTo(cliente?.nome)
        if (resultado == 0) {
            resultado = getId().compareTo(cliente?.id)
        }
        return resultado
    }
    
}