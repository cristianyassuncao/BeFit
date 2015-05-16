<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pessoa.label', default: 'Pessoa')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-pessoa" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
                            <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                            <li><g:link class="list" action="index"><g:message code="default.list.label"/></g:link></li>
                            <li><g:link class="create" action="create">Nova Pessoa</g:link></li>
			</ul>
		</div>
		<div id="show-pessoa" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
                            <div class="message" role="status">${flash.message}</div>
			</g:if>
                        <fieldset>
                            <legend>Dados Gerais</legend>
                            <div class="campos">
                                <div class="campo">
                                    <div class="nome">
                                        <g:message code="pessoa.nome.label" default="Nome"/>:
                                    </div>
                                    <div class="valor">
                                        <g:fieldValue bean="${pessoaInstance}" field="nome"/>
                                    </div>
                                </div>
                                <div class="campo">
                                    <div class="nome">
                                        <g:message code="pessoa.dataInclusao.label" default="Data Inclusao" />:
                                    </div>
                                    <div class="valor">
                                        <g:formatDate date="${pessoaInstance?.dataInclusao}" format="dd/MM/yyyy"/>
                                    </div>
                                </div>
                            </div>
                            <div class="campos">
                                <div class="campo">
                                    <div class="nome">
                                        <g:message code="pessoa.diaMesNascimento.label"/>:
                                    </div>
                                    <div class="valor">
                                        ${pessoaInstance?.diaMesNascimento}
                                    </div>
                                </div>
                                <div class="campo">
                                    <div class="nome">
                                        <g:message code="pessoa.email.label"/>:
                                    </div>
                                    <div class="valor">
                                        ${pessoaInstance?.email}
                                    </div>
                                </div>    
                            </div>
                        </fieldset>    
                        <fieldset>    
                            <legend>Endere&ccedil;os</legend>
                            <g:render template="/endereco/list" model="[somenteLeitura: true]"/>
                        </fieldset>
			
                        <g:if test="${pessoaInstance?.telefones}">
                            <li class="fieldcontain">
                                    <span id="telefones-label" class="property-label"><g:message code="pessoa.telefones.label" default="Telefones" /></span>
                                    <g:each in="${pessoaInstance.telefones}" var="t">
                                        <span class="property-value" aria-labelledby="telefones-label"><g:link controller="telefone" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></span>
                                    </g:each>
                            </li>
                        </g:if>
			<g:form url="[action:'delete']" method="DELETE">
				<fieldset class="buttons">
                                        <input type="hidden" name="id" value="${pessoaInstance.id}">
					<g:link class="edit" action="edit" id="${pessoaInstance.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
