<input type="hidden" name="endereco.rua" value="${endereco?.rua}"/>
<input type="hidden" name="endereco.numero" value="${endereco?.numero}"/>
<input type="hidden" name="endereco.complemento" value="${endereco?.complemento}"/>
<input type="hidden" name="endereco.bairro.id" value="${endereco?.bairro?.id}"/>
<input type="hidden" name="endereco.pontoReferencia" value="${endereco?.pontoReferencia}"/>
<fieldset class="padrao inline">
    <legend>Endereço de Entrega</legend>
    <div id="enderecoEntrega">
        <div class="campos">
            <span id="ruaEntrega">${endereco?.rua}</span>
            <span id="numeroEntrega">${endereco?.numero}</span>
        </div>
        <div class="campos">
            <span id="complementoEntrega">${endereco?.complemento}</span>
        </div>
        <div class="campos">
            <span id="bairroEntrega">${endereco?.bairro?.nome}</span>
        </div>
        <div class="campos">
            <span id="pontoReferenciaEntrega">${endereco?.pontoReferencia}</span>
        </div>
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
</fieldset>
<fieldset class="padrao inline observacoesCliente">
    <legend>Observações</legend>
    <div>
        <div class="campos">
            <textarea id="observacoesCliente" rows="3" cols="70">${observacoes}</textarea>
        </div>
    </div>
</fieldset>