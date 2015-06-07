class CategoriaProduto implements Comparable {
    
    String nome
    CategoriaProduto categoriaPai

    static constraints = {
    }
    
    static mapping = {
        table 'TB_CATEGORIA_PRODUTO'
        version false
        id column: 'SEQ_CATEGORIA', generator: 'sequence', params:[sequence:'SEQ_CATEGORIA_PRODUTO']
        nome column: 'NOM_CATEGORIA'
        categoriaPai column: 'SEQ_CATEGORIA_PAI'
    }
    
    int compareTo(Object obj) {
        def categoria = (CategoriaProduto) obj
        def resultado = categoriaPai.compareTo(categoria?.categoriaPai)
        if (resultado == 0) {
           resultado = nome.compareTo(categoria?.nome) 
        }
        return resultado
    }
    
}