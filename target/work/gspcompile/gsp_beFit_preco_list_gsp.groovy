import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_beFit_preco_list_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/preco/_list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
loop:{
int i = 0
for( preco in (produtoInstance?.precos) ) {
printHtmlPart(1)
invokeTag('formatDate','g',10,['date':(preco?.aPartirDe),'format':("dd/MM/yyyy")],-1)
printHtmlPart(2)
invokeTag('formatNumber','g',11,['number':(preco?.valor),'format':("###,##0.00")],-1)
printHtmlPart(3)
if(true && (somenteLeitura == null)) {
printHtmlPart(4)
expressionOut.print(preco?.id)
printHtmlPart(5)
expressionOut.print(preco?.id)
printHtmlPart(6)
}
printHtmlPart(7)
i++
}
}
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1437615271020L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
