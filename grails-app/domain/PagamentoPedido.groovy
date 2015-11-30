
public class PagamentoPedido {
	FormaPagamento formaPagamento
	Date dataPagamento
	BigDecimal valor
	Date registradoEm
	Usuario registradoPor
	
	static belongsTo = [pedido: Pedido];
	
	static mapping = {
		table 'tb_pagamento_pedido'
		version false
		id column: 'SEQ_PAGAMENTO', generator: 'increment'
		dataPagamento column: 'DAT_PAGAMENTO'
		valor column: 'VAL_PAGO'
		formaPagamento column: 'SEQ_FORMA_PAGAMENTO'
		pedido column: 'SEQ_PEDIDO'
		registradoEm column: 'DAT_REGISTRO'
		registradoPor column: 'SEQ_USUARIO_RESPONSAVEL_REGISTRO'		
	}
	
}