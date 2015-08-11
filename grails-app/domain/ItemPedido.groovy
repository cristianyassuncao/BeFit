class ItemPedido {
    
    Produto produto
    BigDecimal quantidade
    BigDecimal valorUnitario
	BigDecimal valorItem
    Boolean pratoSofreuAlteracao
    String alteracaoPrato
    Boolean molhoSofreuAlteracao
    String alteracaoMolho

    static belongsTo = [pedido: Pedido]
	
	static transients = ["valorItem"]
    
    static constraints = {
		pratoSofreuAlteracao(nullable: true)
		alteracaoPrato(nullable: true)
		molhoSofreuAlteracao(nullable: true)
		alteracaoMolho(nullable: true)
    }
    
    static mapping = {
        table 'TB_ITEM_PEDIDO'
        version false
        id column: 'SEQ_ITEM_PEDIDO', generator: 'sequence', params:[sequence:'SEQ_ITEM_PEDIDO']
        pedido column: 'SEQ_PEDIDO'
        produto column: 'SEQ_PRODUTO'
        quantidade column: 'NUM_QUANTIDADE'
        valorUnitario column: 'VAL_UNITARIO'
        pratoSofreuAlteracao column: 'IND_PRATO_SOFREU_ALTERACAO'
        alteracaoPrato column: 'TXT_ALTERACAO_PRATO'
        molhoSofreuAlteracao column: 'IND_MOLHO_SOFREU_ALTERACAO'
        alteracaoMolho column: 'TXT_ALTERACAO_MOLHO'
    }
	
	public BigDecimal getValorItem() {
		return quantidade * valorUnitario
	}
    
}