class Cidade {
    
    String nome
    UF uf

    static constraints = {
    }
    
    static mapping = {
        table 'tb_cidade'
        version false
        id column: 'SEQ_CIDADE', generator: 'increment'
        nome column: 'NOM_CIDADE'
        uf column: 'SEQ_UF'
    }
}
