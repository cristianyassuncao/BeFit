import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_befit_pedidoselecaoEndereco_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/pedido/selecaoEndereco.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
loop:{
int i = 0
for( endereco in (enderecos) ) {
printHtmlPart(1)
invokeTag('set','g',3,['var':("idEndereco"),'value':(endereco.id)],-1)
printHtmlPart(2)
expressionOut.print(idEndereco)
printHtmlPart(3)
expressionOut.print(idEndereco)
printHtmlPart(4)
expressionOut.print(idEndereco)
printHtmlPart(5)
expressionOut.print(endereco?.rua)
printHtmlPart(6)
expressionOut.print(idEndereco)
printHtmlPart(5)
expressionOut.print(endereco?.numero)
printHtmlPart(7)
expressionOut.print(idEndereco)
printHtmlPart(5)
expressionOut.print(endereco?.complemento)
printHtmlPart(8)
expressionOut.print(idEndereco)
printHtmlPart(9)
expressionOut.print(endereco?.bairro?.id)
printHtmlPart(10)
expressionOut.print(idEndereco)
printHtmlPart(5)
expressionOut.print(endereco?.bairro?.nome)
printHtmlPart(11)
expressionOut.print(idEndereco)
printHtmlPart(5)
expressionOut.print(endereco?.pontoReferencia)
printHtmlPart(12)
i++
}
}
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1437649428160L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
