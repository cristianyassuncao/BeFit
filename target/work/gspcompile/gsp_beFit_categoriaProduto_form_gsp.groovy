import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_beFit_categoriaProduto_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/categoriaProduto/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('message','g',4,['code':("categoriaProduto.nome.label"),'default':("Nome")],-1)
printHtmlPart(1)
invokeTag('textField','g',8,['name':("nome"),'value':(categoriaProdutoInstance?.nome),'maxlength':("100"),'size':("70")],-1)
printHtmlPart(2)
invokeTag('message','g',15,['code':("categoriaProduto.categoriaPai.label"),'default':("Nome")],-1)
printHtmlPart(3)
invokeTag('select','g',18,['id':("categoriaPai"),'name':("categoriaPai.id"),'from':(CategoriaProduto.list()),'optionKey':("id"),'optionValue':("nome"),'value':(categoriaProdutoInstance?.categoriaPai?.id),'class':("many-to-one"),'noSelection':(['':'-Escolha a Categoria-'])],-1)
printHtmlPart(4)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1433701342209L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
