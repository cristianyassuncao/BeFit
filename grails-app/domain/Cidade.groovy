class Cidade {
    
    String nome
    UF uf

    static constraints = {
    }
    
    static mapping = {
        table 'TB_CIDADE'
        version false
        id column: 'SEQ_CIDADE', generator: 'increment'
        nome column: 'NOM_CIDADE'
        uf column: 'SEQ_UF'
    }
}
