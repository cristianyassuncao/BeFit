import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_beFit_itemDiaindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/itemDia/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'itemDia.label', default: 'ItemDia'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',6,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',16,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',18,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',21,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',22,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',22,['class':("create"),'action':("create")],2)
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
invokeTag('message','g',35,['code':("itemDia.data.label")],-1)
printHtmlPart(13)
invokeTag('message','g',37,['code':("itemDia.produto.label")],-1)
printHtmlPart(14)
for( produto in (Produto.list(sort: 'nome')) ) {
printHtmlPart(15)
expressionOut.print(produto.id)
printHtmlPart(6)
expressionOut.print(produto.nome)
printHtmlPart(16)
}
printHtmlPart(17)
})
invokeTag('form','g',51,['id':("ajaxForm"),'name':("ajaxForm"),'url':([controller: 'itemDia', action:'index']),'update':([sucess:'message',failure:'error'])],2)
printHtmlPart(18)
invokeTag('sortableColumn','g',55,['property':("data"),'title':(message(code: 'itemDia.data.label', default: 'Data'))],-1)
printHtmlPart(19)
invokeTag('sortableColumn','g',56,['property':("produto.nome"),'title':(message(code: 'itemDia.produto.label', default: 'Produto'))],-1)
printHtmlPart(20)
loop:{
int i = 0
for( itemDiaInstance in (itemDiaInstanceList) ) {
printHtmlPart(21)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(22)
createTagBody(3, {->
invokeTag('formatDate','g',62,['date':(itemDiaInstance?.data),'format':("dd/MM/yyyy")],-1)
})
invokeTag('link','g',62,['action':("show"),'id':(itemDiaInstance.id)],3)
printHtmlPart(23)
expressionOut.print(itemDiaInstance?.produto?.nome)
printHtmlPart(24)
i++
}
}
printHtmlPart(25)
invokeTag('paginate','g',69,['total':(itemDiaInstanceCount ?: 0)],-1)
printHtmlPart(26)
})
invokeTag('captureBody','sitemesh',72,[:],1)
printHtmlPart(27)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1441886475964L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
