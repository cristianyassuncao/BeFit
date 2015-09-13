import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_beFit_produtoshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/produto/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
expressionOut.print(createLinkTo(dir:'css',file:'produto.css'))
printHtmlPart(3)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'produto.label', default: 'Produto'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('message','g',10,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(6)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(7)
invokeTag('message','g',13,['code':("default.home.label")],-1)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',14,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',14,['class':("list"),'action':("index")],2)
printHtmlPart(9)
createTagBody(2, {->
invokeTag('message','g',15,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("create"),'action':("create")],2)
printHtmlPart(10)
invokeTag('message','g',19,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(11)
if(true && (flash.message)) {
printHtmlPart(12)
expressionOut.print(flash.message)
printHtmlPart(13)
}
printHtmlPart(14)
invokeTag('message','g',29,['code':("produto.id.label")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',32,['bean':(produtoInstance),'field':("id")],-1)
printHtmlPart(16)
invokeTag('message','g',39,['code':("produto.nome.label")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',42,['bean':(produtoInstance),'field':("nome")],-1)
printHtmlPart(16)
invokeTag('message','g',49,['code':("produto.descricao.label")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',52,['bean':(produtoInstance),'field':("descricao")],-1)
printHtmlPart(16)
invokeTag('message','g',59,['code':("produto.categorias.label")],-1)
printHtmlPart(15)
invokeTag('select','g',62,['name':("categorias"),'from':(CategoriaProduto.list()),'multiple':("multiple"),'optionKey':("id"),'optionValue':("nome"),'size':("5"),'value':(produtoInstance?.categorias),'class':("many-to-many"),'readonly':("readonly")],-1)
printHtmlPart(17)
expressionOut.print(produtoInstance?.id)
printHtmlPart(18)
invokeTag('render','g',74,['template':("/produto/detalhes"),'model':(['produtoInstance': produtoInstance, 'somenteLeitura': true])],-1)
printHtmlPart(19)
createTagBody(2, {->
printHtmlPart(20)
createTagBody(3, {->
invokeTag('message','g',77,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',77,['class':("edit"),'action':("edit"),'resource':(produtoInstance)],3)
printHtmlPart(21)
invokeTag('actionSubmit','g',78,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(22)
})
invokeTag('form','g',80,['url':([resource:produtoInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(23)
})
invokeTag('captureBody','sitemesh',82,[:],1)
printHtmlPart(24)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1438387335612L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
