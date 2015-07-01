

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pedido.label', default: 'Pedido')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-pedido" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-pedido" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="pedido.cliente.label" default="Cliente" /></th>
					
						<g:sortableColumn property="dataEntrega" title="${message(code: 'pedido.dataEntrega.label', default: 'Data Entrega')}" />
					
						<g:sortableColumn property="dataPedido" title="${message(code: 'pedido.dataPedido.label', default: 'Data Pedido')}" />
					
						<g:sortableColumn property="entregarAPartirDaHora" title="${message(code: 'pedido.entregarAPartirDaHora.label', default: 'Entregar AP artir Da Hora')}" />
					
						<g:sortableColumn property="entregarAteHora" title="${message(code: 'pedido.entregarAteHora.label', default: 'Entregar Ate Hora')}" />
					
						<g:sortableColumn property="numeroVolumes" title="${message(code: 'pedido.numeroVolumes.label', default: 'Numero Volumes')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${pedidoInstanceList}" status="i" var="pedidoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${pedidoInstance.id}">${fieldValue(bean: pedidoInstance, field: "cliente")}</g:link></td>
					
						<td><g:formatDate date="${pedidoInstance.dataEntrega}" /></td>
					
						<td><g:formatDate date="${pedidoInstance.dataPedido}" /></td>
					
						<td><g:formatDate date="${pedidoInstance.entregarAPartirDaHora}" /></td>
					
						<td><g:formatDate date="${pedidoInstance.entregarAteHora}" /></td>
					
						<td>${fieldValue(bean: pedidoInstance, field: "numeroVolumes")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${pedidoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
