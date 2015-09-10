<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'entregador.label', default: 'Entregador')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-entregador" class="skip" tabindex="-1">
			<g:message code="default.link.skip.label" default="Skip to content&hellip;"/>
		</a>
		<div class="nav" role="navigation">
	        <ul>
	            <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
	            <li><g:link class="list" action="index"><g:message code="default.list.label"/></g:link></li>
	            <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
	        </ul>
		</div>
		<div id="show-entregador" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
			</g:if>
            <g:render template="/pessoa/dadosPrincipaisPFShow" model="['pessoaInstance': entregadorInstance?.pessoa]" />
            <fieldset>
                <legend>Dados Complementares</legend>
                <div class="campos">
                    <div class="campo">
                        <div class="nome">
                            <g:message code="entregador.dataContratacao.label"/>:
                        </div>
                        <div class="valor">
                            <g:formatDate date="${entregadorInstance?.dataContratacao}" format="dd/MM/yyyy"/>
                        </div>
                    </div>
                </div>
                <div class="campos">
	                 <div class="campo">
                      	 <div class="nome">
                             <g:message code="entregador.observacoes.label"/>:
                         </div>
                         <div class="valor"> 
                             ${entregadorInstance?.observacoes}
                         </div>    
	                 </div> 
                </div>   
            </fieldset>        
            <g:render template="/pessoa/detalhes" model="['pessoaInstance': entregadorInstance?.pessoa, 'somenteLeitura': true]" />
            <g:form url="[resource: entregadorInstance, action:'delete']" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${entregadorInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
			</g:form>
		</div>
	</body>
</html>