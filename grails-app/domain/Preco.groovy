class Preco {
    
    BigDecimal valor
    Date aPartirDe
    
    static belongsTo = [produto: Produto]

    static constraints = {
    }
   
    static mapping = {
        table 'TB_PRECO'
        version false
        id column: 'SEQ_PRECO', generator: 'sequence', params:[sequence:'SEQ_PRECO']
        valor column: 'VAL_VALOR'
        aPartirDe column: 'DAT_APARTIRDE'
        produto column: 'SEQ_PRODUTO'
    }
    
}
