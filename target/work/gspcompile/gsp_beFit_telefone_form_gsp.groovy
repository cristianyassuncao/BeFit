import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_befit_telefone_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/telefone/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('message','g',7,['code':("telefone.numero.label")],-1)
printHtmlPart(1)
expressionOut.print(telefoneInstance?.numero)
printHtmlPart(2)
invokeTag('message','g',16,['code':("telefone.whatsapp.label")],-1)
printHtmlPart(3)
if(true && (telefoneInstance?.whatsapp)) {
printHtmlPart(4)
}
printHtmlPart(5)
invokeTag('message','g',26,['code':("telefone.tipoTelefone.label"),'default':("Tipo")],-1)
printHtmlPart(6)
invokeTag('select','g',29,['id':("tipoTelefone"),'name':("tipoTelefone.id"),'from':(TipoTelefone.list(sort: 'descricao')),'optionKey':("id"),'optionValue':("descricao"),'noSelection':(['':'-Escolha o Tipo de Telefone-']),'value':(telefoneInstance?.tipoTelefone?.id)],-1)
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1437615271051L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
