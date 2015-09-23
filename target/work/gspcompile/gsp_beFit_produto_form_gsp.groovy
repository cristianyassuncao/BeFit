import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_befit_produto_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/produto/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('message','g',8,['code':("produto.nome.label")],-1)
printHtmlPart(1)
expressionOut.print(produtoInstance?.nome)
printHtmlPart(2)
invokeTag('message','g',19,['code':("produto.descricao.label")],-1)
printHtmlPart(3)
expressionOut.print(produtoInstance?.descricao)
printHtmlPart(4)
invokeTag('message','g',29,['code':("produto.categorias.label")],-1)
printHtmlPart(5)
invokeTag('select','g',32,['name':("categorias"),'from':(CategoriaProduto.list()),'multiple':("multiple"),'optionKey':("id"),'optionValue':("nome"),'size':("5"),'value':(produtoInstance?.categorias),'class':("many-to-many")],-1)
printHtmlPart(6)
if(true && (isCadastroCompleto)) {
printHtmlPart(7)
invokeTag('message','g',40,['code':("preco.valor.label")],-1)
printHtmlPart(8)
expressionOut.print(precoInstance?.valor)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (produtoInstance?.imagem != null)) {
printHtmlPart(11)
expressionOut.print(produtoInstance?.id)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (produtoInstance?.imagem == null)) {
printHtmlPart(14)
}
printHtmlPart(15)
invokeTag('message','g',61,['code':("produto.imagem.label")],-1)
printHtmlPart(16)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1442880618696L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
