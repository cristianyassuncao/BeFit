import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_befit_clienteindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cliente/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'cliente.label', default: 'Cliente'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',9,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',12,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',13,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',13,['class':("create"),'action':("create")],2)
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
invokeTag('message','g',26,['code':("pessoa.nome.label")],-1)
printHtmlPart(13)
invokeTag('message','g',28,['code':("telefone.numero.label")],-1)
printHtmlPart(14)
expressionOut.print(telefoneInstance?.numero)
printHtmlPart(15)
})
invokeTag('form','g',37,['id':("ajaxForm"),'name':("ajaxForm"),'url':([controller: 'cliente', action:'index']),'update':([sucess:'message',failure:'error'])],2)
printHtmlPart(16)
expressionOut.print(message(code: 'cliente.id.label', default: 'Código'))
printHtmlPart(17)
expressionOut.print(message(code: 'pessoa.nome.label', default: 'Nome'))
printHtmlPart(18)
loop:{
int i = 0
for( clienteInstance in (clienteInstanceList) ) {
printHtmlPart(19)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(20)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: clienteInstance, field: "id"))
})
invokeTag('link','g',48,['action':("show"),'id':(clienteInstance.id)],3)
printHtmlPart(21)
expressionOut.print(clienteInstance?.nome)
printHtmlPart(22)
i++
}
}
printHtmlPart(23)
invokeTag('paginate','g',55,['total':(clienteInstanceTotal ?: 0),'max':("10")],-1)
printHtmlPart(24)
})
invokeTag('captureBody','sitemesh',58,[:],1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1440030670290L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
