class Bairro {
    
    String nome
    Cidade cidade

    static constraints = {
    }
    
    static mapping = {
        table 'TB_BAIRRO'
        version false
        id column: 'SEQ_BAIRRO', generator: 'sequence', params:[sequence:'SEQ_BAIRRO']
        nome column: 'NOM_BAIRRO'
        cidade column: 'SEQ_CIDADE'
    }
    
}
