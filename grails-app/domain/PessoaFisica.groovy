class PessoaFisica extends Pessoa {
    
    String nome
    String diaMesNascimento
       
    static constraints = {
        nome(nullable: false, blank: false)
        diaMesNascimento(nullable: true, blank: true)
    }
    
    static mapping = {
        nome column: 'NOM_PESSOA'
        diaMesNascimento column: 'TXT_DIA_MES_NASCIMENTO'
    }
    
}