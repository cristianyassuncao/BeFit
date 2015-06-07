<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'categoriaProduto.label', default: 'CategoriaProduto')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-categoriaProduto" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create">Nova categoria de produtos</g:link></li>
            </ul>
        </div>
        <div id="show-categoriaProduto" class="content scaffold-show" role="main">
            <h1>Categoria de Produtos</h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
           <fieldset>
                <div class="campos">
                    <div class="campo">
                        <div class="nome">
                            <g:message code="categoriaProduto.id.label"/>:
                        </div>
                        <div class="valor">
                            <g:fieldValue bean="${categoriaProdutoInstance}" field="id"/>
                        </div>
                    </div>
                </div>
                <div class="campos">
                    <div class="campo">
                        <div class="nome">
                            <g:message code="categoriaProduto.nome.label"/>:
                        </div>
                        <div class="valor">
                            <g:fieldValue bean="${categoriaProdutoInstance}" field="nome"/>
                        </div>
                    </div>
                </div>
                <div class="campos">
                    <div class="campo">
                        <div class="nome">
                            <g:message code="categoriaProduto.categoriaPai.label"/>:
                        </div>
                        <div class="valor">
                            ${categoriaProdutoInstance?.categoriaPai?.nome}
                        </div>
                    </div>
                </div>
            </fieldset>
            <g:form url="[resource:categoriaProdutoInstance, action:'delete']" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${categoriaProdutoInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
         </div>   
    </body>
</html>