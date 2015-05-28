<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'bairro.label', default: 'Bairro')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-bairro" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="list-bairro" class="content scaffold-list" role="main">
            <h1>Bairros</h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <table>
                <thead>
                    <tr>
                        <g:sortableColumn property="nome" title="${message(code: 'bairro.id.label', default: 'Código')}" />
                        <g:sortableColumn property="nome" title="${message(code: 'bairro.nome.label', default: 'Nome')}" />
                        <th><g:message code="bairro.cidade.label" default="Cidade" /></th>
                    </tr>
                </thead>
                <tbody>
                    <g:each in="${bairroInstanceList}" status="i" var="bairroInstance">
                        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                            <td><g:link action="show" id="${bairroInstance.id}">${fieldValue(bean: bairroInstance, field: "id")}</g:link></td>
                            <td>${fieldValue(bean: bairroInstance, field: "nome")}</td>
                            <td>${bairroInstance?.cidade?.nome}</td>
                        </tr>
                    </g:each>
                </tbody>
            </table>
            <div class="pagination">
                <g:paginate total="${bairroInstanceCount ?: 0}" />
            </div>
        </div>
    </body>
</html>