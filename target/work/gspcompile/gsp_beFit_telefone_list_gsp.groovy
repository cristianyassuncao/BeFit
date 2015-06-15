import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_beFit_telefone_list_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/telefone/_list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
loop:{
int i = 0
for( telefone in (pessoaInstance?.telefones) ) {
printHtmlPart(1)
invokeTag('message','g',9,['code':("telefone.numero.label")],-1)
printHtmlPart(2)
expressionOut.print(telefone?.numeroComMascara)
printHtmlPart(3)
invokeTag('message','g',17,['code':("telefone.whatsapp.label")],-1)
printHtmlPart(4)
if(true && (telefone?.whatsapp)) {
printHtmlPart(5)
}
printHtmlPart(6)
invokeTag('message','g',27,['code':("telefone.tipoTelefone.label")],-1)
printHtmlPart(7)
expressionOut.print(telefone?.tipoTelefone?.descricao)
printHtmlPart(8)
if(true && (somenteLeitura == null)) {
printHtmlPart(9)
expressionOut.print(telefone?.id)
printHtmlPart(10)
expressionOut.print(telefone?.id)
printHtmlPart(11)
}
printHtmlPart(12)
i++
}
}
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1432338993912L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
