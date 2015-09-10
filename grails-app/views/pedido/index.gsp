<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pedido.label', default: 'Pedido')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		<link rel="stylesheet" href="${createLinkTo(dir:'css',file:'pedido.css')}" />
		<!-- Chosen: plugin JQuery com a habilidade de filtrar itens num campo select -->
		<link rel="stylesheet" href="/BeFit/js/chosen_v1.4.2/chosen.css"/>
		<script src="/BeFit/js/chosen_v1.4.2/chosen.jquery.js" type="text/javascript"></script>
		<script type="text/javascript">
		    jQuery(document).ready(function(){
		    	jQuery("#entregador").chosen({width: "400px", no_results_text: "Não há itens que correspondam ao critério especificado", search_contains: true});
		        jQuery("#cliente").chosen({width: "400px", no_results_text: "Não há itens que correspondam ao critério especificado", search_contains: true});
		    });
		</script>
<!-- Fim do bloco Chosen -->
	</head>
	<body>
		<a href="#list-pedido" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-pedido" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:form id="ajaxForm" name="ajaxForm" url="[controller: 'pedido', action:'index']" update="[sucess:'message',failure:'error']">
                <div class="detalhes">
                    <table class="parametros">
                        <tr align='left'>
                            <td valign='middle'>
                                <label for='numeroTelefone'><g:message code="telefone.numero.label"/>:</label>
                                <input type="text" id="numeroTelefone" name="numeroTelefone" size="14" class="telefone"/>
                                <label for='cliente'><g:message code="pedido.cliente.label"/>:</label>
                                <select data-placeholder="Selecione um cliente" class="chosen" id="cliente" name="cliente"> 
				                    <option value=""></option>
				                    <g:each in="${clientes}" var="cliente">
				                        <option value="${cliente.id}">${cliente.nome}</option>				                        
				                    </g:each>
				                </select>
				                <label for="entregador"><g:message code="pedido.responsavelEntrega.label"/>:</label>
				                <select data-placeholder="Selecione um entregador" class="chosen" id="entregador" name="entregador"> 
				                    <option value=""></option>
				                    <g:each in="${entregadores}" var="entregador">
				                        <option value="${entregador.id}">${entregador.nome}</option>
				                    </g:each>
				                </select>
                            </td>
                        </tr>
                        <tr>    
                            <td>
	                            <label for="dataEntrega"><g:message code="pedido.dataEntrega.label"/>:</label>
	                			<input type="text" id="dataEntrega" name="dataEntrega" class="data"/>
                            	<fieldset id="statusPedido" class="padrao">
							       <legend>Status do Pedido</legend>
							       <g:each in="${StatusPedido.values()}" var="s">
							       		<input type="checkbox" name="status" value="${s}"/>							       		
							       		<span class="opcaoStatus">${s.descricao}</span>
							       </g:each>	       
							   	</fieldset>
							   	<label for="pedidoPago"><g:message code="pedido.pago.label"/>:</label>
							   	<input type="checkbox" name="pago" id="pago" value="true"/>
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
						<g:sortableColumn property="id" title="Nº" />
						
						<g:sortableColumn property="cliente" title="${message(code: 'pedido.cliente.label')}"/>
					
						<g:sortableColumn property="dataEntrega" title="${message(code: 'pedido.dataEntrega.label', default: 'Data Entrega')}" />
					
						<g:sortableColumn property="entregador" title="${message(code: 'pedido.responsavelEntrega.label')}"/>

						<g:sortableColumn property="bairro" title="${message(code: 'endereco.bairro.label')}"/>
						
						<g:sortableColumn property="entregarAPartirDaHora" title="${message(code: 'pedido.entregarAPartirDaHora.label', default: 'Entregar AP artir Da Hora')}" />
					
						<g:sortableColumn property="entregarAteHora" title="${message(code: 'pedido.entregarAteHora.label', default: 'Entregar Ate Hora')}" />
					
						<g:sortableColumn property="valorAPagar" title="${message(code: 'pedido.valorAPagar.label')}" />
						
						<g:sortableColumn property="trocoPara" title="${message(code: 'pedido.trocoPara.label')}" />
						
						<g:sortableColumn property="valorTroco" title="${message(code: 'pedido.valorTroco.label')}" />
						
						<g:sortableColumn property="valorPago" title="${message(code: 'pedido.valorPago.label')}" />
						
						<g:sortableColumn property="numeroVolumes" title="${message(code: 'pedido.numeroVolumes.label', default: 'Numero Volumes')}" />
					
						<g:sortableColumn property="status" title="${message(code: 'pedido.status.label')}"/>
						
						<g:sortableColumn property="pago" title="${message(code: 'pedido.pago.label')}"/>
					</tr>
				</thead>
				<tbody>
					<g:each in="${pedidoInstanceList}" status="i" var="pedidoInstance">
						<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						
							<td><g:link action="show" id="${pedidoInstance.id}">${pedidoInstance?.id}</g:link></td>
							
							<td><g:link target="_blank" controller="cliente" action="show" id="${pedidoInstance?.cliente?.id}">${pedidoInstance?.cliente?.nome}</g:link></td>
						
							<td><g:formatDate date="${pedidoInstance.dataEntrega}" format="dd/MM/yyyy"/></td>
						
							<td>${pedidoInstance?.entregador?.nome}</td>
						
							<td>${pedidoInstance?.endereco?.bairro?.nome}</td>						
							
							<td><g:formatDate date="${pedidoInstance?.entregarAPartirDaHora}" format="HH:mm"/></td>
						
							<td><g:formatDate date="${pedidoInstance?.entregarAteHora}" format="HH:mm"/></td>
						
							<td><g:formatNumber number="${pedidoInstance?.valorAPagar}" format="###,##0.00"/></td>
							
							<td><g:formatNumber number="${pedidoInstance?.trocoPara}" format="###,##0.00"/></td>
							
							<td><g:formatNumber number="${pedidoInstance?.valorTroco}" format="###,##0.00"/></td>
							
							<td><g:formatNumber number="${pedidoInstance?.valorPago}" format="###,##0.00"/></td>
						
							<td>${fieldValue(bean: pedidoInstance, field: "numeroVolumes")}</td>
							
							<td>${pedidoInstance?.status?.descricao}</td>
							
							<td><input type="checkbox" <g:if test="${pedidoInstance?.isPago()}">checked="checked"</g:if> disabled="disabled"/></td>
						
						</tr>
					</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${pedidoInstanceTotal ?: 0}" max="30"/>
			</div>
		</div>
	</body>
</html>
