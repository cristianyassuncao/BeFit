<script>
    $(function(){
        $("input.cep").mask("99999-999");            
    })  
</script>
<g:hasErrors bean="${enderecoInstance}">
    <ul class="errors" role="alert">
        <g:eachError bean="${enderecoInstance}" var="error">
            <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
        </g:eachError>
    </ul>
</g:hasErrors>
<form id="formEndereco" action="/BeFit/pessoa/updateEndereco">
    <input type="hidden" name="id" value="${enderecoInstance?.id}"/>
    <input type="hidden" name="pessoa.id" value="${enderecoInstance?.pessoa?.id}"/>
    <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'pessoa.css')}" />
    <div class="campos">
        <div class="campo">
            <div class="nome">
                <g:message code="endereco.rua.label"/>
                <span class="required-indicator">*</span>
            </div>
            <div class="valor">
                <input type="text" id="rua" name="rua" required="" maxlength="200" size="80" value="${enderecoInstance?.rua}"/>
            </div>    
        </div>
    </div>
    <div class="campos">
        <div class="campo">
            <div class="nome">
                <g:message code="endereco.numero.label"/>
                <span class="required-indicator">*</span>
            </div>
            <div class="valor">
                <input type="text" id="numero" name="numero" required="" maxlength="10" size="10" value="${enderecoInstance?.numero}"/>
            </div>    
        </div>
    </div>
    <div class="campos">
        <div class="campo">
            <div class="nome">
                <g:message code="endereco.complemento.label"/>
            </div>
            <div class="valor">
                <input type="text" id="complemento" name="complemento" maxlength="200" size="80" value="${enderecoInstance?.complemento}"/>
            </div>    
        </div>
    </div>
    <div class="campos">
        <div class="campo">
            <div class="nome">
                <g:message code="endereco.bairro.label" default="Bairro" />
                <span class="required-indicator">*</span>
            </div>
            <div class="valor">
                <g:select id="bairro" name="bairro.id" from="${Bairro.list()}" optionKey="id" optionValue="nome" required="" noSelection="['':'-Escolha o Bairro-']" value="${enderecoInstance?.bairro?.id}"/>
            </div>    
        </div>
    </div>
    <div class="campos">
        <div class="campo">
            <div class="nome">
                <g:message code="endereco.cep.label" default="Cep" />
            </div>
            <div class="valor">
                <input class="cep" type="text" id="cep" name="cep" maxlength="9" size="9" value="${enderecoInstance?.cep}"/>
            </div>    
        </div>
    </div>
    <div class="campos">
        <div class="campo">
            <div class="nome">
                <g:message code="endereco.pontoReferencia.label"/>
            </div>
            <div class="valor">
                <textarea id="pontoReferencia" name="pontoReferencia" rows="3" cols="70">${enderecoInstance?.pontoReferencia}</textarea>
            </div>    
        </div>
    </div>
    <div class="campos">
        <div class="campo">
            <div class="nome">
                <g:message code="endereco.tipo.label" default="Tipo" />
            </div>
            <div class="valor">
                <g:select id="tipo" name="tipo.id" from="${TipoEndereco.list()}" optionKey="id" optionValue="descricao" noSelection="['':'-Escolha o Tipo de Endereço-']" value="${enderecoInstance?.tipo?.id}"/>
            </div>    
        </div>
    </div>
</form>