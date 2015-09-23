import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_befit_pedido_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/pedido/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (pedido?.id != null)) {
printHtmlPart(1)
invokeTag('message','g',24,['code':("pedido.id.label")],-1)
printHtmlPart(2)
expressionOut.print(pedido?.id)
printHtmlPart(3)
}
printHtmlPart(4)
for( s in (StatusPedido.values()) ) {
printHtmlPart(5)
invokeTag('set','g',34,['var':("isSelecionado"),'value':(pedido?.status?.equals(s))],-1)
printHtmlPart(5)
if(true && (isSelecionado)) {
printHtmlPart(6)
expressionOut.print(s)
printHtmlPart(7)
if(true && (readOnly)) {
printHtmlPart(8)
}
printHtmlPart(9)
}
printHtmlPart(5)
if(true && (!isSelecionado)) {
printHtmlPart(6)
expressionOut.print(s)
printHtmlPart(10)
if(true && (readOnly)) {
printHtmlPart(8)
}
printHtmlPart(9)
}
printHtmlPart(11)
expressionOut.print(s.descricao)
printHtmlPart(12)
}
printHtmlPart(13)
invokeTag('message','g',51,['code':("telefone.numero.label")],-1)
printHtmlPart(14)
if(true && (readOnly)) {
printHtmlPart(15)
}
printHtmlPart(16)
expressionOut.print(pedido?.telefone?.numero)
printHtmlPart(17)
expressionOut.print(remoteFunction(controller:'pedido',action:'consultarClientePorTelefone', method: 'GET', params:'\'telefone=\' + escape(this.value)', before: 'atualizarSelect(\'cliente\',null); if (!isTelefonePreenchido(this.value)) return false;', onSuccess:'exibirDadosCliente(data)'))
printHtmlPart(18)
invokeTag('message','g',59,['code':("cliente.nome.label")],-1)
printHtmlPart(19)
if(true && (readOnly)) {
printHtmlPart(8)
}
printHtmlPart(20)
for( cliente in (clientes) ) {
printHtmlPart(21)
invokeTag('set','g',65,['var':("isClienteSelecionado"),'value':(pedido?.cliente?.id == cliente?.id)],-1)
printHtmlPart(21)
if(true && (isClienteSelecionado)) {
printHtmlPart(22)
expressionOut.print(cliente.id)
printHtmlPart(23)
expressionOut.print(cliente.nome)
printHtmlPart(24)
}
printHtmlPart(21)
if(true && (!isClienteSelecionado)) {
printHtmlPart(22)
expressionOut.print(cliente.id)
printHtmlPart(25)
expressionOut.print(cliente.nome)
printHtmlPart(24)
}
printHtmlPart(26)
}
printHtmlPart(27)
if(true && (pedido?.cliente != null)) {
printHtmlPart(28)
invokeTag('render','g',80,['template':("dadosComplementares"),'model':([endereco: pedido?.endereco, telefones: pedido?.cliente?.pessoa?.telefones, observacoes: pedido?.cliente?.observacoes, readOnly: readOnly])],-1)
printHtmlPart(29)
}
printHtmlPart(30)
invokeTag('message','g',93,['code':("pedido.entregarAPartirDaHora.label")],-1)
printHtmlPart(31)
invokeTag('formatDate','g',96,['date':(pedido?.entregarAPartirDaHora),'format':("HH:mm")],-1)
printHtmlPart(10)
if(true && (readOnly)) {
printHtmlPart(15)
}
printHtmlPart(32)
invokeTag('message','g',101,['code':("pedido.entregarAteHora.label")],-1)
printHtmlPart(33)
invokeTag('formatDate','g',104,['date':(pedido?.entregarAteHora),'format':("HH:mm")],-1)
printHtmlPart(10)
if(true && (readOnly)) {
printHtmlPart(15)
}
printHtmlPart(34)
invokeTag('message','g',111,['code':("pedido.dataCadastro.label")],-1)
printHtmlPart(35)
invokeTag('formatDate','g',114,['date':(pedido?.dataCadastro),'format':("dd/MM/yyyy")],-1)
printHtmlPart(36)
invokeTag('message','g',119,['code':("pedido.dataEntrega.label")],-1)
printHtmlPart(37)
invokeTag('formatDate','g',123,['date':(pedido?.dataEntrega),'format':("dd/MM/yyyy")],-1)
printHtmlPart(10)
if(true && (readOnly)) {
printHtmlPart(15)
}
printHtmlPart(38)
invokeTag('message','g',130,['code':("pedido.responsavelEntrega.label")],-1)
printHtmlPart(39)
if(true && (readOnly)) {
printHtmlPart(8)
}
printHtmlPart(40)
for( entregador in (entregadores) ) {
printHtmlPart(21)
invokeTag('set','g',136,['var':("isEntregadorSelecionado"),'value':(pedido?.entregador?.id == entregador?.id)],-1)
printHtmlPart(21)
if(true && (isEntregadorSelecionado)) {
printHtmlPart(22)
expressionOut.print(entregador.id)
printHtmlPart(23)
expressionOut.print(entregador.nome)
printHtmlPart(24)
}
printHtmlPart(21)
if(true && (!isEntregadorSelecionado)) {
printHtmlPart(22)
expressionOut.print(entregador.id)
printHtmlPart(25)
expressionOut.print(entregador.nome)
printHtmlPart(24)
}
printHtmlPart(26)
}
printHtmlPart(41)
invokeTag('message','g',149,['code':("pedido.requerTalher.label")],-1)
printHtmlPart(42)
if(true && (pedido?.requerTalher)) {
printHtmlPart(43)
}
printHtmlPart(44)
if(true && (readOnly)) {
printHtmlPart(8)
}
printHtmlPart(45)
invokeTag('message','g',157,['code':("pedido.numeroVolumes.label"),'default':("Numero Volumes")],-1)
printHtmlPart(46)
expressionOut.print(pedido?.numeroVolumes)
printHtmlPart(10)
if(true && (readOnly)) {
printHtmlPart(15)
}
printHtmlPart(47)
invokeTag('message','g',168,['code':("pedido.observacao.label")],-1)
printHtmlPart(48)
if(true && (readOnly)) {
printHtmlPart(15)
}
printHtmlPart(49)
expressionOut.print(pedido?.observacao)
printHtmlPart(50)
if(true && (!readOnly)) {
printHtmlPart(51)
}
printHtmlPart(52)
invokeTag('message','g',183,['code':("itemPedido.produto.label")],-1)
printHtmlPart(53)
invokeTag('message','g',184,['code':("itemPedido.quantidade.label")],-1)
printHtmlPart(54)
invokeTag('message','g',185,['code':("itemPedido.valorUnitario.label")],-1)
printHtmlPart(55)
invokeTag('message','g',186,['code':("itemPedido.valorTotalItem.label")],-1)
printHtmlPart(56)
invokeTag('message','g',187,['code':("itemPedido.alteracaoPrato.label")],-1)
printHtmlPart(57)
invokeTag('message','g',188,['code':("itemPedido.alteracaoMolho.label")],-1)
printHtmlPart(58)
if(true && (!readOnly)) {
printHtmlPart(59)
for( produto in (produtos) ) {
printHtmlPart(60)
expressionOut.print(produto.id)
printHtmlPart(25)
expressionOut.print(produto.nome)
printHtmlPart(61)
}
printHtmlPart(62)
}
printHtmlPart(63)
loop:{
int j = 0
for( i in (itensPedido) ) {
printHtmlPart(64)
invokeTag('set','g',224,['var':("classe"),'value':((j % 2) == 0 ? 'par' : '')],-1)
printHtmlPart(64)
invokeTag('render','g',225,['template':("exibirItemPedido"),'model':(['itemPedido': i, 'classe': classe, 'readOnly': readOnly])],-1)
printHtmlPart(65)
j++
}
}
printHtmlPart(66)
invokeTag('message','g',234,['code':("pedido.valorAPagar.label")],-1)
printHtmlPart(67)
invokeTag('formatNumber','g',238,['number':(pedido?.valorAPagar),'format':("###,##0.00")],-1)
printHtmlPart(68)
invokeTag('message','g',243,['code':("pedido.trocoPara.label")],-1)
printHtmlPart(69)
invokeTag('formatNumber','g',247,['number':(pedido?.trocoPara),'format':("###,##0.00")],-1)
printHtmlPart(70)
if(true && (readOnly)) {
printHtmlPart(15)
}
printHtmlPart(45)
invokeTag('message','g',252,['code':("pedido.valorTroco.label")],-1)
printHtmlPart(71)
invokeTag('formatNumber','g',256,['number':(pedido?.valorTroco),'format':("###,##0.00")],-1)
printHtmlPart(72)
invokeTag('message','g',261,['code':("pedido.valorPago.label")],-1)
printHtmlPart(73)
invokeTag('formatNumber','g',265,['number':(pedido?.valorPago),'format':("###,##0.00")],-1)
printHtmlPart(74)
if(true && (readOnly)) {
printHtmlPart(15)
}
printHtmlPart(75)
createTagBody(1, {->
printHtmlPart(76)
expressionOut.print(it.radio)
printHtmlPart(77)
expressionOut.print(it.label)
printHtmlPart(78)
})
invokeTag('radioGroup','g',274,['values':(FormaPagamento.list(order: 'nome').id),'labels':(FormaPagamento.list(order: 'nome').nome),'name':("formaPagamento"),'value':(pedido?.formaPagamento?.id),'disabled':(readOnly)],1)
printHtmlPart(79)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1442880583294L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
