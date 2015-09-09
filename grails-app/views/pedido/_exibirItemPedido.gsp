<tr class="separador ${classe}">
    <td>
	 	<input type="hidden" name="itemPedido.produto" value="${itemPedido?.produto?.id}"/>
	 	<input type="hidden" name="itemPedido.nomeProduto" value="${itemPedido?.produto?.nome}"/>
		${itemPedido?.produto?.nome}
	</td>
	<td class="valorNumerico">
	    <input type="hidden" name="itemPedido.quantidade" value="${itemPedido?.quantidade}"/>
		${itemPedido?.quantidade}
	</td>
	<td class="valorNumerico">
	 	<input type="hidden" name="itemPedido.valorUnitario" value="${itemPedido?.valorUnitario}"/>
		<g:formatNumber number="${itemPedido?.valorUnitario}" format="###,##0.00"/>
	</td>
	<td class="valorNumerico">
		<input type="hidden" name="itemPedido.valorTotalItem" value="${itemPedido?.valorItem}"/>
	    <g:formatNumber number="${itemPedido?.valorItem}" format="###,##0.00"/>
	</td>
	<td>
	    <textarea class="hidden" name="itemPedido.alteracaoPrato" rows="3">${itemPedido?.alteracaoPrato}</textarea>
	    ${itemPedido?.alteracaoPrato}
	</td>
	<td>
	    <textarea class="hidden" name="itemPedido.alteracaoMolho" rows="3">${itemPedido?.alteracaoMolho}</textarea>	
	    ${itemPedido?.alteracaoMolho}
	</td>
	<td>
		<g:if test="${!readOnly}">
	    	<input class="edit" type="button" onclick="editItem(this)">
	        <input class="delete" type="button" onclick="deleteItem(this)">
        </g:if>
	</td>
</tr>