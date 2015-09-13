import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_beFit_precocreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/preco/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
createTagBody(1, {->
printHtmlPart(0)
createTagBody(2, {->
printHtmlPart(1)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(2)
expressionOut.print(error.field)
printHtmlPart(3)
}
printHtmlPart(4)
invokeTag('message','g',4,['error':(error)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',5,['bean':(precoInstance),'var':("error")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',7,['bean':(precoInstance)],1)
printHtmlPart(7)
expressionOut.print(precoInstance?.id)
printHtmlPart(8)
expressionOut.print(precoInstance?.produto?.id)
printHtmlPart(9)
invokeTag('render','g',11,['template':("/preco/form"),'model':(['precoInstance': precoInstance])],-1)
printHtmlPart(10)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1437615271023L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
