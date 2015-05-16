class Telefone {
    
    TipoTelefone tipo
    String numero
    boolean principal
    boolean whatsapp
    
    static belongsTo = [pessoa: Pessoa]

    static constraints = {
    }
    
    static mapping = {
        table 'TB_TELEFONE'
        version false
        id column: 'SEQ_TELEFONE', generator: 'sequence', params:[sequence:'SEQ_TELEFONE']
        tipo column: 'SEQ_TIPO_TELEFONE'
        numero column: 'TXT_NUMERO'
        principal column: 'IND_PRINCIPAL'
        whatsapp column: 'IND_WHATSAPP'
        pessoa column: 'SEQ_PESSOA'
    }
}