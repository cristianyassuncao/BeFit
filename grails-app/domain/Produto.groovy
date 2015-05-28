class Produto {
    
    String nome
    String descricao
    byte[] imagem
    String tipoImagem
    
    static hasMany = [categorias: CategoriaProduto]

    static constraints = {
    }
    
    static mapping = {
        table 'TB_PRODUTO'
        version false
        id column: 'SEQ_PRODUTO', generator: 'sequence', params:[sequence:'SEQ_PRODUTO']
        nome column: 'NOM_PRODUTO'
        descricao column: 'DSC_PRODUTO'
        imagem column: 'ARQ_IMAGEM'
        tipoImagem column: 'TIP_IMAGEM'
        categorias joinTable: [name: 'TB_PRODUTO_CATEGORIA', key: 'SEQ_CATEGORIA', column: 'SEQ_PRODUTO']
    }
    
}