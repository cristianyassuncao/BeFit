<div id="listaTelefones">
    <ul>
        <g:each var="telefone" in="${pessoaInstance?.telefones}" status="i">
            <li class="detalhe">
                <div class="dados">
                    <div class="campos">
                        <div class="campo">
                            <div class="nome">
                                <g:message code="telefone.numero.label"/>:
                            </div>
                            <div class="valor"> 
                                ${telefone?.numeroComMascara}
                            </div>    
                        </div>
                        <div class="campo">
                            <div class="nome">
                                <g:message code="telefone.whatsapp.label"/>:
                            </div>
                            <div class="valor">
                                <input type="checkbox" <g:if test="${telefone?.whatsapp}">checked</g:if> disabled="true">
                            </div>
                        </div>
                    </div>
                    <div class="campos">
                        <div class="campo">
                            <div class="nome">
                                <g:message code="telefone.tipoTelefone.label"/>:
                            </div>
                            <div class="valor">
                               ${telefone?.tipoTelefone?.descricao}
                            </div>
                        </div>
                    </div>    
                </div>
                <g:if test="${somenteLeitura == null}">
                    <div class="operacoes">
                        <span class="botao_navegacao">
                            <input class="edit" type="button" value="Alterar" onclick="editTelefone(${telefone?.id})">
                        </span>
                        <span class="botao_navegacao">
                            <input class="delete" type="button" value="Excluir" onclick="deleteTelefone(${telefone?.id})">
                        </span>
                    </div>
                </g:if>
            </li>                
        </g:each>
    </ul>
</div>