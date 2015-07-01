

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pedido.label', default: 'Pedido')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-pedido" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-pedido" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list pedido">
			
				<g:if test="${pedidoInstance?.cliente}">
				<li class="fieldcontain">
					<span id="cliente-label" class="property-label"><g:message code="pedido.cliente.label" default="Cliente" /></span>
					
						<span class="property-value" aria-labelledby="cliente-label"><g:link controller="cliente" action="show" id="${pedidoInstance?.cliente?.id}">${pedidoInstance?.cliente?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${pedidoInstance?.dataEntrega}">
				<li class="fieldcontain">
					<span id="dataEntrega-label" class="property-label"><g:message code="pedido.dataEntrega.label" default="Data Entrega" /></span>
					
						<span class="property-value" aria-labelledby="dataEntrega-label"><g:formatDate date="${pedidoInstance?.dataEntrega}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${pedidoInstance?.dataPedido}">
				<li class="fieldcontain">
					<span id="dataPedido-label" class="property-label"><g:message code="pedido.dataPedido.label" default="Data Pedido" /></span>
					
						<span class="property-value" aria-labelledby="dataPedido-label"><g:formatDate date="${pedidoInstance?.dataPedido}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${pedidoInstance?.entregarAPartirDaHora}">
				<li class="fieldcontain">
					<span id="entregarAPartirDaHora-label" class="property-label"><g:message code="pedido.entregarAPartirDaHora.label" default="Entregar AP artir Da Hora" /></span>
					
						<span class="property-value" aria-labelledby="entregarAPartirDaHora-label"><g:formatDate date="${pedidoInstance?.entregarAPartirDaHora}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${pedidoInstance?.entregarAteHora}">
				<li class="fieldcontain">
					<span id="entregarAteHora-label" class="property-label"><g:message code="pedido.entregarAteHora.label" default="Entregar Ate Hora" /></span>
					
						<span class="property-value" aria-labelledby="entregarAteHora-label"><g:formatDate date="${pedidoInstance?.entregarAteHora}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${pedidoInstance?.itens}">
				<li class="fieldcontain">
					<span id="itens-label" class="property-label"><g:message code="pedido.itens.label" default="Itens" /></span>
					
						<g:each in="${pedidoInstance.itens}" var="i">
						<span class="property-value" aria-labelledby="itens-label"><g:link controller="itemPedido" action="show" id="${i.id}">${i?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${pedidoInstance?.numeroVolumes}">
				<li class="fieldcontain">
					<span id="numeroVolumes-label" class="property-label"><g:message code="pedido.numeroVolumes.label" default="Numero Volumes" /></span>
					
						<span class="property-value" aria-labelledby="numeroVolumes-label"><g:fieldValue bean="${pedidoInstance}" field="numeroVolumes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${pedidoInstance?.observacao}">
				<li class="fieldcontain">
					<span id="observacao-label" class="property-label"><g:message code="pedido.observacao.label" default="Observacao" /></span>
					
						<span class="property-value" aria-labelledby="observacao-label"><g:fieldValue bean="${pedidoInstance}" field="observacao"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${pedidoInstance?.requerTalher}">
				<li class="fieldcontain">
					<span id="requerTalher-label" class="property-label"><g:message code="pedido.requerTalher.label" default="Requer Talher" /></span>
					
						<span class="property-value" aria-labelledby="requerTalher-label"><g:formatBoolean boolean="${pedidoInstance?.requerTalher}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${pedidoInstance?.responsavelEntrega}">
				<li class="fieldcontain">
					<span id="responsavelEntrega-label" class="property-label"><g:message code="pedido.responsavelEntrega.label" default="Responsavel Entrega" /></span>
					
						<span class="property-value" aria-labelledby="responsavelEntrega-label"><g:link controller="entregador" action="show" id="${pedidoInstance?.responsavelEntrega?.id}">${pedidoInstance?.responsavelEntrega?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${pedidoInstance?.valorAPagar}">
				<li class="fieldcontain">
					<span id="valorAPagar-label" class="property-label"><g:message code="pedido.valorAPagar.label" default="Valor AP agar" /></span>
					
						<span class="property-value" aria-labelledby="valorAPagar-label"><g:fieldValue bean="${pedidoInstance}" field="valorAPagar"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${pedidoInstance?.valorTroco}">
				<li class="fieldcontain">
					<span id="valorTroco-label" class="property-label"><g:message code="pedido.valorTroco.label" default="Valor Troco" /></span>
					
						<span class="property-value" aria-labelledby="valorTroco-label"><g:fieldValue bean="${pedidoInstance}" field="valorTroco"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:pedidoInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${pedidoInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
