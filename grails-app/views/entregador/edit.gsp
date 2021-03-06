<!DOCTYPE html>
<html>
	<head>
         <meta name="layout" content="main">
         <g:set var="entityName" value="${message(code: 'entregador.label', default: 'Entregador')}" />
         <title><g:message code="default.edit.label" args="[entityName]" /></title>
         <g:javascript src="pessoa.js"/>
         <script>
             $(function(){
                 $("#diaMesNascimento").mask("99/99");
             })  
         </script>
	</head>
	<body>
            <a href="#edit-entregador" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
            <div class="nav" role="navigation">
                <ul>
                    <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                    <li><g:link class="list" action="index"><g:message code="default.list.label"/></g:link></li>
                    <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
                </ul>
            </div>
            <div id="edit-entregador" class="content scaffold-edit" role="main">
                <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
                <g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
                </g:if>
                <g:hasErrors bean="${entregadorInstance}">
                    <ul class="errors" role="alert">
                        <g:eachError bean="${entregadorInstance}" var="error">
                            <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                        </g:eachError>
                    </ul>
                </g:hasErrors>
                <g:form url="[action:'update']">
                    <g:hiddenField name="id" value="${entregadorInstance?.id}" />
                    <fieldset class="form">
                        <g:render template="/pessoa/dadosPrincipaisPF" model="['pessoaInstance': entregadorInstance?.pessoa]" />
                        <g:render template="form"/>       
                        <g:render template="/pessoa/detalhes" model="['pessoaInstance': entregadorInstance?.pessoa]" />
                    </fieldset>
                    <fieldset class="buttons">
                        <g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                        <g:link class="cancel" controller="entregador" action="index">
                            <g:message code="treal.botaoCancelar" default="Cancelar"/>
                        </g:link>
                    </fieldset>
                </g:form>
            </div>
	</body>
</html>