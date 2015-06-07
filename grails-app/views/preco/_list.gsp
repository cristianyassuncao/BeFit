<div id="historicoPrecos">
    <table>
        <thead>
            <th>A Partir De</th>
            <th>Valor</th>
            <th>&nbsp;</th>
        </thead>    
        <g:each var="preco" in="${produtoInstance?.precos}" status="i">
            <tr class="separador">
                <td><g:formatDate date="${preco?.aPartirDe}" format="dd/MM/yyyy"/></td>
                <td><g:formatNumber number="${preco?.valor}" format="###,##0.00"/></td>
                <td>
                    <g:if test="${somenteLeitura == null}">
                        <div>
                            <span class="botao_navegacao">
                                <input class="edit" type="button" value="Alterar" onclick="editPreco(${preco?.id})">
                            </span>
                            <span class="botao_navegacao">
                                <input class="delete" type="button" value="Excluir" onclick="deletePreco(${preco?.id})">
                            </span>
                        </div>
                    </g:if>
                </td>
            </tr>    
        </g:each>
    </table>
</div>