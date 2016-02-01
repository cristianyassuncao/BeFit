
class Operacao {

	String nome
	
	static hasMany = [formasPagamento: FormaPagamento]
		
	static mapping = {
		table 'tb_operacao'
		version false
		id column: 'SEQ_OPERACAO', generator: 'increment'
		nome column: 'NOM_OPERACAO'
		formasPagamento joinTable: [name: 'tb_operacao_forma_pagamento', key: 'SEQ_OPERACAO', column: 'SEQ_FORMA_PAGAMENTO']
	}
    
}
