
public class LancamentoSobrePedidos {
	
	Pedido pedido
	
	static mapping = {
		columns {
			pedido joinTable:false, column: 'SEQ_PEDIDO'
		}
	}
	
}