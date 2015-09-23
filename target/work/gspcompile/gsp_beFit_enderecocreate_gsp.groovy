import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_befit_enderecocreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/endereco/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(2)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(3)
expressionOut.print(error.field)
printHtmlPart(4)
}
printHtmlPart(5)
invokeTag('message','g',9,['error':(error)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',10,['bean':(enderecoInstance),'var':("error")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',12,['bean':(enderecoInstance)],1)
printHtmlPart(8)
expressionOut.print(enderecoInstance?.id)
printHtmlPart(9)
expressionOut.print(enderecoInstance?.pessoa?.id)
printHtmlPart(10)
invokeTag('render','g',16,['template':("/endereco/form"),'model':(['enderecoInstance': enderecoInstance])],-1)
printHtmlPart(11)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1442880478161L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
