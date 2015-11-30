import javax.swing.text.MaskFormatter

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
    EnderecoPedido endereco
    TelefonePedido telefone	
    StatusPedido status
	Boolean pago
    
    static embedded = ['endereco', 'telefone']
	
	static transients = ['pago']
           
    static hasMany = [itens: ItemPedido, pagamentos: PagamentoPedido]
    
    static constraints = {
        cliente(nullable: true)
		entregador(nullable: true)
        entregarAPartirDaHora(nullable: true)
		entregarAteHora(nullable: true)
        telefone(nullable: true)
        trocoPara(nullable: true, validator: {val, obj -> return (val == null || obj?.valorAPagar == null) ? null : val?.compareTo(obj?.valorAPagar) > 0})
        valorTroco(nullable: true)
        valorPago(nullable: true, validator: {val, obj -> return (val == null || obj?.valorAPagar == null) ? null : val?.compareTo(obj?.valorAPagar) <= 0})
    }
    
    static mapping = {
        table 'tb_pedido'
        version false
        id column: 'SEQ_PEDIDO', generator: 'increment'
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
        status column: 'TXT_STATUS'
        entregador column: 'SEQ_ENTREGADOR'
		pagamentos joinTable: false, column: 'SEQ_PEDIDO', cascade:"all-delete-orphan"
        itens joinTable: false, column: 'SEQ_PEDIDO', cascade:"all-delete-orphan"
    }
	
	Boolean isPago() {
		return valorAPagar.equals(valorPago)
	}
        
}

class EnderecoPedido {
    String rua
    String numero
    String complemento
    Long idBairro
    String pontoReferencia
    
    static transients = ["bairro"]
	
	static mapping = {
        columns {
            rua column: 'TXT_ENDERECO'
            numero column: 'TXT_NUMERO_ENDERECO'
            complemento column: 'TXT_COMPLEMENTO'
            idBairro column: 'SEQ_BAIRRO'
            pontoReferencia column: 'TXT_PONTO_REFERENCIA'
        }
    }
    
    public Bairro getBairro() {
        return Bairro.get(idBairro)
    }
        
}

class TelefonePedido {
    
    String numero
    String numeroComMascara
    
    static transients =['numeroComMascara']
    
    static mapping = {
        columns {
            numero column: 'TXT_NUMERO_TELEFONE'
        }
    }
        
    public String getNumeroComMascara() {
        String phoneMask= "(##) #####-####";
        MaskFormatter maskFormatter= new MaskFormatter(phoneMask);
        maskFormatter.setValueContainsLiteralCharacters(false);
        return maskFormatter.valueToString(numero) ;   
    }
    
}