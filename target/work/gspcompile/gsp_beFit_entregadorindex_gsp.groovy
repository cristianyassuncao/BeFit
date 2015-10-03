import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_befit_entregadorindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/entregador/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'entregador.label', default: 'Entregador'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',14,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('message','g',17,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(6)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(7)
invokeTag('message','g',21,['code':("default.home.label")],-1)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',22,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',22,['class':("create"),'action':("create")],2)
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(13)
invokeTag('message','g',35,['code':("entregador.nome.label")],-1)
printHtmlPart(14)
for( entregador in (entregadores) ) {
printHtmlPart(15)
expressionOut.print(entregador.id)
printHtmlPart(7)
expressionOut.print(entregador.nome)
printHtmlPart(16)
}
printHtmlPart(17)
})
invokeTag('form','g',49,['id':("ajaxForm"),'name':("ajaxForm"),'url':([controller: 'entregador', action:'index']),'update':([sucess:'message',failure:'error'])],2)
printHtmlPart(18)
expressionOut.print(message(code: 'entregador.id.label', default: 'Código'))
printHtmlPart(19)
expressionOut.print(message(code: 'pessoa.nome.label', default: 'Nome'))
printHtmlPart(20)
loop:{
int i = 0
for( entregadorInstance in (entregadorInstanceList) ) {
printHtmlPart(21)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(22)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: entregadorInstance, field: "id"))
})
invokeTag('link','g',60,['action':("show"),'id':(entregadorInstance.id)],3)
printHtmlPart(23)
expressionOut.print(entregadorInstance?.nome)
printHtmlPart(24)
i++
}
}
printHtmlPart(25)
invokeTag('paginate','g',67,['total':(entregadorInstanceTotal ?: 0),'max':("10")],-1)
printHtmlPart(26)
})
invokeTag('captureBody','sitemesh',70,[:],1)
printHtmlPart(27)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1443620520542L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
