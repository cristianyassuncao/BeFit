<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'produto.css')}" />
        <g:set var="entityName" value="${message(code: 'produto.label', default: 'Produto')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-produto" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="show-produto" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <fieldset>
                <div class="exibicaoProduto">
                    <div class="dadosProduto">
                        <div class="campos">
                            <div class="campo">
                                <div class="nome">
                                    <g:message code="produto.id.label"/>:
                                </div>
                                <div class="valor">
                                    <g:fieldValue bean="${produtoInstance}" field="id"/>
                                </div>
                            </div>
                        </div>
                        <div class="campos">
                            <div class="campo">
                                <div class="nome">
                                    <g:message code="produto.nome.label"/>:
                                </div>
                                <div class="valor">
                                    <g:fieldValue bean="${produtoInstance}" field="nome"/>
                                </div>
                            </div>
                        </div>
                        <div class="campos">
                            <div class="campo">
                                <div class="nome">
                                    <g:message code="produto.descricao.label"/>:
                                </div>
                                <div class="valor">
                                    <g:fieldValue bean="${produtoInstance}" field="descricao"/>
                                </div>
                            </div>
                        </div>
                        <div class="campos">
                            <div class="campo">
                                <div class="nome">
                                    <g:message code="produto.categorias.label"/>:
                                </div>
                                <div class="valor">
                                    <g:select name="categorias" from="${CategoriaProduto.list()}" multiple="multiple" optionKey="id" optionValue="nome" size="5" value="${produtoInstance?.categorias*.id}" class="many-to-many" readonly="readonly"/>
                                </div>
                            </div>
                        </div>
                    </div>    
                    <div class="imagemExibicao">
                        <div>
                            <img src="/BeFit/produto/exibirImagem?id=${produtoInstance?.id}" width='150' height="150"/>
                        </div>
                    </div>    
                </div>
            </fieldset>    
            <g:render template="/produto/detalhes" model="['produtoInstance': produtoInstance, 'somenteLeitura': true]"/>
            <g:form url="[resource:produtoInstance, action:'delete']" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${produtoInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>