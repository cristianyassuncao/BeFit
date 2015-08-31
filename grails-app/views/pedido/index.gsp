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
						<g:sortableColumn property="id" title="Nº" />
						
						<g:sortableColumn property="cliente" title="${message(code: 'pedido.cliente.label')}"/>
					
						<g:sortableColumn property="dataEntrega" title="${message(code: 'pedido.dataEntrega.label', default: 'Data Entrega')}" />
					
						<g:sortableColumn property="entregador" title="${message(code: 'pedido.responsavelEntrega.label')}"/>

						<g:sortableColumn property="bairro" title="${message(code: 'endereco.bairro.label')}"/>
						
						<g:sortableColumn property="entregarAPartirDaHora" title="${message(code: 'pedido.entregarAPartirDaHora.label', default: 'Entregar AP artir Da Hora')}" />
					
						<g:sortableColumn property="entregarAteHora" title="${message(code: 'pedido.entregarAteHora.label', default: 'Entregar Ate Hora')}" />
					
						<g:sortableColumn property="valorAPagar" title="${message(code: 'pedido.valorAPagar.label')}" />
						
						<g:sortableColumn property="trocoPara" title="${message(code: 'pedido.trocoPara.label')}" />
						
						<g:sortableColumn property="valorTroco" title="${message(code: 'pedido.valorTroco.label')}" />
						
						<g:sortableColumn property="valorPago" title="${message(code: 'pedido.valorPago.label')}" />
						
						<g:sortableColumn property="numeroVolumes" title="${message(code: 'pedido.numeroVolumes.label', default: 'Numero Volumes')}" />
					
						<g:sortableColumn property="status" title="${message(code: 'pedido.status.label')}"/>
					</tr>
				</thead>
				<tbody>
					<g:each in="${pedidoInstanceList}" status="i" var="pedidoInstance">
						<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						
							<td><g:link action="show" id="${pedidoInstance.id}">${pedidoInstance?.id}</g:link></td>
							
							<td><g:link target="_blank" controller="cliente" action="show" id="${pedidoInstance?.cliente?.id}">${pedidoInstance?.cliente?.nome}</g:link></td>
						
							<td><g:formatDate date="${pedidoInstance.dataEntrega}" format="dd/MM/yyyy"/></td>
						
							<td>${pedidoInstance?.entregador?.nome}</td>
						
							<td>${pedidoInstance?.endereco?.bairro?.nome}</td>						
							
							<td><g:formatDate date="${pedidoInstance?.entregarAPartirDaHora}" format="HH:mm"/></td>
						
							<td><g:formatDate date="${pedidoInstance?.entregarAteHora}" format="HH:mm"/></td>
						
							<td><g:formatNumber number="${pedidoInstance?.valorAPagar}" format="###,##0.00"/></td>
							
							<td><g:formatNumber number="${pedidoInstance?.trocoPara}" format="###,##0.00"/></td>
							
							<td><g:formatNumber number="${pedidoInstance?.valorTroco}" format="###,##0.00"/></td>
							
							<td><g:formatNumber number="${pedidoInstance?.valorPago}" format="###,##0.00"/></td>
						
							<td>${fieldValue(bean: pedidoInstance, field: "numeroVolumes")}</td>
							
							<td>${pedidoInstance?.status?.descricao}</td>
						
						</tr>
					</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${pedidoInstanceTotal ?: 0}" max="30"/>
			</div>
		</div>
	</body>
</html>
