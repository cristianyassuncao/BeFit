import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_beFit_enderecocreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/endereco/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(createLinkTo(dir:'css',file:'pessoa.css'))
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(3)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(4)
expressionOut.print(error.field)
printHtmlPart(5)
}
printHtmlPart(6)
invokeTag('message','g',10,['error':(error)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',11,['bean':(enderecoInstance),'var':("error")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',13,['bean':(enderecoInstance)],1)
printHtmlPart(9)
expressionOut.print(enderecoInstance?.id)
printHtmlPart(10)
expressionOut.print(enderecoInstance?.pessoa?.id)
printHtmlPart(11)
invokeTag('render','g',17,['template':("/endereco/form"),'model':(['enderecoInstance': enderecoInstance])],-1)
printHtmlPart(12)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1431904348266L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
