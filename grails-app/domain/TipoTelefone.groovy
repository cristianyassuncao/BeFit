class TipoTelefone {
    
    String descricao

    static constraints = {
    }
    
    static mapping = {
        table 'tb_tipo_telefone'
        version false
        id column: 'SEQ_TIPO_TELEFONE', generator: 'increment'
        descricao column: 'TXT_DESCRICAO'
    }
}
