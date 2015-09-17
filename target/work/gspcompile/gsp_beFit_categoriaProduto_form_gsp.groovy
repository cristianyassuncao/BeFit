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
expressionOut.print(raw(categorias))
printHtmlPart(1)
invokeTag('hiddenField','g',51,['id':("id"),'name':("id"),'value':(categoriaProdutoInstance?.id)],-1)
printHtmlPart(2)
invokeTag('message','g',55,['code':("categoriaProduto.nome.label"),'default':("Nome")],-1)
printHtmlPart(3)
invokeTag('textField','g',59,['name':("nome"),'value':(categoriaProdutoInstance?.nome),'maxlength':("100"),'size':("70")],-1)
printHtmlPart(4)
invokeTag('message','g',66,['code':("categoriaProduto.categoriaPai.label")],-1)
printHtmlPart(5)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1437615270880L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
