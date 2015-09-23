<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'itemDia.label', default: 'ItemDia')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		<!-- Chosen: plugin JQuery com a habilidade de filtrar itens num campo select -->
		<link rel="stylesheet" href="/befit/js/chosen_v1.4.2/chosen.css"/>
		<script src="/befit/js/chosen_v1.4.2/chosen.jquery.js" type="text/javascript"></script>
		<script type="text/javascript">
		    jQuery(document).ready(function(){
		    	jQuery("#produto").chosen({width: "350px", no_results_text: "Não há itens que correspondam ao critério especificado", search_contains: true});
		    });
		</script>
		<!-- Fim do bloco Chosen -->
	</head>
	<body>
		<a href="#list-itemDia" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-itemDia" class="content scaffold-list" role="main">
			<h1>Itens do Dia</h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:form id="ajaxForm" name="ajaxForm" url="[controller: 'itemDia', action:'index']" update="[sucess:'message',failure:'error']">
                <div class="detalhes">
                    <table class="parametros">
                        <tr>    
                            <td>
	                            <label for="data"><g:message code="itemDia.data.label"/>:</label>
	                			<input type="text" id="data" name="data" class="data"/>
                            	<label for='produto'><g:message code="itemDia.produto.label"/>:</label>
                            	<select data-placeholder="Selecione um produto" class="chosen" id="produto" name="produto.id"> 
				                    <option value=""></option>
				                    <g:each in="${Produto.list(sort: 'nome')}" var="produto">
				                        <option value="${produto.id}">${produto.nome}</option>				                        
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
			<table>
				<thead>
					<tr>
						<g:sortableColumn property="data" title="${message(code: 'itemDia.data.label', default: 'Data')}" />
						<g:sortableColumn property="produto.nome" title="${message(code: 'itemDia.produto.label', default: 'Produto')}"/>
					</tr>
				</thead>
				<tbody>
					<g:each in="${itemDiaInstanceList}" status="i" var="itemDiaInstance">
						<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
							<td><g:link action="show" id="${itemDiaInstance.id}"><g:formatDate date="${itemDiaInstance?.data}" format="dd/MM/yyyy"/></g:link></td>
							<td>${itemDiaInstance?.produto?.nome}</td>
						</tr>
					</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${itemDiaInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
