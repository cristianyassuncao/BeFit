<fieldset>
    <legend>Dados Complementares</legend>
    <div class="campos">
        <div class="campo">
            <div class="nome">
                <g:message code="cliente.dataInclusao.label"/>:
                <span class="required-indicator">*</span>
            </div>
            <div class="valor">
                <input type="text" id="dataInclusao" name="dataInclusao" value="<g:formatDate date="${clienteInstance?.dataInclusao}" format="dd/MM/yyyy"/>" readonly=""/>
            </div>
        </div>
    </div>
    <div class="campos">
        <div class="campo">
            <div class="nome">
                <g:message code="cliente.observacoes.label"/>:
            </div>
            <div class="valor">
                <textarea id="observacoes" name="observacoes" rows="3" cols="70">${clienteInstance?.observacoes}</textarea>
            </div>
        </div>
    </div>    
</fieldset>        