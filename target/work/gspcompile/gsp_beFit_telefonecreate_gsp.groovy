import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_beFit_telefonecreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/telefone/create.gsp" }
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
invokeTag('message','g',5,['error':(error)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',6,['bean':(telefoneInstance),'var':("error")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',8,['bean':(telefoneInstance)],1)
printHtmlPart(9)
expressionOut.print(telefoneInstance?.id)
printHtmlPart(10)
expressionOut.print(telefoneInstance?.pessoa?.id)
printHtmlPart(11)
invokeTag('render','g',12,['template':("/telefone/form"),'model':(['telefoneInstance': telefoneInstance])],-1)
printHtmlPart(12)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1437615271058L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
