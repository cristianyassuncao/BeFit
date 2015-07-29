<tr>
    <td>
	 	 <input type="hidden" name="itemPedido.quantidade" value="${item?.produto?.id}"/>
		 ${item?.produto?.nome}
	</td>
	<td>
	   <input type="hidden" name="itemPedido.quantidade" value="${itemPedido?.quantidade}"/>
		 ${item?.quantidade}
	</td>
	<td>
	 	 <input type="hidden" name="itemPedido.valorUnitario" value="${itemPedido?.valorUnitario}"/>
		 ${item?.valorUnitario}
	</td>
	<td>
		 ${item?.totalItem}
	</td>
	<td>
	   <textarea hidden="true" name="itemPedido.alteracaoPrato" rows="3">${itemPedido?.alteracaoPrato}</textarea>
	   ${item?.alteracaoPrato}
	</td>
	<td>
	   <textarea hidden="true" name="itemPedido.alteracaoMolho" rows="3">${itemPedido?.alteracaoMolho}</textarea>	
	   ${item?.alteracaoMolho}
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