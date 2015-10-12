import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_befit_pessoa_dadosPrincipaisPF_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/pessoa/_dadosPrincipaisPF.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(pessoaInstance?.id)
printHtmlPart(1)
invokeTag('message','g',12,['code':("pessoa.nome.label"),'default':("Nome")],-1)
printHtmlPart(2)
expressionOut.print(pessoaInstance?.nome)
printHtmlPart(3)
invokeTag('message','g',21,['code':("pessoa.dataInclusao.label"),'default':("Data Inclusao")],-1)
printHtmlPart(4)
invokeTag('formatDate','g',25,['date':(pessoaInstance?.dataInclusao),'format':("dd/MM/yyyy")],-1)
printHtmlPart(5)
invokeTag('message','g',32,['code':("pessoa.diaMesNascimento.label")],-1)
printHtmlPart(6)
expressionOut.print(pessoaInstance?.diaMesNascimento)
printHtmlPart(7)
invokeTag('message','g',40,['code':("pessoa.email.label")],-1)
printHtmlPart(8)
expressionOut.print(pessoaInstance?.email)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1437615271002L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
