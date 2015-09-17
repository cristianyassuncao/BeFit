class TipoEndereco {
    
    String descricao

    static constraints = {
    }
    
    static mapping = {
        table 'TB_TIPO_ENDERECO'
        version false
        id column: 'SEQ_TIPO_ENDERECO', generator: 'increment'
        descricao column: 'TXT_DESCRICAO'
    }
    
}
