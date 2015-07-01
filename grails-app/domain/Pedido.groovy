
class Pedido {
    
    Cliente cliente
    Date dataCadastro
    Date dataEntrega
    BigDecimal valorAPagar
    BigDecimal valorTroco
    Boolean requerTalher
    Date entregarAPartirDaHora
    Date entregarAteHora
    String observacao
    BigDecimal numeroVolumes
    Entregador responsavelEntrega
    
    static hasMany = [itens: ItemPedido]

    static constraints = {
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
        requerTalher column: 'IND_REQUER_TALHER'
        entregarAPartirDaHora column: 'DTH_ENTREGAR_A_PARTIR_DE'
        entregarAteHora column: 'DTH_ENTREGAR_ATE'
        observacao column: 'TXT_OBSERVACAO'
        numeroVolumes column: 'NUM_VOLUMES'
        responsavelEntrega column: 'SEQ_ENTREGADOR'
        itens joinTable: false, column: 'SEQ_PEDIDO', cascade:"all-delete-orphan"
    }
        
}