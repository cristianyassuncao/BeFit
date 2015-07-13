
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
    
    static embedded = ['endereco', 'telefone']
           
    static hasMany = [itens: ItemPedido]
    
    static constraints = {
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
        itens joinTable: false, column: 'SEQ_PEDIDO', cascade:"all-delete-orphan"
    }
        
}

class EnderecoPedido {
    String rua
    String numero
    String complemento
    Bairro bairro
    String cep
    String pontoReferencia
    String cepComMascara
    
    static transients = ["cepComMascara"]
    
    static mapping = {
        columns {
            rua column: 'TXT_ENDERECO'
            numero column: 'TXT_NUMERO_ENDERECO'
            complemento column: 'TXT_COMPLEMENTO'
            bairro column: 'SEQ_BAIRRO', type: Long
            cep column: 'TXT_CEP'
            pontoReferencia column: 'TXT_PONTO_REFERENCIA'
        }
    }
        
    public String getCepComMascara() {
        String cepMask= "#####-###";
        MaskFormatter maskFormatter= new MaskFormatter(cepMask);
        maskFormatter.setValueContainsLiteralCharacters(false);
        return maskFormatter.valueToString(cep) ;   
    }
   
}

class TelefonePedido {
    
    String numero
    String numeroComMascara
    
    static transients =['numeroComMascara']
    
    static constraints = {
	 numero(nullable: false, blank: false)
    }
    
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