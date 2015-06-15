import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_beFit_endereco_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/endereco/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('message','g',4,['code':("endereco.rua.label")],-1)
printHtmlPart(1)
expressionOut.print(enderecoInstance?.rua)
printHtmlPart(2)
invokeTag('message','g',15,['code':("endereco.numero.label")],-1)
printHtmlPart(3)
expressionOut.print(enderecoInstance?.numero)
printHtmlPart(2)
invokeTag('message','g',26,['code':("endereco.complemento.label")],-1)
printHtmlPart(4)
expressionOut.print(enderecoInstance?.complemento)
printHtmlPart(2)
invokeTag('message','g',36,['code':("endereco.bairro.label"),'default':("Bairro")],-1)
printHtmlPart(5)
invokeTag('select','g',40,['id':("bairro"),'name':("bairro.id"),'from':(Bairro.list()),'optionKey':("id"),'optionValue':("nome"),'noSelection':(['':'-Escolha o Bairro-']),'value':(enderecoInstance?.bairro?.id)],-1)
printHtmlPart(6)
invokeTag('message','g',47,['code':("endereco.cep.label"),'default':("Cep")],-1)
printHtmlPart(7)
expressionOut.print(enderecoInstance?.cep)
printHtmlPart(2)
invokeTag('message','g',57,['code':("endereco.pontoReferencia.label")],-1)
printHtmlPart(8)
expressionOut.print(enderecoInstance?.pontoReferencia)
printHtmlPart(9)
invokeTag('message','g',67,['code':("endereco.tipoEndereco.label"),'default':("Tipo")],-1)
printHtmlPart(10)
invokeTag('select','g',70,['id':("tipoEndereco"),'name':("tipoEndereco.id"),'from':(TipoEndereco.list()),'optionKey':("id"),'optionValue':("descricao"),'noSelection':(['':'-Escolha o Tipo de Endereço-']),'value':(enderecoInstance?.tipoEndereco?.id)],-1)
printHtmlPart(11)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1432327132257L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
