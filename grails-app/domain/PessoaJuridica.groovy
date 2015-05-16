class PessoaJuridica extends Pessoa {
    
    String razaoSocial
           
    static constraints = {
        razaoSocial(nullable: false, blank: false)
    }
    
    static mapping = {
        discriminator value: "J"
        razaoSocial column: 'NOM_RAZAO_SOCIAL'
    }
    
}