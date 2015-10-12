import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_befit_clienteedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cliente/edit.gsp" }
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
invokeTag('message','g',6,['code':("default.edit.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(1)
invokeTag('javascript','g',7,['src':("pessoa.js")],-1)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',15,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',18,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',19,['code':("default.list.label")],-1)
})
invokeTag('link','g',19,['class':("list"),'action':("index")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',20,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',20,['class':("create"),'action':("create")],2)
printHtmlPart(9)
invokeTag('message','g',24,['code':("default.edit.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(14)
createTagBody(3, {->
printHtmlPart(15)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(16)
expressionOut.print(error.field)
printHtmlPart(17)
}
printHtmlPart(18)
invokeTag('message','g',31,['error':(error)],-1)
printHtmlPart(19)
})
invokeTag('eachError','g',32,['bean':(clienteInstance),'var':("error")],3)
printHtmlPart(20)
})
invokeTag('hasErrors','g',34,['bean':(clienteInstance)],2)
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(21)
invokeTag('hiddenField','g',36,['name':("version"),'value':(clienteInstance?.version)],-1)
printHtmlPart(21)
invokeTag('hiddenField','g',37,['name':("id"),'value':(clienteInstance?.id)],-1)
printHtmlPart(22)
invokeTag('render','g',39,['template':("/pessoa/dadosPrincipaisPF"),'model':(['pessoaInstance': clienteInstance?.pessoa])],-1)
printHtmlPart(23)
invokeTag('render','g',40,['template':("form")],-1)
printHtmlPart(24)
invokeTag('render','g',41,['template':("/pessoa/detalhes"),'model':(['pessoaInstance': clienteInstance?.pessoa])],-1)
printHtmlPart(25)
invokeTag('actionSubmit','g',44,['class':("save"),'action':("update"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(23)
createTagBody(3, {->
printHtmlPart(26)
invokeTag('message','g',46,['code':("treal.botaoCancelar"),'default':("Cancelar")],-1)
printHtmlPart(23)
})
invokeTag('link','g',47,['class':("cancel"),'controller':("cliente"),'action':("index")],3)
printHtmlPart(27)
})
invokeTag('form','g',49,['url':([action:'update'])],2)
printHtmlPart(28)
})
invokeTag('captureBody','sitemesh',51,[:],1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1437615270917L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
