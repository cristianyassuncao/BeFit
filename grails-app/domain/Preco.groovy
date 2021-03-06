class Preco implements Comparable {
    
    BigDecimal valor
    Date aPartirDe
    
    static belongsTo = [produto: Produto]

    static constraints = {
        aPartirDe unique: 'produto'
        valor(nullable: false, blank: false)
    }
   
    static mapping = {
        table 'TB_PRECO'
        version false
        id column: 'SEQ_PRECO', generator: 'sequence', params:[sequence:'SEQ_PRECO']
        valor column: 'VAL_VALOR'
        aPartirDe column: 'DAT_APARTIRDE'
        produto column: 'SEQ_PRODUTO'
    }
    
    int compareTo(Object obj) {
        def preco = (Preco) obj
        return aPartirDe.compareTo(preco?.aPartirDe)
    }
     
}
