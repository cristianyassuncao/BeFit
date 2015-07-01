class ItemPedido {
    
    Produto produto
    BigDecimal quantidade
    BigDecimal valorUnitario
    Boolean pratoSofreuAlteracao
    String alteracaoPrato
    Boolean molhoSofreuAlteracao
    String alteracaoMolho

    static belongsTo = [pedido: Pedido]
    
    static constraints = {
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
    
}