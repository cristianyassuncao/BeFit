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
invokeTag('javascript','g',8,['src':("pedido.js")],-1)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',17,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
invokeTag('message','g',19,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(7)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(8)
invokeTag('message','g',22,['code':("default.home.label")],-1)
printHtmlPart(9)
createTagBody(2, {->
invokeTag('message','g',23,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',23,['class':("create"),'action':("create")],2)
printHtmlPart(10)
invokeTag('message','g',27,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(11)
if(true && (flash.message)) {
printHtmlPart(12)
expressionOut.print(flash.message)
printHtmlPart(13)
}
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(15)
invokeTag('message','g',36,['code':("telefone.numero.label")],-1)
printHtmlPart(16)
expressionOut.print(params?.numeroTelefone)
printHtmlPart(17)
invokeTag('message','g',38,['code':("pedido.cliente.label")],-1)
printHtmlPart(18)
for( cliente in (clientes) ) {
printHtmlPart(19)
invokeTag('set','g',42,['var':("isClienteSelecionado"),'value':(params?.cliente == cliente?.id?.toString())],-1)
printHtmlPart(20)
expressionOut.print(cliente.id)
printHtmlPart(21)
if(true && (isClienteSelecionado)) {
printHtmlPart(22)
}
printHtmlPart(23)
expressionOut.print(cliente.nome)
printHtmlPart(24)
}
printHtmlPart(25)
invokeTag('message','g',46,['code':("pedido.responsavelEntrega.label")],-1)
printHtmlPart(26)
for( entregador in (entregadores) ) {
printHtmlPart(19)
invokeTag('set','g',50,['var':("isEntregadorSelecionado"),'value':(params?.entregador == entregador?.id?.toString())],-1)
printHtmlPart(27)
expressionOut.print(entregador.id)
printHtmlPart(21)
if(true && (isEntregadorSelecionado)) {
printHtmlPart(22)
}
printHtmlPart(23)
expressionOut.print(entregador.nome)
printHtmlPart(24)
}
printHtmlPart(28)
invokeTag('message','g',58,['code':("pedido.dataEntrega.label")],-1)
printHtmlPart(29)
expressionOut.print(params?.dataEntrega)
printHtmlPart(30)
for( s in (StatusPedido.values()) ) {
printHtmlPart(31)
expressionOut.print(s)
printHtmlPart(21)
if(true && (s.toString() in (params?.status))) {
printHtmlPart(32)
}
printHtmlPart(33)
expressionOut.print(s.descricao)
printHtmlPart(34)
}
printHtmlPart(35)
invokeTag('message','g',67,['code':("pedido.pago.label")],-1)
printHtmlPart(36)
expressionOut.print(params.pago)
printHtmlPart(37)
invokeTag('actionSubmit','g',75,['class':("clear"),'action':("clear"),'value':("Limpar")],-1)
printHtmlPart(38)
invokeTag('actionSubmit','g',77,['class':("delete"),'value':("Excluir"),'action':("deleteAllInList"),'onclick':("return beforeDelete();")],-1)
printHtmlPart(39)
invokeTag('actionSubmit','g',78,['class':("define"),'value':("Marcar como"),'action':("defineStatusAllInList"),'onclick':("return beforeDefineStatus();")],-1)
printHtmlPart(40)
invokeTag('actionSubmit','g',79,['class':("print"),'value':("Imprimir"),'action':("printAllInList"),'onclick':("return beforePrint();")],-1)
printHtmlPart(41)
invokeTag('sortableColumn','g',87,['property':("id"),'title':("Nº")],-1)
printHtmlPart(42)
invokeTag('sortableColumn','g',89,['property':("cliente"),'title':(message(code: 'pedido.cliente.label'))],-1)
printHtmlPart(43)
invokeTag('sortableColumn','g',91,['property':("dataEntrega"),'title':(message(code: 'pedido.dataEntrega.label', default: 'Data Entrega'))],-1)
printHtmlPart(43)
invokeTag('sortableColumn','g',93,['property':("entregador"),'title':(message(code: 'pedido.responsavelEntrega.label'))],-1)
printHtmlPart(44)
invokeTag('sortableColumn','g',95,['property':("bairro"),'title':(message(code: 'endereco.bairro.label'))],-1)
printHtmlPart(42)
invokeTag('sortableColumn','g',97,['property':("entregarAPartirDaHora"),'title':(message(code: 'pedido.entregarAPartirDaHora.label', default: 'Entregar AP artir Da Hora'))],-1)
printHtmlPart(43)
invokeTag('sortableColumn','g',99,['property':("entregarAteHora"),'title':(message(code: 'pedido.entregarAteHora.label', default: 'Entregar Ate Hora'))],-1)
printHtmlPart(43)
invokeTag('sortableColumn','g',101,['property':("valorAPagar"),'title':(message(code: 'pedido.valorAPagar.label'))],-1)
printHtmlPart(42)
invokeTag('sortableColumn','g',103,['property':("trocoPara"),'title':(message(code: 'pedido.trocoPara.label'))],-1)
printHtmlPart(42)
invokeTag('sortableColumn','g',105,['property':("valorTroco"),'title':(message(code: 'pedido.valorTroco.label'))],-1)
printHtmlPart(42)
invokeTag('sortableColumn','g',107,['property':("valorPago"),'title':(message(code: 'pedido.valorPago.label'))],-1)
printHtmlPart(42)
invokeTag('sortableColumn','g',109,['property':("numeroVolumes"),'title':(message(code: 'pedido.numeroVolumes.label', default: 'Numero Volumes'))],-1)
printHtmlPart(43)
invokeTag('sortableColumn','g',111,['property':("status"),'title':(message(code: 'pedido.status.label'))],-1)
printHtmlPart(42)
invokeTag('sortableColumn','g',113,['property':("pago"),'title':(message(code: 'pedido.pago.label'))],-1)
printHtmlPart(45)
loop:{
int i = 0
for( pedidoInstance in (pedidoInstanceList) ) {
printHtmlPart(46)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(47)
expressionOut.print(pedidoInstance.id)
printHtmlPart(48)
createTagBody(4, {->
expressionOut.print(pedidoInstance?.id)
})
invokeTag('link','g',124,['action':("show"),'id':(pedidoInstance.id)],4)
printHtmlPart(49)
createTagBody(4, {->
expressionOut.print(pedidoInstance?.cliente?.nome)
})
invokeTag('link','g',126,['target':("_blank"),'controller':("cliente"),'action':("show"),'id':(pedidoInstance?.cliente?.id)],4)
printHtmlPart(50)
invokeTag('formatDate','g',128,['date':(pedidoInstance.dataEntrega),'format':("dd/MM/yyyy")],-1)
printHtmlPart(50)
expressionOut.print(pedidoInstance?.entregador?.nome)
printHtmlPart(50)
expressionOut.print(pedidoInstance?.endereco?.bairro?.nome)
printHtmlPart(51)
invokeTag('formatDate','g',134,['date':(pedidoInstance?.entregarAPartirDaHora),'format':("HH:mm")],-1)
printHtmlPart(50)
invokeTag('formatDate','g',136,['date':(pedidoInstance?.entregarAteHora),'format':("HH:mm")],-1)
printHtmlPart(50)
invokeTag('formatNumber','g',138,['number':(pedidoInstance?.valorAPagar),'format':("###,##0.00")],-1)
printHtmlPart(49)
invokeTag('formatNumber','g',140,['number':(pedidoInstance?.trocoPara),'format':("###,##0.00")],-1)
printHtmlPart(49)
invokeTag('formatNumber','g',142,['number':(pedidoInstance?.valorTroco),'format':("###,##0.00")],-1)
printHtmlPart(49)
invokeTag('formatNumber','g',144,['number':(pedidoInstance?.valorPago),'format':("###,##0.00")],-1)
printHtmlPart(50)
expressionOut.print(fieldValue(bean: pedidoInstance, field: "numeroVolumes"))
printHtmlPart(49)
expressionOut.print(pedidoInstance?.status?.descricao)
printHtmlPart(52)
if(true && (pedidoInstance?.isPago())) {
printHtmlPart(32)
}
printHtmlPart(53)
i++
}
}
printHtmlPart(54)
invokeTag('paginate','g',157,['total':(pedidoInstanceTotal ?: 0),'max':("30"),'params':(['paginate': true])],-1)
printHtmlPart(55)
})
invokeTag('form','g',159,['name':("searchPedidosForm"),'controller':("pedido"),'action':("index"),'update':([sucess:'message',failure:'error'])],2)
printHtmlPart(56)
})
invokeTag('captureBody','sitemesh',161,[:],1)
printHtmlPart(57)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1448415036339L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
