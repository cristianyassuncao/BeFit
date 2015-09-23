<!-- Chosen: plugin JQuery com a habilidade de filtrar itens num campo select -->
<link rel="stylesheet" href="/befit/js/chosen_v1.4.2/chosen.css"/>
<script src="/befit/js/chosen_v1.4.2/chosen.jquery.js" type="text/javascript"></script>
<script type="text/javascript">
    jQuery(document).ready(function(){
    	jQuery("#produto").chosen({width: "350px", no_results_text: "Não há itens que correspondam ao critério especificado", search_contains: true});
    });
</script>
<!-- Fim do bloco Chosen -->
<div class="campos">
	<div class="campo">
		<div class="nome">
			<g:message code="itemDia.data.label" default="Data" />
			<span class="required-indicator">*</span>
		</div>
        <div class="valor">
            <input type="text" id="data" name="data" class="data" value="<g:formatDate date="${itemDiaInstance?.data}" format="dd/MM/yyyy"/>"/>
        </div>    
	</div>
	<div class="campo">
		<div class="nome">
			<g:message code="itemDia.produto.label" default="Produto" />
			<span class="required-indicator">*</span>
		</div>
        <div class="valor">
        	<select data-placeholder="Selecione um produto" class="chosen" id="produto" name="produto.id"> 
                <option value=""></option>
                <g:each in="${Produto.list(sort: 'nome')}" var="produto">
                    <g:set var="isProdutoSelecionado" value="${itemDiaInstance?.produto?.id == produto?.id}"/>
                    <g:if test="${isProdutoSelecionado}">
                        <option value="${produto.id}" selected="selected">${produto.nome}</option>
                    </g:if>
                    <g:if test="${!isProdutoSelecionado}">
                        <option value="${produto.id}">${produto.nome}</option>
                    </g:if>
                </g:each>
            </select>
        </div>  
	</div>
</div>