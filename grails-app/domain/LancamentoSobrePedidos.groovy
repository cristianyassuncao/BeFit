
public class LancamentoSobrePedidos extends Lancamento {
	
	Pedido pedido
	
	static mapping = {
		columns {
			pedido joinTable:false, column: 'SEQ_PEDIDO'
		}
	}
	
}