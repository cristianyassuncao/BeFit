class FormaPagamento {

    String nome
           
    static mapping = {
        table 'tb_forma_pagamento'
        version false
        id column: 'SEQ_FORMA_PAGAMENTO', generator: 'increment'
        nome column: 'NOM_FORMA_PAGAMENTO'
    }
	
}
