

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'preco.label', default: 'Preco')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-preco" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-preco" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="aPartirDe" title="${message(code: 'preco.aPartirDe.label', default: 'A Partir De')}" />
					
						<th><g:message code="preco.produto.label" default="Produto" /></th>
					
						<g:sortableColumn property="valor" title="${message(code: 'preco.valor.label', default: 'Valor')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${precoInstanceList}" status="i" var="precoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${precoInstance.id}">${fieldValue(bean: precoInstance, field: "aPartirDe")}</g:link></td>
					
						<td>${fieldValue(bean: precoInstance, field: "produto")}</td>
					
						<td>${fieldValue(bean: precoInstance, field: "valor")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${precoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
