import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_beFit_layoutsmain_gsp extends GroovyPage {
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
invokeTag('stylesheet','asset',12,['src':("application.css")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',13,['src':("application.js")],-1)
printHtmlPart(3)
invokeTag('javascript','asset',14,['src':("main.js")],-1)
printHtmlPart(4)
expressionOut.print(createLinkTo(dir:'css',file:'menu.css'))
printHtmlPart(5)
expressionOut.print(createLinkTo(dir:'js/jquery-ui-1.11.3.custom',file:'jquery-ui.css'))
printHtmlPart(6)
invokeTag('javascript','g',17,['src':("jquery-2.1.3.js")],-1)
printHtmlPart(3)
invokeTag('javascript','g',18,['src':("jquery-ui-1.11.3.custom/jquery-ui.js")],-1)
printHtmlPart(3)
invokeTag('javascript','g',19,['src':("jquery.maskedinput.js")],-1)
printHtmlPart(3)
invokeTag('layoutHead','g',20,[:],-1)
printHtmlPart(7)
})
invokeTag('captureHead','sitemesh',21,[:],1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
invokeTag('image','asset',24,['src':("BeFitLogo.png"),'alt':("BeFit")],-1)
printHtmlPart(9)
expressionOut.print(createLinkTo(dir:'bairro'))
printHtmlPart(10)
expressionOut.print(createLinkTo(dir:'categoriaProduto'))
printHtmlPart(11)
expressionOut.print(createLinkTo(dir:'entregador'))
printHtmlPart(12)
expressionOut.print(createLinkTo(dir:'itemDia'))
printHtmlPart(13)
expressionOut.print(createLinkTo(dir:'produto'))
printHtmlPart(14)
expressionOut.print(createLinkTo(dir:'cliente'))
printHtmlPart(15)
expressionOut.print(createLinkTo(dir:'pedido'))
printHtmlPart(16)
invokeTag('layoutBody','g',55,[:],-1)
printHtmlPart(17)
invokeTag('message','g',56,['code':("spinner.alt"),'default':("Loading&hellip;")],-1)
printHtmlPart(18)
})
invokeTag('captureBody','sitemesh',57,[:],1)
printHtmlPart(19)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1441886345638L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}