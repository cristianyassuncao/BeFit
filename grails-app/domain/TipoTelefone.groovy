class TipoTelefone {
    
    String descricao

    static constraints = {
    }
    
    static mapping = {
        table 'TB_TIPO_TELEFONE'
        version false
        id column: 'SEQ_TIPO_TELEFONE', generator: 'sequence', params:[sequence:'SEQ_TIPO_TELEFONE']
        descricao column: 'TXT_DESCRICAO'
    }
}
