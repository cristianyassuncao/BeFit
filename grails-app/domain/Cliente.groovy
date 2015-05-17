class Cliente {
    
    Pessoa pessoa
    Date dataInclusao
 
    static constraints = {
        
    }
    
    static mapping = {
        table 'TB_CLIENTE'
        version false
        id column: 'SEQ_CLIENTE', generator: 'sequence', params:[sequence:'SEQ_CLIENTE']
        pessoa column: 'SEQ_PESSOA'
        dataInclusao column: 'DAT_INCLUSAO'
    }
    
}