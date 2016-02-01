
public enum TipoOperacao {
	
	E("Entrada"),
	S("Saída"),
	N("Nula")
	
	private final String descricao
	
	public TipoOperacao(String descricao) {
		this.descricao = descricao
	}

}
