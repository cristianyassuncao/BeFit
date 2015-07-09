class Pedido {
    
    Cliente cliente
    Date dataCadastro
    Date dataEntrega
    BigDecimal valorAPagar
    BigDecimal valorTroco
    BigDecimal valorPago
    BigDecimal trocoPara
    Boolean requerTalher
    Date entregarAPartirDaHora
    Date entregarAteHora
    String observacao
    BigDecimal numeroVolumes
    Entregador entregador
    Endereco enderecoEntrega
    Telefone telefone
    
    static hasMany = [itens: ItemPedido]
    
    static constraints = {
        enderecoEntrega(nullable: true)
        telefone(nullable: true)
        cliente(nullable: true)
        entregarAPartirDaHora(nullable: true)
        telefone(nullable: true)
    }
    
    static mapping = {
        table 'TB_PEDIDO'
        version false
        id column: 'SEQ_PEDIDO', generator: 'sequence', params:[sequence:'SEQ_PEDIDO']
        cliente column: 'SEQ_CLIENTE'
        dataCadastro column: 'DTH_CADASTRO'
        dataEntrega column: 'DTH_ENTREGA'
        valorAPagar column: 'VAL_PAGAR'
        valorTroco column: 'VAL_TROCO'
        valorPago column: 'VAL_PAGO'
        trocoPara column: 'VAL_TROCO_PARA'
        requerTalher column: 'IND_REQUER_TALHER'
        entregarAPartirDaHora column: 'DTH_ENTREGAR_A_PARTIR_DE'
        entregarAteHora column: 'DTH_ENTREGAR_ATE'
        observacao column: 'TXT_OBSERVACAO'
        numeroVolumes column: 'NUM_VOLUMES'
        entregador column: 'SEQ_ENTREGADOR'
        enderecoEntrega column: 'SEQ_ENDERECO'
        telefone column: 'SEQ_TELEFONE'
        itens joinTable: false, column: 'SEQ_PEDIDO', cascade:"all-delete-orphan"
    }
        
}