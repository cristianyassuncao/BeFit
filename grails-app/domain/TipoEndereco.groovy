class TipoEndereco {
    
    String descricao

    static constraints = {
    }
    
    static mapping = {
        table 'tb_tipo_endereco'
        version false
        id column: 'SEQ_TIPO_ENDERECO', generator: 'increment'
        descricao column: 'TXT_DESCRICAO'
    }
    
}
