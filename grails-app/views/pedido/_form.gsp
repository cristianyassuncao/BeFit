<!-- Chosen: plugin JQuery com a habilidade de filtrar itens num campo select -->
<link rel="stylesheet" href="/BeFit/js/chosen_v1.4.2/chosen.css"/>
<script src="/BeFit/js/chosen_v1.4.2/chosen.jquery.js" type="text/javascript"></script>
<script type="text/javascript">
    jQuery(document).ready(function(){
        jQuery(".chosen").chosen({width: "200px", no_results_text: "Não há itens que correspondam ao critério especificado", search_contains: true});
    });
</script>
<!-- Fim do bloco Chosen -->
<div class="campos">
    <div class="campo">
        <div class="nome">
            <g:message code="pedido.id.label"/>:
        </div>
        <div class="valor">
            <input type="text" id="id" name="id" value="${pedido?.id}"/>
        </div>
    </div>
    <div class="campo">
        <div class="nome">
            <g:message code="pedido.dataCadastro.label"/>
        </div>
        <div class="valor">
            <input type="text" id="dataCadastro" name="dataCadastro" class="data" value="<g:formatDate date="${pedido?.dataCadastro}" format="dd/MM/yyyy"/>"/>
        </div>    
    </div>
</div>

<fieldset>
    <legend>Cliente</legend>
    <div class="campos">
        <div class="campo">
            <div class="nome">
                <g:message code="telefone.numero.label"/>:
            </div>
            <div class="valor">
                <input type="text" id="telefone" name="telefone" value="${pedido?.telefone}" size="14" class="telefone"/>
            </div>
        </div>
        <div class="campo">
            <div class="nome">
                <g:message code="cliente.nome.label"/>:
            </div>
            <div class="valor">
                <select data-placeholder="Selecione um cliente" class="chosen" id="cliente" name="cliente.id"> 
                    <option value=""></option>
                    <g:each in="${clientes}" var="cliente">
                        <g:set var="isClienteSelecionado" value="${pedido?.cliente?.id == cliente?.id}"/>
                        <g:if test="${isClienteSelecionado}">
                            <option value="${cliente.id}" selected="selected">${cliente.nome}</option>
                        </g:if>
                        <g:if test="${!isClienteSelecionado}">
                            <option value="${cliente.id}">${cliente.nome}</option>
                        </g:if>
                    </g:each>
                </select>
            </div>
        </div>
    </div>
</fieldset>

<div class="campos">
    <div class="campo">
        <div class="nome">
            <g:message code="pedido.dataEntrega.label"/>
            <span class="required-indicator">*</span>
        </div>
        <div class="valor">
            <input type="text" id="dataEntrega" name="dataEntrega" class="data" value="<g:formatDate date="${pedido?.dataEntrega}" format="dd/MM/yyyy"/>"/>
        </div>    
    </div>
    <fieldset>
        <legend>Horário Especial</legend>
        <div class="campos">
            <div class="campo">
                <div class="nome">
                    <g:message code="pedido.entregarAPartirDaHora.label"/>
                </div>
                <div class="valor">
                    <input type="text" class="hora" name="entregarAPartirDaHora" value="${pedido?.entregarAPartirDaHora}"/>
                </div>    
            </div>
            <div class="campo">
                <div class="nome">
                    <g:message code="pedido.entregarAteHora.label"/>
                    <span class="required-indicator">*</span>
                </div>
                <div class="valor">
                    <input type="text" class="hora" name="entregarAteHora" value="${pedido?.entregarAteHora}"/>
                </div>    
            </div>
        </div>    
    </fieldset>    
</div>

<fieldset>
    <legend>Itens</legend>
    <g:each in="${pedido?.itens?}" var="i">
    </g:each>
</fieldset>    


<div class="campo">
	<div class="nome">
		<g:message code="pedido.numeroVolumes.label" default="Numero Volumes" />
		<span class="required-indicator">*</span>
	</div>
        <div class="valor">
            <g:field name="numeroVolumes" value="${fieldValue(bean: pedidoInstance, field: 'numeroVolumes')}" required=""/>

        </div>    
</div>

<div class="campo">
	<div class="nome">
		<g:message code="pedido.observacao.label" default="Observacao" />
		<span class="required-indicator">*</span>
	</div>
        <div class="valor">
            <g:textField name="observacao" required="" value="${pedidoInstance?.observacao}"/>

        </div>    
</div>

<div class="campo">
	<div class="nome">
		<g:message code="pedido.requerTalher.label" default="Requer Talher" />
		
	</div>
        <div class="valor">
            <g:checkBox name="requerTalher" value="${pedidoInstance?.requerTalher}" />

        </div>    
</div>

<div class="campo">
	<div class="nome">
		<g:message code="pedido.responsavelEntrega.label" default="Responsavel Entrega" />
		<span class="required-indicator">*</span>
	</div>
        <div class="valor">
            <g:select id="responsavelEntrega" name="responsavelEntrega.id" from="${Entregador.list()}" optionKey="id" required="" value="${pedidoInstance?.responsavelEntrega?.id}" class="many-to-one"/>

        </div>    
</div>

<div class="campo">
	<div class="nome">
		<g:message code="pedido.valorAPagar.label" default="Valor AP agar" />
		<span class="required-indicator">*</span>
	</div>
        <div class="valor">
            <g:field name="valorAPagar" value="${fieldValue(bean: pedidoInstance, field: 'valorAPagar')}" required=""/>

        </div>    
</div>

<div class="campo">
	<div class="nome">
		<g:message code="pedido.valorTroco.label" default="Valor Troco" />
		<span class="required-indicator">*</span>
	</div>
        <div class="valor">
            <g:field name="valorTroco" value="${fieldValue(bean: pedidoInstance, field: 'valorTroco')}" required=""/>

        </div>    
</div>