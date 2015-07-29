<div class="campos">
    <div class="campo">
        <div class="nome">
            <g:message code="itemPedido.produto.label"/>:
        </div>
        <div class="valor">
            <select data-placeholder="Selecione um produto" class="itemPedido" name="itemPedido.produto"> 
               <option value=""></option>
               <g:each in="${produtos}" var="produto">
                   <g:set var="isProdutoSelecionado" value="${produto?.id == itemPedido?.produto?.id}"/>
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
    <div class="campo">
        <div class="nome">
            <g:message code="itemPedido.quantidade.label"/>:
        </div>
        <div class="valor">
            <input type="text" name="itemPedido.quantidade" value="${itemPedido?.quantidade}"/>
        </div>    
    </div>
    <div class="campo">
        <div class="nome">
            <g:message code="itemPedido.valorUnitario.label"/>:
        </div>
        <div class="valor">
            <input type="text" name="itemPedido.valorUnitario" value="${itemPedido?.valorUnitario}"/>
        </div>    
    </div>
    <div class="campo">
        <div class="nome">
            <g:message code="itemPedido.pratoSofreuAlteracao.label"/>:
        </div>
        <div class="valor">
        	<input type="checkbox" name="itemPedido.pratoSofreuAlteracao" <g:if test="${itemPedido?.pratoSofreuAlteracao}">checked</g:if> value="true">
            <textarea name="itemPedido.alteracaoPrato" rows="3">${itemPedido?.alteracaoPrato}</textarea>
        </div>    
    </div>
    <div class="campo">
        <div class="nome">
            <g:message code="itemPedido.molhoSofreuAlteracao.label"/>:
        </div>
        <div class="valor">
        	<input type="checkbox" name="itemPedido.molhoSofreuAlteracao" <g:if test="${itemPedido?.molhoSofreuAlteracao}">checked</g:if> value="true">
        	<textarea name="itemPedido.alteracaoMolho" rows="3">${itemPedido?.alteracaoMolho}</textarea>	
        </div>    
    </div>
    <input class="add" type="button" value="Incluir" onclick="incluirProduto();">
</div>