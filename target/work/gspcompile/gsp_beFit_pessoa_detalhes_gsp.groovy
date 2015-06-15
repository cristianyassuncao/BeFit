import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_beFit_pessoa_detalhes_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/pessoa/_detalhes.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (somenteLeitura == null)) {
printHtmlPart(1)
expressionOut.print(pessoaInstance?.id)
printHtmlPart(2)
}
printHtmlPart(3)
invokeTag('render','g',14,['template':("/endereco/list"),'model':(['pessoaInstance': pessoaInstance, 'somenteLeitura': somenteLeitura])],-1)
printHtmlPart(4)
if(true && (somenteLeitura == null)) {
printHtmlPart(5)
expressionOut.print(pessoaInstance?.id)
printHtmlPart(2)
}
printHtmlPart(6)
invokeTag('render','g',23,['template':("/telefone/list"),'model':(['pessoaInstance': pessoaInstance, 'somenteLeitura': somenteLeitura])],-1)
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1432319544202L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
