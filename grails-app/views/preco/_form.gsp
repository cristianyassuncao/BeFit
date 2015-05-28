<div class="campos">
    <div class="campo">
        <div class="nome">
            <g:message code="preco.aPartirDe.label"/>
            <span class="required-indicator">*</span>
        </div>
        <div class="valor">
            <input type="text" id="aPartirDe" name="aPartirDe" class="data" value="<g:formatDate date="${aPartirDe}" format="dd/MM/yyyy"/>" readonly=""/>
        </div>    
    </div>
</div>
<div class="campos">
    <div class="campo">
        <div class="nome">
            <g:message code="preco.valor.label"/>
            <span class="required-indicator">*</span>
        </div>
        <div class="valor">
            <input type="text" id="valor" name="valor" value="${valor}"/>
        </div>    
    </div>
</div>