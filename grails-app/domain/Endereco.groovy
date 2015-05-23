
import javax.swing.text.MaskFormatter

class Endereco {
    
    String rua
    String numero
    String complemento
    Bairro bairro
    String cep
    String pontoReferencia
    TipoEndereco tipoEndereco
    String cepComMascara
    
    static belongsTo = [pessoa: Pessoa]
    static transients = ["cepComMascara"]

    static constraints = {
        rua(nullable: false, blank: false)
        numero(nullable: false, blank: false)
        bairro(nullable: false, blank: false)
        cep(nullable: true, blank: true)
        pontoReferencia(nullable: true, blank: true)
        tipoEndereco(nullable: true, blank: true)
        complemento(nullable: true, blank: true)
    }
    
    static mapping = {
        table 'TB_ENDERECO'
        version false
        id column: 'SEQ_ENDERECO', generator: 'sequence', params:[sequence:'SEQ_ENDERECO']
        rua column: 'TXT_ENDERECO'
        numero column: 'TXT_NUMERO'
        complemento column: 'TXT_COMPLEMENTO'
        bairro column: 'SEQ_BAIRRO'
        cep column: 'TXT_CEP'
        pontoReferencia column: 'TXT_PONTO_REFERENCIA'
        tipoEndereco column: 'SEQ_TIPO_ENDERECO'
        pessoa column: 'SEQ_PESSOA'
    }    
    
    public String getCepComMascara() {
        String cepMask= "#####-###";
        MaskFormatter maskFormatter= new MaskFormatter(cepMask);
        maskFormatter.setValueContainsLiteralCharacters(false);
        return maskFormatter.valueToString(cep) ;   
    }
   
}