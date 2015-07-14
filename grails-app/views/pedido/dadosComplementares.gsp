<input type="hidden" name="endereco.rua" value="${endereco?.rua}"/>
<input type="hidden" name="endereco.numero" value="${endereco?.numero}"/>
<input type="hidden" name="endereco.complemento" value="${endereco?.complemento}"/>
<input type="hidden" name="endereco.bairro.id" value="${endereco?.bairro?.id}"/>
<input type="hidden" name="endereco.pontoReferencia" value="${endereco?.pontoReferencia}"/>
<fieldset id="enderecoEntrega" class="padrao inline">
    <legend>Endereço de Entrega</legend>
    <div class="campos">
        ${endereco?.rua} ${endereco?.numero}
    </div>
    <div class="campos">
        ${endereco?.complemento}
    </div>
    <div class="campos">
        ${endereco?.bairro?.nome}
    </div>
    <div class="campos">
        ${endereco?.pontoReferencia}
    </div>
    <input class="add" type="button" id="buttonSelecionarOutroEndereco" value="Selecionar outro endereço" onclick="selecionarEnderecoEntrega(${cliente?.id});">
</fieldset>    

<fieldset class="padrao inline" id="telefones">
    <legend>Telefones Adicionais</legend>
        <g:each var="telefone" in="${telefones}" status="i">
            <div>
                <div class="campos">
                    ${telefone?.numeroComMascara}
                    <g:if test="${telefone?.whatsapp}">(Whatsapp)</g:if>
                </div>
            </div>
        </g:each>
    </ul>
</fieldset>