<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
                <g:javascript src="pessoa.js"/>
                <g:set var="entityName" value="${message(code: 'cliente.label', default: 'Cliente')}" />
		<title>Adicionar um novo cliente</title>
	</head>
	<body>
                <a href="#create-cliente" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
                            <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                            <li><g:link class="list" action="index">Listar</g:link></li>
			</ul>
		</div>
		<div id="create-cliente" class="content scaffold-create" role="main">
			<h1>Adicionar um novo cliente</h1>
			<g:if test="${flash.message}">
                            <div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${clienteInstance}">
                            <ul class="errors" role="alert">
                                <g:eachError bean="${clienteInstance}" var="error">
                                    <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                                </g:eachError>
                            </ul>
			</g:hasErrors>
			<g:form url="[resource:clienteInstance, action:'save']" >
                            <g:render template="/pessoa/dadosPrincipaisPF" model="['pessoaInstance': clienteInstance?.pessoa]"/>
                            <g:render template="form"/>
                            <g:render template="/endereco/cadastroComplementar" model="['enderecoInstance': enderecoInstance]"/>
                            <g:render template="/telefone/cadastroComplementar" model="['telefoneInstance': telefoneInstance]"/>
                            <fieldset class="buttons">
                                <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                            </fieldset>
			</g:form>
		</div>
	</body>
</html>
