<tr>
    <td>
	 	<input type="hidden" name="itemPedido.produto" value="${itemPedido?.produto?.id}"/>
		${itemPedido?.produto?.nome}
	</td>
	<td>
	    <input type="hidden" name="itemPedido.quantidade" value="${itemPedido?.quantidade}"/>
		${itemPedido?.quantidade}
	</td>
	<td>
	 	<input type="hidden" name="itemPedido.valorUnitario" value="${itemPedido?.valorUnitario}"/>
		${itemPedido?.valorUnitario}
	</td>
	<td>
	    ${itemPedido?.totalItem}
	</td>
	<td>
	    <textarea hidden="true" name="itemPedido.alteracaoPrato" rows="3">${itemPedido?.alteracaoPrato}</textarea>
	    ${itemPedido?.alteracaoPrato}
	</td>
	<td>
	    <textarea hidden="true" name="itemPedido.alteracaoMolho" rows="3">${itemPedido?.alteracaoMolho}</textarea>	
	    ${itemPedido?.alteracaoMolho}
	</td>
	<td>
		<span class="botao_navegacao">
            <input class="edit" type="button" value="Alterar" onclick="editItem()">
        </span>
        <span class="botao_navegacao">
            <input class="delete" type="button" value="Excluir" onclick="deleteItem()">
        </span>
	</td>
</tr>