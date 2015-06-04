<div id="historicoPrecos">
    <ul>
        <g:each var="preco" in="${produtoInstance?.precos}" status="i">
            <li class="detalhe">
                <div class="dados">
                    <div class="campos">
                        <div class="campo">
                            <div class="nome">
                                <g:message code="preco.aPartirDe.label"/>:
                            </div>
                            <div class="valor"> 
                                ${preco?.aPartirDe}
                            </div>    
                        </div>
                        <div class="campo">
                            <div class="nome">
                                <g:message code="preco.valor.label"/>:
                            </div>
                            <div class="valor">
                                <format:formatNumber number="${preco?.valor}" format="#,##0.00"></format:formatNumber>
                            </div>
                        </div>
                    </div>
                </div>
                <g:if test="${somenteLeitura == null}">
                    <div class="operacoes">
                        <span class="botao_navegacao">
                            <input class="edit" type="button" value="Alterar" onclick="editPreco(${preco?.id})">
                        </span>
                        <span class="botao_navegacao">
                            <input class="delete" type="button" value="Excluir" onclick="deletePreco(${preco?.id})">
                        </span>
                    </div>
                </g:if>
            </li>                
        </g:each>
    </ul>
</div>