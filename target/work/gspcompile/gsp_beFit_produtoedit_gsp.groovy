import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_beFit_produtoedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/produto/edit.gsp" }
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
invokeTag('javascript','g',6,['src':("produto.js")],-1)
printHtmlPart(1)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'produto.label', default: 'Produto'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.edit.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(6)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(7)
invokeTag('message','g',14,['code':("default.home.label")],-1)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',15,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("list"),'action':("index")],2)
printHtmlPart(9)
createTagBody(2, {->
invokeTag('message','g',16,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',16,['class':("create"),'action':("create")],2)
printHtmlPart(10)
invokeTag('message','g',20,['code':("default.edit.label"),'args':([entityName])],-1)
printHtmlPart(11)
if(true && (flash.message)) {
printHtmlPart(12)
expressionOut.print(flash.message)
printHtmlPart(13)
}
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(15)
createTagBody(3, {->
printHtmlPart(16)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(17)
expressionOut.print(error.field)
printHtmlPart(18)
}
printHtmlPart(19)
invokeTag('message','g',27,['error':(error)],-1)
printHtmlPart(20)
})
invokeTag('eachError','g',28,['bean':(produtoInstance),'var':("error")],3)
printHtmlPart(21)
})
invokeTag('hasErrors','g',30,['bean':(produtoInstance)],2)
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(22)
invokeTag('hiddenField','g',32,['name':("version"),'value':(produtoInstance?.version)],-1)
printHtmlPart(23)
invokeTag('render','g',34,['template':("form")],-1)
printHtmlPart(24)
invokeTag('render','g',35,['template':("/produto/detalhes"),'model':(['produtoInstance': produtoInstance])],-1)
printHtmlPart(25)
invokeTag('actionSubmit','g',38,['class':("save"),'action':("update"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(26)
})
invokeTag('form','g',40,['url':([resource:produtoInstance, action:'update']),'method':("PUT"),'enctype':("multipart/form-data")],2)
printHtmlPart(27)
})
invokeTag('captureBody','sitemesh',42,[:],1)
printHtmlPart(28)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1437615271036L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
