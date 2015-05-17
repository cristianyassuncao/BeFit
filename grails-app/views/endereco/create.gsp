<link rel="stylesheet" href="${createLinkTo(dir:'css',file:'pessoa.css')}" />
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
    <g:render template="/endereco/form" model="['enderecoInstance': enderecoInstance]" />
</form>