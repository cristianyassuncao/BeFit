<script>
    $(function(){
        $("#diaMesNascimento").mask("99/99");                 
    })  
</script>

<g:if test="${somenteLeitura == null}">
    <div class="adicionar">
        <input class="add" type="button" value="Novo Endere&ccedil;o" onclick="addEndereco(${pessoaInstance?.id});"/>
    </div>
</g:if>
<fieldset>
    <legend>Endereços</legend>
    <g:render template="/endereco/list" model="['pessoaInstance': pessoaInstance, 'somenteLeitura': somenteLeitura]" />
</fieldset>
<fieldset>
    <legend>Telefones</legend>
    
</fieldset>    