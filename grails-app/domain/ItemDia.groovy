class ItemDia {
    
    Produto produto
	Date data
    
	static constraints = {
		produto unique: 'data'
    }
    
    static mapping = {
        table 'tb_item_dia'
        version false
        id column: 'SEQ_ITEM_DIA', generator: 'increment'
        produto column: 'SEQ_PRODUTO'
        data column: 'DAT_DIA'
    }
    
}