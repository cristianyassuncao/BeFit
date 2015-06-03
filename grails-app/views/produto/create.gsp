<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'produto.css')}" />
        <g:javascript src="produto.js"/>
        <g:set var="entityName" value="${message(code: 'produto.label', default: 'Produto')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-produto" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="create-produto" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${produtoInstance}">
                <ul class="errors" role="alert">
                    <g:eachError bean="${produtoInstance}" var="error">
                        <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                    </g:eachError>
                </ul>
            </g:hasErrors>
            <g:form url="[resource:produtoInstance, action:'save']" enctype="multipart/form-data">
                <fieldset class="form">
                    <g:render template="form"/>
                    <div class="campos">
                        <div class="campo">
                            <div class="nome">
                                <g:message code="preco.valor.label"/>:
                            </div>
                            <div class="valor">
                                <input type="text" id="valor" name="valor"/>
                            </div>
                        </div>
                    </div>
                </fieldset>
                <fieldset class="buttons">
                        <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>