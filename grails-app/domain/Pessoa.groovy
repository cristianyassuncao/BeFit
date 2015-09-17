class Pessoa {
    
    Date dataInclusao
    String email
       
    static hasMany = [telefones: Telefone, enderecos: Endereco]

    static constraints = {
        dataInclusao(nullable: false, blank: false)
        email(nullable: true, blank: true)
    }
    
    static mapping = {
        table 'TB_PESSOA'
        version false
        id column: 'SEQ_PESSOA', generator: 'increment'
        discriminator column: 'TIP_PESSOA'
        dataInclusao column: 'DAT_INCLUSAO'
        email column: 'TXT_EMAIL'
        enderecos joinTable: false, column: 'SEQ_PESSOA', cascade:"all-delete-orphan"
        telefones joinTable: false, column: 'SEQ_PESSOA', cascade:"all-delete-orphan"
    }
    
}