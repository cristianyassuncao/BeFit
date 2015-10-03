import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_befit_pedidoindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/pedido/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'pedido.label', default: 'Pedido'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',6,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(2)
expressionOut.print(createLinkTo(dir:'css',file:'pedido.css'))
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',16,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('message','g',18,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(6)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(7)
invokeTag('message','g',21,['code':("default.home.label")],-1)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',22,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',22,['class':("create"),'action':("create")],2)
printHtmlPart(9)
invokeTag('message','g',26,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(14)
invokeTag('message','g',35,['code':("telefone.numero.label")],-1)
printHtmlPart(15)
expressionOut.print(params.numeroTelefone)
printHtmlPart(16)
invokeTag('message','g',37,['code':("pedido.cliente.label")],-1)
printHtmlPart(17)
for( cliente in (clientes) ) {
printHtmlPart(18)
expressionOut.print(cliente.id)
printHtmlPart(7)
expressionOut.print(cliente.nome)
printHtmlPart(19)
}
printHtmlPart(20)
invokeTag('message','g',44,['code':("pedido.responsavelEntrega.label")],-1)
printHtmlPart(21)
for( entregador in (entregadores) ) {
printHtmlPart(18)
expressionOut.print(entregador.id)
printHtmlPart(7)
expressionOut.print(entregador.nome)
printHtmlPart(22)
}
printHtmlPart(23)
invokeTag('message','g',55,['code':("pedido.dataEntrega.label")],-1)
printHtmlPart(24)
expressionOut.print(params?.dataEntrega)
printHtmlPart(25)
for( s in (StatusPedido.values()) ) {
printHtmlPart(26)
expressionOut.print(s)
printHtmlPart(27)
if(true && (s.toString() in (params?.status))) {
printHtmlPart(28)
}
printHtmlPart(29)
expressionOut.print(s.descricao)
printHtmlPart(30)
}
printHtmlPart(31)
invokeTag('message','g',64,['code':("pedido.pago.label")],-1)
printHtmlPart(32)
expressionOut.print(params.pago)
printHtmlPart(33)
})
invokeTag('form','g',73,['id':("ajaxForm"),'name':("ajaxForm"),'url':([controller: 'pedido', action:'index']),'update':([sucess:'message',failure:'error'])],2)
printHtmlPart(34)
invokeTag('sortableColumn','g',79,['property':("id"),'title':("Nº")],-1)
printHtmlPart(35)
invokeTag('sortableColumn','g',81,['property':("cliente"),'title':(message(code: 'pedido.cliente.label'))],-1)
printHtmlPart(36)
invokeTag('sortableColumn','g',83,['property':("dataEntrega"),'title':(message(code: 'pedido.dataEntrega.label', default: 'Data Entrega'))],-1)
printHtmlPart(36)
invokeTag('sortableColumn','g',85,['property':("entregador"),'title':(message(code: 'pedido.responsavelEntrega.label'))],-1)
printHtmlPart(37)
invokeTag('sortableColumn','g',87,['property':("bairro"),'title':(message(code: 'endereco.bairro.label'))],-1)
printHtmlPart(35)
invokeTag('sortableColumn','g',89,['property':("entregarAPartirDaHora"),'title':(message(code: 'pedido.entregarAPartirDaHora.label', default: 'Entregar AP artir Da Hora'))],-1)
printHtmlPart(36)
invokeTag('sortableColumn','g',91,['property':("entregarAteHora"),'title':(message(code: 'pedido.entregarAteHora.label', default: 'Entregar Ate Hora'))],-1)
printHtmlPart(36)
invokeTag('sortableColumn','g',93,['property':("valorAPagar"),'title':(message(code: 'pedido.valorAPagar.label'))],-1)
printHtmlPart(35)
invokeTag('sortableColumn','g',95,['property':("trocoPara"),'title':(message(code: 'pedido.trocoPara.label'))],-1)
printHtmlPart(35)
invokeTag('sortableColumn','g',97,['property':("valorTroco"),'title':(message(code: 'pedido.valorTroco.label'))],-1)
printHtmlPart(35)
invokeTag('sortableColumn','g',99,['property':("valorPago"),'title':(message(code: 'pedido.valorPago.label'))],-1)
printHtmlPart(35)
invokeTag('sortableColumn','g',101,['property':("numeroVolumes"),'title':(message(code: 'pedido.numeroVolumes.label', default: 'Numero Volumes'))],-1)
printHtmlPart(36)
invokeTag('sortableColumn','g',103,['property':("status"),'title':(message(code: 'pedido.status.label'))],-1)
printHtmlPart(35)
invokeTag('sortableColumn','g',105,['property':("pago"),'title':(message(code: 'pedido.pago.label'))],-1)
printHtmlPart(38)
loop:{
int i = 0
for( pedidoInstance in (pedidoInstanceList) ) {
printHtmlPart(39)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(40)
createTagBody(3, {->
expressionOut.print(pedidoInstance?.id)
})
invokeTag('link','g',114,['action':("show"),'id':(pedidoInstance.id)],3)
printHtmlPart(41)
createTagBody(3, {->
expressionOut.print(pedidoInstance?.cliente?.nome)
})
invokeTag('link','g',116,['target':("_blank"),'controller':("cliente"),'action':("show"),'id':(pedidoInstance?.cliente?.id)],3)
printHtmlPart(42)
invokeTag('formatDate','g',118,['date':(pedidoInstance.dataEntrega),'format':("dd/MM/yyyy")],-1)
printHtmlPart(42)
expressionOut.print(pedidoInstance?.entregador?.nome)
printHtmlPart(42)
expressionOut.print(pedidoInstance?.endereco?.bairro?.nome)
printHtmlPart(43)
invokeTag('formatDate','g',124,['date':(pedidoInstance?.entregarAPartirDaHora),'format':("HH:mm")],-1)
printHtmlPart(42)
invokeTag('formatDate','g',126,['date':(pedidoInstance?.entregarAteHora),'format':("HH:mm")],-1)
printHtmlPart(42)
invokeTag('formatNumber','g',128,['number':(pedidoInstance?.valorAPagar),'format':("###,##0.00")],-1)
printHtmlPart(41)
invokeTag('formatNumber','g',130,['number':(pedidoInstance?.trocoPara),'format':("###,##0.00")],-1)
printHtmlPart(41)
invokeTag('formatNumber','g',132,['number':(pedidoInstance?.valorTroco),'format':("###,##0.00")],-1)
printHtmlPart(41)
invokeTag('formatNumber','g',134,['number':(pedidoInstance?.valorPago),'format':("###,##0.00")],-1)
printHtmlPart(42)
expressionOut.print(fieldValue(bean: pedidoInstance, field: "numeroVolumes"))
printHtmlPart(41)
expressionOut.print(pedidoInstance?.status?.descricao)
printHtmlPart(44)
if(true && (pedidoInstance?.isPago())) {
printHtmlPart(28)
}
printHtmlPart(45)
i++
}
}
printHtmlPart(46)
invokeTag('paginate','g',147,['total':(pedidoInstanceTotal ?: 0),'max':("30")],-1)
printHtmlPart(47)
})
invokeTag('captureBody','sitemesh',150,[:],1)
printHtmlPart(48)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1443620556495L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
