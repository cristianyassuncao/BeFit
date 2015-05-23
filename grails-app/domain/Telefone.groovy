
import javax.swing.text.MaskFormatter

class Telefone {
    
    TipoTelefone tipoTelefone
    String numero
    Boolean whatsapp
    String numeroComMascara
    
    static belongsTo = [pessoa: Pessoa]
    static transients =['numeroComMascara']

    static constraints = {
        tipoTelefone(nullable: true, blank: true)
        numero(nullable: false, blank: false)
        whatsapp(nullable: true, blank: true)
    }
    
    static mapping = {
        table 'TB_TELEFONE'
        version false
        id column: 'SEQ_TELEFONE', generator: 'sequence', params:[sequence:'SEQ_TELEFONE']
        tipoTelefone column: 'SEQ_TIPO_TELEFONE'
        numero column: 'TXT_NUMERO'
        whatsapp column: 'IND_WHATSAPP'
        pessoa column: 'SEQ_PESSOA'
    }
    
    public static String removerMascara(String numeroTelefone) {
        def numeroSemMascara = numeroTelefone
        numeroSemMascara = numeroSemMascara?.replace("(","")
        numeroSemMascara = numeroSemMascara?.replace(")","")
        numeroSemMascara = numeroSemMascara?.replace("-","")
        numeroSemMascara = numeroSemMascara?.replace(" ","")
        return numeroSemMascara
    }
    
    public String getNumeroComMascara() {
        String phoneMask= "(##) #####-####";
        MaskFormatter maskFormatter= new MaskFormatter(phoneMask);
        maskFormatter.setValueContainsLiteralCharacters(false);
        return maskFormatter.valueToString(numero) ;   
    }
    
}