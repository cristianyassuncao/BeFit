<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'itemDia.label', default: 'ItemDia')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-itemDia" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-itemDia" class="content scaffold-show" role="main">
			<h1>Item do Dia</h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<fieldset>
                <div class="campos">
                    <div class="campo">
                        <div class="nome">
                            <g:message code="itemDia.data.label"/>:
                        </div>
                        <div class="valor">
                           <g:formatDate date="${itemDiaInstance?.data}" format="dd/MM/yyyy"/>
                        </div>
                    </div>
                    <div class="campo">
                        <div class="nome">
                            <g:message code="itemDia.produto.label"/>:
                        </div>
                        <div class="valor">
                            ${itemDiaInstance?.produto?.nome}
                        </div>
                    </div>
                </div>
            </fieldset>    
			<g:form url="[resource:itemDiaInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${itemDiaInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
