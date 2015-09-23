class Produto implements Comparable {
    
    String nome
    String descricao
    byte[] imagem
    String tipoImagem
    SortedSet precos
    
    static hasMany = [categorias: CategoriaProduto, precos: Preco]

    static constraints = {
        nome(nullable: false, blank: false)
        descricao(nullable: true, blank: true)
        imagem(nullable: true, blank: true)
        tipoImagem(nullable: true, blank: true)
    }
    
    static mapping = {
        table 'tb_produto'
        version false
        id column: 'SEQ_PRODUTO', generator: 'increment'
        nome column: 'NOM_PRODUTO'
        descricao column: 'DSC_PRODUTO'
        imagem column: 'ARQ_IMAGEM'
        tipoImagem column: 'TIP_IMAGEM'
        categorias joinTable: [name: 'tb_produto_categoria', key: 'SEQ_PRODUTO', column: 'SEQ_CATEGORIA']
        precos joinTable: false, column: 'SEQ_PRODUTO', cascade:"all-delete-orphan"
    }

	@Override
	public int compareTo(Object obj) {
		def produto = (Produto) obj
        def resultado = nome.compareTo(produto.getNome())
        if (resultado == 0) {
            resultado = id.compareTo(produto?.id)
        }
        return resultado
    }
	
	@Override
	public boolean equals(Object obj) {
		def produto = (Produto) obj;
		return id?.equals(produto?.id);
	}
    
}