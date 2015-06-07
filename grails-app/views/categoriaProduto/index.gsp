<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'categoriaProduto.label', default: 'CategoriaProduto')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-categoriaProduto" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create">Nova Categoria de Produtos</g:link></li>
            </ul>
        </div>
        <div id="list-categoriaProduto" class="content scaffold-list" role="main">
            <h1>Categorias de produtos</h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <table>
                <thead>
                    <tr>
			<g:sortableColumn property="id" title="${message(code: 'categoriaProduto.id.label')}" />
                        <g:sortableColumn property="nome" title="${message(code: 'categoriaProduto.nome.label', default: 'Nome')}" />
                        <th><g:message code="categoriaProduto.categoriaPai.label" default="Categoria Pai" /></th>
                    </tr>
                </thead>
                <tbody>
                    <g:each in="${categoriaProdutoInstanceList}" status="i" var="categoriaProdutoInstance">
                        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                            <td><g:link action="show" id="${categoriaProdutoInstance.id}">${fieldValue(bean: categoriaProdutoInstance, field: "id")}</g:link></td>
                            <td>${fieldValue(bean: categoriaProdutoInstance, field: "nome")}</td>
                            <td>${categoriaProdutoInstance?.categoriaPai?.nome}</td>
                        </tr>
                    </g:each>
                </tbody>
            </table>
            <div class="pagination">
                <g:paginate total="${categoriaProdutoInstanceCount ?: 0}" />
            </div>
        </div>
    </body>
</html>