<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'cliente.label', default: 'Cliente')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-cliente" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
                    <ul>
                        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                        <li><g:link class="list" action="index"><g:message code="default.list.label"/></g:link></li>
                        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
                    </ul>
		</div>
		<div id="show-cliente" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
                            <div class="message" role="status">${flash.message}</div>
			</g:if>
                        <fieldset>
                            <legend>Dados Gerais</legend>
                            <div class="campos">
                                <div class="campo">
                                    <div class="nome">
                                        <g:message code="cliente.nome.label" default="Nome"/>:
                                    </div>
                                    <div class="valor">
                                        <g:fieldValue bean="${clienteInstance}" field="nome"/>
                                    </div>
                                </div>
                                <div class="campo">
                                    <div class="nome">
                                        <g:message code="cliente.dataInclusao.label" default="Data Inclusao" />:
                                    </div>
                                    <div class="valor">
                                        <g:formatDate date="${clienteInstance?.dataInclusao}" format="dd/MM/yyyy"/>
                                    </div>
                                </div>
                            </div>
                            <div class="campos">
                                <div class="campo">
                                    <div class="nome">
                                        <g:message code="cliente.diaMesNascimento.label"/>:
                                    </div>
                                    <div class="valor">
                                        ${clienteInstance?.diaMesNascimento}
                                    </div>
                                </div>
                                <div class="campo">
                                    <div class="nome">
                                        <g:message code="cliente.email.label"/>:
                                    </div>
                                    <div class="valor">
                                        ${clienteInstance?.email}
                                    </div>
                                </div>    
                            </div>
                        </fieldset>    
                        <fieldset>    
                            <legend>Endere&ccedil;os</legend>
                            <g:render template="/endereco/list" model="[somenteLeitura: true]"/>
                        </fieldset>
			
                        <g:if test="${clienteInstance?.telefones}">
                            <li class="fieldcontain">
                                    <span id="telefones-label" class="property-label"><g:message code="cliente.telefones.label" default="Telefones" /></span>
                                    <g:each in="${clienteInstance.telefones}" var="t">
                                        <span class="property-value" aria-labelledby="telefones-label"><g:link controller="telefone" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></span>
                                    </g:each>
                            </li>
                        </g:if>
			<g:form url="[resource:clienteInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${clienteInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
