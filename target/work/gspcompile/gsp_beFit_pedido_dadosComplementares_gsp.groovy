import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_beFit_pedido_dadosComplementares_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/pedido/_dadosComplementares.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(endereco?.rua)
printHtmlPart(1)
expressionOut.print(endereco?.numero)
printHtmlPart(2)
expressionOut.print(endereco?.complemento)
printHtmlPart(3)
expressionOut.print(endereco?.bairro?.id)
printHtmlPart(4)
expressionOut.print(endereco?.pontoReferencia)
printHtmlPart(5)
expressionOut.print(endereco?.rua)
printHtmlPart(6)
expressionOut.print(endereco?.numero)
printHtmlPart(7)
expressionOut.print(endereco?.complemento)
printHtmlPart(8)
expressionOut.print(endereco?.bairro?.nome)
printHtmlPart(9)
expressionOut.print(endereco?.pontoReferencia)
printHtmlPart(10)
expressionOut.print(cliente?.id)
printHtmlPart(11)
loop:{
int i = 0
for( telefone in (telefones) ) {
printHtmlPart(12)
expressionOut.print(telefone?.numeroComMascara)
printHtmlPart(13)
if(true && (telefone?.whatsapp)) {
printHtmlPart(14)
}
printHtmlPart(15)
i++
}
}
printHtmlPart(16)
expressionOut.print(observacoes)
printHtmlPart(17)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1441673921164L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
