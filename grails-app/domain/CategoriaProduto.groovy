class CategoriaProduto implements Comparable {
    
    String nome
    CategoriaProduto categoriaPai

    static constraints = {
    }
    
    static mapping = {
        table 'TB_CATEGORIA_PRODUTO'
        version false
        id column: 'SEQ_CATEGORIA', generator: 'increment'
        nome column: 'NOM_CATEGORIA'
        categoriaPai column: 'SEQ_CATEGORIA_PAI'
    }
    
    int compareTo(Object obj) {
        def categoria = (CategoriaProduto) obj
        def resultado = categoriaPai.compareTo(categoria?.categoriaPai)
        if (resultado == 0) {
           resultado = nome.compareTo(categoria?.nome) 
        }
        if (resultado == 0) {
            resultado = id.compareTo(categoria?.id)
        }
        return resultado
    }
    
    boolean equals(Object obj) {
        CategoriaProduto c = (CategoriaProduto) obj
        return this.id.equals(c.id)
    }
    
}