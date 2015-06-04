<g:hasErrors bean="${telefoneInstance}">
    <ul class="errors" role="alert">
        <g:eachError bean="${precoInstance}" var="error">
            <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
        </g:eachError>
    </ul>
</g:hasErrors>
<form id="formPreco" action="/BeFit/produto/updatePreco">
    <input type="hidden" name="id" value="${telefoneInstance?.id}"/>
    <input type="hidden" name="pessoa.id" value="${telefoneInstance?.pessoa?.id}"/>
    <g:render template="/telefone/form" model="['telefoneInstance': telefoneInstance]" />
</form>