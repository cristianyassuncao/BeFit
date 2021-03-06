<script>
    $("input.telefone").mask("(99) 99999-999?9"); 
</script>
<div class="campos">
    <div class="campo">
        <div class="nome">
            <g:message code="telefone.numero.label"/>
            <span class="required-indicator">*</span>
        </div>
        <div class="valor">
            <input type="text" id="numero" name="numeroTelefone" size="14" class="telefone" value="${telefoneInstance?.numero}"/>
        </div>    
    </div>
    <div class="campo">
        <div class="nome">
            <g:message code="telefone.whatsapp.label"/>
        </div>
        <div class="valor">
            <input type="checkbox" id="whatsapp" name="whatsapp" <g:if test="${telefoneInstance?.whatsapp}">checked</g:if> value="true">
        </div>    
    </div>
</div>
<div class="campos">
    <div class="campo">
        <div class="nome">
            <g:message code="telefone.tipoTelefone.label" default="Tipo" />
        </div>
        <div class="valor">
            <g:select id="tipoTelefone" name="tipoTelefone.id" from="${TipoTelefone.list(sort: 'descricao')}" optionKey="id" optionValue="descricao" noSelection="['':'-Escolha o Tipo de Telefone-']" value="${telefoneInstance?.tipoTelefone?.id}"/>
        </div>    
    </div>
</div>