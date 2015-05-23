<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'cliente.label', default: 'Cliente')}" />
		<title>Cadastro de Clientes</title>
	</head>
	<body>
		<a href="#list-cliente" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
                            <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                            <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-cliente" class="content scaffold-list" role="main">
			<h1>Clientes</h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
                        <g:form id="ajaxForm" name="ajaxForm" url="[controller: 'cliente', action:'index']" update="[sucess:'message',failure:'error']">
                            <div class="detalhes">
                                <table class="parametros">
                                    <tr align='left'>
                                        <td valign='middle'>
                                            <label for='nome'><g:message code="pessoa.nome.label"/>:</label>
                                            <input id='nome' type='text' name='nome' maxlength="200" size="100"/>
                                            <label for='numeroTelefone'><g:message code="telefone.numero.label"/>:</label>
                                            <input type="text" id="numeroTelefone" name="numeroTelefone" size="14" class="telefone" value="${telefoneInstance?.numero}"/>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                            <div class="botoes">
                                <span class="botao">
                                    <input class="procurar" type="submit" value="Procurar" />
                                </span>
                            </div>
                        </g:form>
			<table class="listagem">
                            <thead>
                                <tr>
                                    <g:sortableColumn property="id" title="${message(code: 'cliente.id.label', default: 'Código')}" />
                                    <g:sortableColumn property="nome" title="${message(code: 'pessoa.nome.label', default: 'Nome')}" />
                                </tr>
                            </thead>
                            <tbody>
                                <g:each in="${clienteInstanceList}" status="i" var="clienteInstance">
                                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                        <td><g:link action="show" id="${clienteInstance.id}">${fieldValue(bean: clienteInstance, field: "id")}</g:link></td>
                                        <td>${clienteInstance?.pessoa?.nome}</td>
                                    </tr>
                                </g:each>
                            </tbody>
			</table>
			<div class="pagination">
                            <g:paginate total="${clienteInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
