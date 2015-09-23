<g:hasErrors bean="${precoInstance}">
    <ul class="errors" role="alert">
        <g:eachError bean="${precoInstance}" var="error">
            <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
        </g:eachError>
    </ul>
</g:hasErrors>
<form id="formPreco" action="/befit/produto/updatePreco">
    <input type="hidden" name="id" value="${precoInstance?.id}"/>
    <input type="hidden" name="produto.id" value="${precoInstance?.produto?.id}"/>
    <g:render template="/preco/form" model="['precoInstance': precoInstance]" />
</form>