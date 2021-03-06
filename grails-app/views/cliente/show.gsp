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
            <g:render template="/pessoa/dadosPrincipaisPFShow" model="['pessoaInstance': clienteInstance?.pessoa]" />
            <fieldset>
                <legend>Dados Complementares</legend>
                <div class="campos">
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
                             <g:message code="cliente.observacoes.label"/>:
                         </div>
                         <div class="valor"> 
                             ${clienteInstance?.observacoes}
                         </div>    
	                 </div> 
                </div>   
            </fieldset>        
            <g:render template="/pessoa/detalhes" model="['pessoaInstance': clienteInstance?.pessoa, 'somenteLeitura': true]" />
            <g:form url="[resource:clienteInstance, action:'delete']" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${clienteInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
			</g:form>
		</div>
	</body>
</html>