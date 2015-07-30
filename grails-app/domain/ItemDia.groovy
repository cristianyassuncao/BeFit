class ItemDia {
    
    Produto produto
	Date data
    
	static constraints = {
    }
    
    static mapping = {
        table 'TB_ITEM_DIA'
        version false
        id column: 'SEQ_ITEM_DIA', generator: 'sequence', params:[sequence:'SEQ_ITEM_DIA']
        produto column: 'SEQ_PRODUTO'
        data column: 'DAT_DIA'
    }
    
}