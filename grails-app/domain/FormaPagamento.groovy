
class FormaPagamento {

    String nome
    
    static constraints = {
    }
    
    static mapping = {
        table 'TB_FORMA_PAGAMENTO'
        version false
        id column: 'SEQ_FORMA_PAGAMENTO', generator: 'increment'
        nome column: 'NOM_FORMA_PAGAMENTO'
    }
	
}
