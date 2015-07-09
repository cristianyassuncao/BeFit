<!-- Chosen: plugin JQuery com a habilidade de filtrar itens num campo select -->
<link rel="stylesheet" href="/BeFit/js/chosen_v1.4.2/chosen.css"/>
<script src="/BeFit/js/chosen_v1.4.2/chosen.jquery.js" type="text/javascript"></script>
<script type="text/javascript">
    jQuery(document).ready(function(){
        jQuery(".chosen").chosen({width: "400px", no_results_text: "Não há itens que correspondam ao critério especificado", search_contains: true});
    });
</script>
<!-- Fim do bloco Chosen -->
<fieldset>
    <legend>Cliente</legend>
    <div class="campos">
        <div class="campo">
            <div class="nome">
                <g:message code="telefone.numero.label"/>:
            </div>
            <div class="valor">
                <input type="text" id="numeroTelefone" name="numeroTelefone" value="${pedido?.telefone}" size="14" class="telefone" onblur="${remoteFunction(controller:'cliente',action:'consultarPorTelefone', method: 'GET', params:'\'telefone=\' + escape(this.value)', before: 'atualizarSelect(\'cliente\',null); if (!isTelefonePreenchido(this.value)) return false;', onSuccess:'exibirDadosCliente(data)')}"/>
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

<fieldset>
    <legend>Detalhes do Pedido</legend>
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
                <g:message code="pedido.dataCadastro.label"/>:
            </div>
            <div class="valor">
                <input type="text" id="dataCadastro" name="dataCadastro" class="data" value="<g:formatDate date="${pedido?.dataCadastro}" format="dd/MM/yyyy"/>" readonly=""/>
            </div>    
        </div>
    </div>
    <div id="dadosEntrega" class="campos autoOverflow">
        <fieldset id="horarioEspecial">
            <legend>Horário Especial de Entrega</legend>
            <div class="campos">
                <div class="campo">
                    <div class="nome">
                        <g:message code="pedido.entregarAPartirDaHora.label"/>:
                    </div>
                    <div class="valor">
                        <input type="text" class="hora" name="entregarAPartirDaHora" value="${pedido?.entregarAPartirDaHora}"/>
                    </div>    
                </div>
                <div class="campo">
                    <div class="nome">
                        <g:message code="pedido.entregarAteHora.label"/>:
                    </div>
                    <div class="valor">
                        <input type="text" class="hora" name="entregarAteHora" value="${pedido?.entregarAteHora}"/>
                    </div>    
                </div>
            </div>    
        </fieldset>
        <div class="campo">
            <div class="nome">
                <g:message code="pedido.dataEntrega.label"/>:
                <span class="required-indicator">*</span>
            </div>
            <div class="valor">
                <input type="text" id="dataEntrega" name="dataEntrega" class="data" value="<g:formatDate date="${pedido?.dataEntrega}" format="dd/MM/yyyy"/>"/>
            </div>    
        </div>
    </div>
    <div class="campos">
        <div class="campo">
            <div class="nome">
                <g:message code="pedido.requerTalher.label"/>:
            </div>
            <div class="valor">
                <g:checkBox name="requerTalher" value="${pedido?.requerTalher}"/>
            </div>    
        </div>
        <div class="campo">
            <div class="nome">
                <g:message code="pedido.numeroVolumes.label" default="Numero Volumes" />:
                <span class="required-indicator">*</span>
            </div>
            <div class="valor">
                <g:field name="numeroVolumes" value="${fieldValue(bean: pedido, field: 'numeroVolumes')}"/>
            </div>    
        </div>
    </div>
    <div class="campos">
        <div class="campo">
            <div class="nome">
                <g:message code="pedido.observacao.label"/>:
            </div>
            <div class="valor">
                <textarea id="observacao" name="observacao" rows="3" cols="70">${pedido?.observacao}</textarea>
            </div>    
        </div>
    </div>
    <div class="campos">
        <div class="campo">
            <div class="nome">
                <g:message code="pedido.responsavelEntrega.label"/>:
            </div>
            <div class="valor">
                <select data-placeholder="Selecione um entregador" class="chosen" id="entregador" name="entregador.id"> 
                    <option value=""></option>
                    <g:each in="${entregadores}" var="entregador">
                        <g:set var="isEntregadorSelecionado" value="${pedido?.entregador?.id == entregador?.id}"/>
                        <g:if test="${isEntregadorSelecionado}">
                            <option value="${entregador.id}" selected="selected">${entregador.nome}</option>
                        </g:if>
                        <g:if test="${!isEntregadorSelecionado}">
                            <option value="${entregador.id}">${entregador.nome}</option>
                        </g:if>
                    </g:each>
                </select>
            </div>    
        </div>
    </div>    
</fieldset>
<fieldset>
    <legend>Itens</legend>
    <g:each in="${itensPedido?}" var="i">
    </g:each>
</fieldset>
<fieldset>
    <legend>Totais</legend>
    <div class="campos">
        <div class="campo">
            <div class="nome">
                <g:message code="pedido.valorAPagar.label"/>:
                <span class="required-indicator">*</span>
            </div>
            <div class="valor">
                <input type="text" id="valorAPagar" name="valorAPagar" value="<g:formatNumber number="${pedido?.valorAPagar}" format="###,##0.00"/>" size="13">
            </div>    
        </div>
        <div class="campo">
            <div class="nome">
                <g:message code="pedido.trocoPara.label"/>:
                <span class="required-indicator">*</span>
            </div>
            <div class="valor">
                <input type="text" id="trocoPara" name="trocoPara" value="<g:formatNumber number="${pedido?.trocoPara}" format="###,##0.00"/>" size="13">
            </div>    
        </div>
        <div class="campo">
            <div class="nome">
                <g:message code="pedido.valorTroco.label"/>:
                <span class="required-indicator">*</span>
            </div>
            <div class="valor">
                <input type="text" id="valorTroco" name="valorTroco" value="<g:formatNumber number="${pedido?.valorTroco}" format="###,##0.00"/>" readonly="" size="13"/>
            </div>    
        </div>
        <div class="campo">
            <div class="nome">
                <g:message code="pedido.valorPago.label"/>:
                <span class="required-indicator">*</span>
            </div>
            <div class="valor">
                <input type="text" id="valorPago" name="valorPago" value="<g:formatNumber number="${pedido?.valorPago}" format="###,##0.00"/>" size="13"/>
            </div>    
        </div>
    </div>    
</fieldset>    
