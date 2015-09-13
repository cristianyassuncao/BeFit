import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_beFit_bairro_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/bairro/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('message','g',4,['code':("bairro.nome.label"),'default':("Nome")],-1)
printHtmlPart(1)
expressionOut.print(bairroInstance?.nome)
printHtmlPart(2)
invokeTag('message','g',15,['code':("bairro.cidade.label"),'default':("Cidade")],-1)
printHtmlPart(3)
invokeTag('select','g',19,['id':("cidade"),'name':("cidade.id"),'from':(Cidade.list()),'optionKey':("id"),'optionValue':("nome"),'required':(""),'value':(bairroInstance?.cidade?.id),'class':("many-to-one")],-1)
printHtmlPart(4)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1441806579531L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
