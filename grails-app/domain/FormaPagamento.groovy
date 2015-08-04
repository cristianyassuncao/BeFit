
class FormaPagamento {

    String nome
    
    static constraints = {
    }
    
    static mapping = {
        table 'TB_FORMA_PAGAMENTO'
        version false
        id column: 'SEQ_FORMA_PAGAMENTO', generator: 'sequence', params:[sequence:'SEQ_FORMA_PAGAMENTO']
        nome column: 'NOM_FORMA_PAGAMENTO'
    }
	
}
