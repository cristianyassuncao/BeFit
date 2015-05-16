class TipoEndereco {
    
    String descricao

    static constraints = {
    }
    
    static mapping = {
        table 'TB_TIPO_ENDERECO'
        version false
        id column: 'SEQ_TIPO_ENDERECO', generator: 'sequence', params:[sequence:'SEQ_TIPO_ENDERECO']
        descricao column: 'TXT_DESCRICAO'
    }
    
}
