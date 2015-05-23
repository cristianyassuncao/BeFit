class PessoaJuridica extends Pessoa {
    
    String razaoSocial
           
    static constraints = {
        razaoSocial(nullable: false, blank: false)
    }
    
    static mapping = {
        razaoSocial column: 'NOM_RAZAO_SOCIAL'
    }
    
}