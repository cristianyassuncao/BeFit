<fieldset>
    <legend>Dados Complementares</legend>
    <div class="campos">
        <div class="campo">
            <div class="nome">
                <g:message code="entregador.dataContratacao.label"/>:
                <span class="required-indicator">*</span>
            </div>
            <div class="valor">
                <input type="text" class="data" id="dataContratacao" name="dataContratacao" value="<g:formatDate date="${entregadorInstance?.dataContratacao}" format="dd/MM/yyyy"/>"/>
            </div>
        </div>
    </div>
    <div class="campos">
        <div class="campo">
            <div class="nome">
                <g:message code="entregador.observacoes.label"/>:
            </div>
            <div class="valor">
                <textarea id="observacoes" name="observacoes" rows="3" cols="70">${entregadorInstance?.observacoes}</textarea>
            </div>
        </div>
    </div>    
</fieldset>