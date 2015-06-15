import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_beFit_endereco_list_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/endereco/_list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
loop:{
int i = 0
for( endereco in (pessoaInstance?.enderecos) ) {
printHtmlPart(1)
invokeTag('message','g',9,['code':("endereco.rua.label")],-1)
printHtmlPart(2)
expressionOut.print(endereco?.rua)
printHtmlPart(3)
invokeTag('message','g',17,['code':("endereco.numero.label")],-1)
printHtmlPart(4)
expressionOut.print(endereco?.numero)
printHtmlPart(5)
invokeTag('message','g',27,['code':("endereco.complemento.label")],-1)
printHtmlPart(2)
expressionOut.print(endereco?.complemento)
printHtmlPart(6)
invokeTag('message','g',37,['code':("endereco.bairro.label")],-1)
printHtmlPart(4)
expressionOut.print(endereco?.bairro?.nome)
printHtmlPart(7)
invokeTag('message','g',45,['code':("endereco.cidade.label")],-1)
printHtmlPart(8)
expressionOut.print(endereco?.bairro?.cidade?.nome)
printHtmlPart(7)
invokeTag('message','g',53,['code':("endereco.cep.label")],-1)
printHtmlPart(9)
expressionOut.print(endereco?.cepComMascara)
printHtmlPart(10)
invokeTag('message','g',63,['code':("endereco.pontoReferencia.label")],-1)
printHtmlPart(4)
expressionOut.print(endereco?.pontoReferencia)
printHtmlPart(11)
invokeTag('message','g',73,['code':("endereco.tipoEndereco.label")],-1)
printHtmlPart(4)
expressionOut.print(endereco?.tipoEndereco?.descricao)
printHtmlPart(12)
if(true && (somenteLeitura == null)) {
printHtmlPart(13)
expressionOut.print(endereco?.id)
printHtmlPart(14)
expressionOut.print(endereco?.id)
printHtmlPart(15)
}
printHtmlPart(16)
i++
}
}
printHtmlPart(17)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1432341070654L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
