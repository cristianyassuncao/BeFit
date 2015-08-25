public enum StatusPedido {

	A('Aberto'),
	C('Cancelado'),
	D('Despachado'),
	E('Entregue')

	private final String descricao
	
	public StatusPedido(String descricao) {
		this.descricao = descricao
	}
	
	@Override
	public String toString() {
		return descricao;
	}
	
}