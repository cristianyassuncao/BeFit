public enum StatusPedido implements Comparable {

	A('Aberto'),
	C('Cancelado'),
	D('Despachado'),
	E('Entregue')

	private final String descricao
	
	public StatusPedido(String descricao) {
		this.descricao = descricao
	}
	
}