<tr class="separador ${classe}">
    <td>
	 	<input type="hidden" name="itemPedido.produto" value="${itemPedido?.produto?.id}"/>
		${itemPedido?.produto?.nome}
	</td>
	<td class="valorNumerico">
	    <input type="hidden" name="itemPedido.quantidade" value="${itemPedido?.quantidade}"/>
		${itemPedido?.quantidade}
	</td>
	<td class="valorNumerico">
	 	<input type="hidden" name="itemPedido.valorUnitario" value="${itemPedido?.valorUnitario}"/>
		${itemPedido?.valorUnitario}
	</td>
	<td class="valorNumerico">
		<input type="hidden" name="itemPedido.valorTotalItem" value="${itemPedido?.valorItem}"/>
	    ${itemPedido?.valorItem}
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
    	<input class="edit" type="button" onclick="editItem()">
        <input class="delete" type="button" onclick="deleteItem()">
	</td>
</tr>