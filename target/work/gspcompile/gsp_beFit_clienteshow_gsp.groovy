import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_beFit_clienteshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cliente/show.gsp" }
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
createTagBody(3, {->
invokeTag('message','g',6,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('message','g',9,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(4)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(5)
invokeTag('message','g',12,['code':("default.home.label")],-1)
printHtmlPart(6)
createTagBody(2, {->
invokeTag('message','g',13,['code':("default.list.label")],-1)
})
invokeTag('link','g',13,['class':("list"),'action':("index")],2)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',14,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',14,['class':("create"),'action':("create")],2)
printHtmlPart(8)
invokeTag('message','g',18,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
invokeTag('render','g',22,['template':("/pessoa/dadosPrincipaisPFShow"),'model':(['pessoaInstance': clienteInstance?.pessoa])],-1)
printHtmlPart(13)
invokeTag('message','g',28,['code':("cliente.dataInclusao.label"),'default':("Data Inclusao")],-1)
printHtmlPart(14)
invokeTag('formatDate','g',31,['date':(clienteInstance?.dataInclusao),'format':("dd/MM/yyyy")],-1)
printHtmlPart(15)
invokeTag('message','g',38,['code':("cliente.observacoes.label")],-1)
printHtmlPart(16)
expressionOut.print(clienteInstance?.observacoes)
printHtmlPart(17)
invokeTag('render','g',46,['template':("/pessoa/detalhes"),'model':(['pessoaInstance': clienteInstance?.pessoa, 'somenteLeitura': true])],-1)
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(18)
createTagBody(3, {->
invokeTag('message','g',49,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',49,['class':("edit"),'action':("edit"),'resource':(clienteInstance)],3)
printHtmlPart(19)
invokeTag('actionSubmit','g',50,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(20)
})
invokeTag('form','g',52,['url':([resource:clienteInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',54,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1439214743990L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
