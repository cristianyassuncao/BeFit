import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_beFit_itemDia_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/itemDia/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('message','g',13,['code':("itemDia.data.label"),'default':("Data")],-1)
printHtmlPart(1)
invokeTag('formatDate','g',17,['date':(itemDiaInstance?.data),'format':("dd/MM/yyyy")],-1)
printHtmlPart(2)
invokeTag('message','g',22,['code':("itemDia.produto.label"),'default':("Produto")],-1)
printHtmlPart(3)
for( produto in (Produto.list(sort: 'nome')) ) {
printHtmlPart(4)
invokeTag('set','g',29,['var':("isProdutoSelecionado"),'value':(itemDiaInstance?.produto?.id == produto?.id)],-1)
printHtmlPart(4)
if(true && (isProdutoSelecionado)) {
printHtmlPart(5)
expressionOut.print(produto.id)
printHtmlPart(6)
expressionOut.print(produto.nome)
printHtmlPart(7)
}
printHtmlPart(4)
if(true && (!isProdutoSelecionado)) {
printHtmlPart(5)
expressionOut.print(produto.id)
printHtmlPart(8)
expressionOut.print(produto.nome)
printHtmlPart(7)
}
printHtmlPart(9)
}
printHtmlPart(10)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1441882274324L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
