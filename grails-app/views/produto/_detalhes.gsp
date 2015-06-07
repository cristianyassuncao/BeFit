<g:if test="${somenteLeitura == null}">
    <div class="adicionar">
        <input class="add" type="button" value="Novo Pre&ccedil;o" onclick="addPreco(${produtoInstance?.id});"/>
    </div>
</g:if>
<fieldset>
    <legend>Hist&oacute;rico de Pre&ccedil;os</legend>
    <g:render template="/preco/list" model="['produtoInstance': produtoInstance, 'somenteLeitura': somenteLeitura]"/>
</fieldset>    