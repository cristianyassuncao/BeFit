class UF {
    
    String nome
    String sigla

    static constraints = {
    }
    
    static mapping = {
        table 'TB_UF'
        version false
        id column: 'SEQ_UF', generator: 'sequence', params:[sequence:'SEQ_UF']
        descricao column: 'NOM_UF'
        sigla column: 'TXT_SIGLA'
    }
}
