<script>
    $(function(){
        $("#diaMesNascimento").mask("99/99");                 
    })  
</script>

<g:render template="/pessoa/dadosPrincipaisPF" model="['pessoaInstance': clienteInstance?.pessoa]" />
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
</fieldset>        
<g:render template="/pessoa/detalhes" model="['pessoaInstance': clienteInstance?.pessoa]" />