import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_befit_pedido_exibirItemPedido_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/pedido/_exibirItemPedido.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(classe)
printHtmlPart(1)
expressionOut.print(itemPedido?.produto?.id)
printHtmlPart(2)
expressionOut.print(itemPedido?.produto?.nome)
printHtmlPart(3)
expressionOut.print(itemPedido?.produto?.nome)
printHtmlPart(4)
expressionOut.print(itemPedido?.quantidade)
printHtmlPart(3)
expressionOut.print(itemPedido?.quantidade)
printHtmlPart(5)
invokeTag('formatNumber','g',12,['number':(itemPedido?.valorUnitario),'format':("###,##0.00")],-1)
printHtmlPart(3)
invokeTag('formatNumber','g',13,['number':(itemPedido?.valorUnitario),'format':("###,##0.00")],-1)
printHtmlPart(6)
invokeTag('formatNumber','g',16,['number':(itemPedido?.valorItem),'format':("###,##0.00")],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',17,['number':(itemPedido?.valorItem),'format':("###,##0.00")],-1)
printHtmlPart(8)
expressionOut.print(itemPedido?.alteracaoPrato)
printHtmlPart(9)
expressionOut.print(itemPedido?.alteracaoPrato)
printHtmlPart(10)
expressionOut.print(itemPedido?.alteracaoMolho)
printHtmlPart(11)
expressionOut.print(itemPedido?.alteracaoMolho)
printHtmlPart(12)
if(true && (!readOnly)) {
printHtmlPart(13)
}
printHtmlPart(14)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1442694229269L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
