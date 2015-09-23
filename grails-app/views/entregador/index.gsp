<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'entregador.label', default: 'Entregador')}" />
		<title>Cadastro de Entregadores</title>
		<!-- Chosen: plugin JQuery com a habilidade de filtrar itens num campo select -->
		<link rel="stylesheet" href="/befit/js/chosen_v1.4.2/chosen.css"/>
		<script src="/befit/js/chosen_v1.4.2/chosen.jquery.js" type="text/javascript"></script>
		<script type="text/javascript">
		    jQuery(document).ready(function(){
		    	jQuery("#entregador").chosen({width: "350px", no_results_text: "Não há itens que correspondam ao critério especificado", search_contains: true});
		    });
		</script>
		<!-- Fim do bloco Chosen -->
	</head>
	<body>
		<a href="#list-entregador" class="skip" tabindex="-1">
			<g:message code="default.link.skip.label" default="Skip to content&hellip;"/>
		</a>
		<div class="nav" role="navigation">
			<ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-entregador" class="content scaffold-list" role="main">
			<h1>Entregadores</h1>
			<g:if test="${flash.message}">
	            <div class="message" role="status">${flash.message}</div>
			</g:if>
            <g:form id="ajaxForm" name="ajaxForm" url="[controller: 'entregador', action:'index']" update="[sucess:'message',failure:'error']">
                <div class="detalhes">
                    <table class="parametros">
                        <tr align='left'>
                            <td valign='middle'>
                            	<label for='entregador'><g:message code="entregador.nome.label"/>:</label>
                                <select data-placeholder="Selecione um entregador" class="chosen" id="entregador" name="entregador"> 
				                    <option value=""></option>
				                    <g:each in="${entregadores}" var="entregador">
				                        <option value="${entregador.id}">${entregador.nome}</option>				                        
				                    </g:each>
				                </select>
                            </td>
                        </tr>
                    </table>
                </div>
                <fieldset class="buttons">
                    <input class="procurar" type="submit" value="Procurar" />
                </fieldset>
            </g:form>
			<table class="listagem">
	            <thead>
	                <tr>
	                    <th>${message(code: 'entregador.id.label', default: 'Código')}</th>
	                    <th>${message(code: 'pessoa.nome.label', default: 'Nome')}</th>
	                </tr>
	            </thead>
	            <tbody>
	                <g:each in="${entregadorInstanceList}" status="i" var="entregadorInstance">
	                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
	                        <td><g:link action="show" id="${entregadorInstance.id}">${fieldValue(bean: entregadorInstance, field: "id")}</g:link></td>
	                        <td>${entregadorInstance?.nome}</td>
	                    </tr>
	                </g:each>
	            </tbody>
			</table>
			<div class="pagination">
	            <g:paginate total="${entregadorInstanceTotal ?: 0}" max="10"/>
			</div>
		</div>
	</body>
</html>