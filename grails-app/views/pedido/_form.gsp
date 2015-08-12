<!-- Chosen: plugin JQuery com a habilidade de filtrar itens num campo select -->
<link rel="stylesheet" href="/BeFit/js/chosen_v1.4.2/chosen.css"/>
<script src="/BeFit/js/chosen_v1.4.2/chosen.jquery.js" type="text/javascript"></script>
<script type="text/javascript">
    jQuery(document).ready(function(){
    	jQuery("#produto").chosen({width: "350px", no_results_text: "Não há itens que correspondam ao critério especificado", search_contains: true})
    					  .change(function() {
				        	 carregarValorUnitario($(this).val(), $('#dataEntrega').val());				        	 			        		
			        	  });
    	jQuery("#entregador").chosen({width: "400px", no_results_text: "Não há itens que correspondam ao critério especificado", search_contains: true});
        jQuery("#cliente").chosen({width: "400px", no_results_text: "Não há itens que correspondam ao critério especificado", search_contains: true})
			        	  .change(function() {
				        	 carregarDadosComplementares($(this).val());
				        	 definirTelefone($(this).val())			        		
			        	  });
    });
</script>
<!-- Fim do bloco Chosen -->
<g:if test="${pedido?.id != null}">
	<div class="campos">
		<div class="campo">
		    <div class="nome">
		        <g:message code="pedido.id.label"/>:
		    </div> 
		    <div class="valor">
		        <input type="text" id="id" name="id" value="${pedido?.id}"/>
		    </div>
		</div>
	</div>
</g:if>
<fieldset>
    <legend>Cliente</legend>
    <div class="campos">
        <div class="campo">
            <div class="nome">
                <g:message code="telefone.numero.label"/>:
            </div>
            <div class="valor">
                <input type="text" id="numeroTelefone" name="telefone.numeroTelefone" readonly="${readOnly}" value="${pedido?.telefone?.numero}" size="14" class="telefone" onblur="${remoteFunction(controller:'pedido',action:'consultarClientePorTelefone', method: 'GET', params:'\'telefone=\' + escape(this.value)', before: 'atualizarSelect(\'cliente\',null); if (!isTelefonePreenchido(this.value)) return false;', onSuccess:'exibirDadosCliente(data)')}"/>
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
        <input class="add" type="button" value="Novo Cliente" onclick="adicionarCliente();">
    </div>
    <div id="dadosComplementares">
        <g:if test="${pedido?.cliente != null}">
            <g:render template="dadosComplementares" model="[endereco: pedido?.endereco, telefones: pedido?.cliente?.pessoa?.telefones]"/>
        </g:if>
    </div>    
</fieldset>

<fieldset id="detalhesPedido">
    <legend id="legendaDetalhesPedido">Detalhes do Pedido</legend>    
    <div id="dadosEntrega" class="campos autoOverflow">
        <fieldset id="horarioEspecial" class="padrao">
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
                <g:message code="pedido.dataCadastro.label"/>:
            </div>
            <div class="valor">
                <input type="text" id="dataCadastro" name="dataCadastro" class="data" value="<g:formatDate date="${pedido?.dataCadastro}" format="dd/MM/yyyy"/>" readonly=""/>
            </div>    
        </div>
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
        <div class="campo">
            <div class="nome">
                <g:message code="pedido.requerTalher.label"/>:
            </div>
            <div class="valor">
                <input type="checkbox" id="requerTalher" name="requerTalher" <g:if test="${pedido?.requerTalher}">checked</g:if> value="true">
            </div>    
        </div>
        <div class="campo">
            <div class="nome">
                <g:message code="pedido.numeroVolumes.label" default="Numero Volumes" />:
                <span class="required-indicator">*</span>
            </div>
            <div class="valor">
            	<input type="text" id="numeroVolumes" name="numeroVolumes" value="${pedido?.numeroVolumes}"/>                 
            </div>    
        </div>
    </div>
    <div class="campos">
        <div class="campo">
            <div class="nome">
                <g:message code="pedido.observacao.label"/>:
            </div>
            <div class="valor">
                <textarea id="observacao" name="observacao" rows="3">${pedido?.observacao}</textarea>
            </div>    
        </div>
    </div>
</fieldset>
<fieldset>
    <legend>Itens</legend>
    <div align="right"><input type="checkbox" checked="checked"> Exibir somente as opções do dia</div>
    <table id="itensPedido" class="itensPedido">
		<tr>
		    <th class="produto"><g:message code="itemPedido.produto.label"/></th>
		    <th class="quantidade valorNumerico"><g:message code="itemPedido.quantidade.label"/></th>
		  	<th class="valorUnitario valorNumerico"><g:message code="itemPedido.valorUnitario.label"/></th>
		  	<th class="valorTotalItem valorNumerico"><g:message code="itemPedido.valorTotalItem.label"/></th>
		  	<th class="alteracaoPrato"><g:message code="itemPedido.alteracaoPrato.label"/></th>
		  	<th class="alteracaoMolho"><g:message code="itemPedido.alteracaoMolho.label"/></th>
		  	<th class="operacoes">&nbsp;</th>
		</tr>
		<tr class="separador">
			<td>
				<select data-placeholder="Selecione um produto" class="itemPedido" id="produto"> 
                	<option value=""></option>
	                <g:each in="${produtos}" var="produto">
	                   <option value="${produto.id}">${produto.nome}</option>	                   
	                </g:each>
           		</select>
			</td>
			<td>
				<input type="text" id="quantidade" class="valorNumerico" onchange="atualizarValorTotalItem()"/>  	
			</td>
			<td>
				<input type="text" id="valorUnitario" class="valorNumerico" onchange="atualizarValorTotalItem()"/> 	
			</td>
			<td>
				<input type="text" id="valorTotalItem" class="valorNumerico" readonly="readonly"/> 	
			</td>
			<td>
	            <textarea id="alteracaoPrato" rows="3"></textarea>    
			</td>
			<td>
	        	<textarea id="alteracaoMolho" rows="3"></textarea>	 
			</td>
			<td>
				<div class="adicionar">
			        <input class="add" type="button" value="Novo Item" onclick="addItem();"/>
			    </div>
			</td>
		</tr>
		<g:each in="${itensPedido?}" var="i" status="j">
			<g:set var="classe" value="${(j % 2) == 0 ? 'par' : ''}"/>
			<g:render template="exibirItemPedido" model="['itemPedido': i, 'classe': classe]"/>
	    </g:each>
	</table>
</fieldset>
<fieldset>
    <legend>Pagamento</legend>
    <div class="campos">
        <div class="campo">
            <div class="nome">
                <g:message code="pedido.valorAPagar.label"/>:
                <span class="required-indicator">*</span>
            </div>
            <div class="valor">
                <input type="text" id="valorAPagar" class="valorNumerico" name="valorAPagar" value="<g:formatNumber number="${pedido?.valorAPagar}" format="###,##0.00"/>" size="13" readonly="readonly">
            </div>    
        </div>
        <div class="campo">
            <div class="nome">
                <g:message code="pedido.trocoPara.label"/>:
                <span class="required-indicator">*</span>
            </div>
            <div class="valor">
                <input type="text" id="trocoPara" class="valorNumerico" name="trocoPara" value="<g:formatNumber number="${pedido?.trocoPara}" format="###,##0.00"/>" size="13" onchange="atualizarValorTroco()">
            </div>    
        </div>
        <div class="campo">
            <div class="nome">
                <g:message code="pedido.valorTroco.label"/>:
                <span class="required-indicator">*</span>
            </div>
            <div class="valor">
                <input type="text" id="valorTroco" class="valorNumerico" name="valorTroco" value="<g:formatNumber number="${pedido?.valorTroco}" format="###,##0.00"/>" readonly="readonly" size="13"/>
            </div>    
        </div>
        <div class="campo">
            <div class="nome">
                <g:message code="pedido.valorPago.label"/>:
                <span class="required-indicator">*</span>
            </div>
            <div class="valor">
                <input type="text" id="valorPago" class="valorNumerico" name="valorPago" value="<g:formatNumber number="${pedido?.valorPago}" format="###,##0.00"/>" size="13"/>
            </div>    
        </div>
    </div>
  	<fieldset id="formaPagamento" class="padrao">
       <legend>Forma de Pagamento</legend>
       <g:radioGroup values="${FormaPagamento.list(order: 'nome').id}" labels="${FormaPagamento.list(order: 'nome').nome}" name="formaPagamento" value="${pedido?.formaPagamento?.id}">
       	  <span class="radioButton">${it.radio}</span>
       	  <span class="radioLabel">${it.label}</span>
       </g:radioGroup>
   	</fieldset>
</fieldset>