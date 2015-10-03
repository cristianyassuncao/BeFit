import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_befit_endereco_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/endereco/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(createLinkTo(dir:'css',file:'pessoa.css'))
printHtmlPart(1)
invokeTag('message','g',12,['code':("endereco.rua.label")],-1)
printHtmlPart(2)
expressionOut.print(enderecoInstance?.rua)
printHtmlPart(3)
invokeTag('message','g',23,['code':("endereco.numero.label")],-1)
printHtmlPart(4)
expressionOut.print(enderecoInstance?.numero)
printHtmlPart(3)
invokeTag('message','g',34,['code':("endereco.complemento.label")],-1)
printHtmlPart(5)
expressionOut.print(enderecoInstance?.complemento)
printHtmlPart(3)
invokeTag('message','g',44,['code':("endereco.bairro.label"),'default':("Bairro")],-1)
printHtmlPart(6)
for( bairro in (Bairro.list(sort: 'nome')) ) {
printHtmlPart(7)
invokeTag('set','g',51,['var':("isBairroSelecionado"),'value':(enderecoInstance?.bairro?.id == bairro?.id)],-1)
printHtmlPart(7)
if(true && (isBairroSelecionado)) {
printHtmlPart(8)
expressionOut.print(bairro.id)
printHtmlPart(9)
expressionOut.print(bairro.nome)
printHtmlPart(10)
}
printHtmlPart(7)
if(true && (!isBairroSelecionado)) {
printHtmlPart(8)
expressionOut.print(bairro.id)
printHtmlPart(11)
expressionOut.print(bairro.nome)
printHtmlPart(10)
}
printHtmlPart(12)
}
printHtmlPart(13)
invokeTag('message','g',66,['code':("endereco.cep.label"),'default':("Cep")],-1)
printHtmlPart(14)
expressionOut.print(enderecoInstance?.cep)
printHtmlPart(3)
invokeTag('message','g',76,['code':("endereco.pontoReferencia.label")],-1)
printHtmlPart(15)
expressionOut.print(enderecoInstance?.pontoReferencia)
printHtmlPart(16)
invokeTag('message','g',86,['code':("endereco.tipoEndereco.label"),'default':("Tipo")],-1)
printHtmlPart(17)
invokeTag('select','g',89,['id':("tipoEndereco"),'name':("tipoEndereco.id"),'from':(TipoEndereco.list(sort: 'descricao')),'optionKey':("id"),'optionValue':("descricao"),'noSelection':(['':'-Escolha o Tipo de Endereço-']),'value':(enderecoInstance?.tipoEndereco?.id)],-1)
printHtmlPart(18)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1443620503697L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
