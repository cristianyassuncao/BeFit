class UF {
    
    String nome
    String sigla

    static constraints = {
    }
    
    static mapping = {
        table 'tb_uf'
        version false
        id column: 'SEQ_UF', generator: 'increment'
        descricao column: 'NOM_UF'
        sigla column: 'TXT_SIGLA'
    }
}
