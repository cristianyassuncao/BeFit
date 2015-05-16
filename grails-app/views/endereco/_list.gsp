<div id="listaEnderecos">
    <ul>
        <g:each var="endereco" in="${pessoaInstance?.enderecos}" status="i">
            <li class="detalhe">
                <div class="dados">
                    <div class="campos">
                        <div class="campo">
                            <div class="nome">
                                <g:message code="endereco.rua.label"/>:
                            </div>
                            <div class="valor">
                               ${endereco?.rua}
                            </div>
                        </div>
                        <div class="campo">
                            <div class="nome">
                                <g:message code="endereco.numero.label"/>:
                            </div>
                            <div class="valor"> 
                                ${endereco?.numero}
                            </div>    
                        </div>
                    </div>
                    <div class="campos">
                        <div class="campo">
                            <div class="nome">
                                <g:message code="endereco.complemento.label"/>:
                            </div>
                            <div class="valor">
                               ${endereco?.complemento}
                            </div>
                        </div>
                    </div>
                    <div class="campos">
                        <div class="campo">
                            <div class="nome">
                                <g:message code="endereco.bairro.label"/>:
                            </div>
                            <div class="valor"> 
                                ${endereco?.bairro?.nome}
                            </div>    
                        </div>
                        <div class="campo">
                            <div class="nome">
                                <g:message code="endereco.cidade.label"/>:
                            </div>
                            <div class="valor"> 
                               ${endereco?.bairro?.cidade?.nome}
                            </div>    
                        </div>
                        <div class="campo">
                            <div class="nome">
                                <g:message code="endereco.cep.label"/>:
                            </div>
                            <div class="valor"> 
                                <input type="text" class="cep label" value="${endereco?.cep}" readonly="">
                            </div>    
                        </div> 
                    </div>
                    <div class="campos">
                        <div class="campo">
                            <div class="nome">
                                <g:message code="endereco.pontoReferencia.label"/>:
                            </div>
                            <div class="valor"> 
                                ${endereco?.pontoReferencia}
                            </div>    
                        </div> 
                    </div>     
                    <div class="campos">
                        <div class="campo">
                            <div class="nome">
                                <g:message code="endereco.tipo.label"/>:
                            </div>
                            <div class="valor"> 
                                ${endereco?.tipo?.descricao}
                            </div>    
                        </div> 
                    </div>
                </div>
                <g:if test="${somenteLeitura == null}">
                    <div class="operacoes">
                        <span class="botao_navegacao">
                            <input class="edit" type="button" value="Alterar" onclick="editEndereco(${endereco?.id})">
                        </span>
                        <span class="botao_navegacao">
                            <input class="delete" type="button" value="Excluir" onclick="deleteEndereco(${endereco?.id})">
                        </span>
                    </div>
                </g:if>
            </li>                
        </g:each>
    </ul>
</div>