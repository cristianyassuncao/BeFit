
public enum TipoOperacao {
	
	E("Entrada"),
	S("Sa�da"),
	N("Nula")
	
	private final String descricao
	
	public TipoOperacao(String descricao) {
		this.descricao = descricao
	}

}
