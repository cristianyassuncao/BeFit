import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_befit_layoutsmain_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/main.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge,chrome=1")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',10,['default':("Grails")],-1)
})
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(2)
invokeTag('stylesheet','asset',13,['src':("application.css")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',14,['src':("application.js")],-1)
printHtmlPart(3)
invokeTag('javascript','asset',15,['src':("main.js")],-1)
printHtmlPart(4)
expressionOut.print(createLinkTo(dir:'css',file:'menu.css'))
printHtmlPart(5)
expressionOut.print(createLinkTo(dir:'js/jquery-ui-1.11.3.custom',file:'jquery-ui.css'))
printHtmlPart(6)
expressionOut.print(createLinkTo(dir:'js/chosen_v1.4.2', file: 'chosen.css'))
printHtmlPart(7)
invokeTag('javascript','g',19,['src':("jquery-2.1.3.js")],-1)
printHtmlPart(3)
invokeTag('javascript','g',20,['src':("jquery-ui-1.11.3.custom/jquery-ui.js")],-1)
printHtmlPart(3)
invokeTag('javascript','g',21,['src':("jquery.maskedinput.js")],-1)
printHtmlPart(1)
invokeTag('javascript','g',22,['src':("chosen_v1.4.2/chosen.jquery.js")],-1)
printHtmlPart(3)
invokeTag('layoutHead','g',23,[:],-1)
printHtmlPart(8)
})
invokeTag('captureHead','sitemesh',24,[:],1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
invokeTag('image','asset',28,['src':("BeFitLogo.png"),'alt':("BeFit")],-1)
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('principal','shiro',32,['property':("username")],-1)
printHtmlPart(12)
})
invokeTag('authenticated','shiro',35,[:],2)
printHtmlPart(13)
createClosureForHtmlPart(14, 2)
invokeTag('notAuthenticated','shiro',42,[:],2)
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
expressionOut.print(createLinkTo(dir:'bairro'))
printHtmlPart(17)
expressionOut.print(createLinkTo(dir:'categoriaProduto'))
printHtmlPart(18)
expressionOut.print(createLinkTo(dir:'entregador'))
printHtmlPart(19)
expressionOut.print(createLinkTo(dir:'itemDia'))
printHtmlPart(20)
expressionOut.print(createLinkTo(dir:'produto'))
printHtmlPart(21)
expressionOut.print(createLinkTo(dir:'cliente'))
printHtmlPart(22)
expressionOut.print(createLinkTo(dir:'pedido'))
printHtmlPart(23)
})
invokeTag('authenticated','shiro',74,[:],2)
printHtmlPart(3)
invokeTag('layoutBody','g',75,[:],-1)
printHtmlPart(24)
invokeTag('message','g',76,['code':("spinner.alt"),'default':("Loading&hellip;")],-1)
printHtmlPart(25)
})
invokeTag('captureBody','sitemesh',77,[:],1)
printHtmlPart(26)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1445212517546L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
