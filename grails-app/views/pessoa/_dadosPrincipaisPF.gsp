<script>
    $(function(){
        $("#diaMesNascimento").mask("99/99");                 
    })  
</script>
<input type="hidden" name="pessoa.id" value="${pessoaInstance?.id}">
<fieldset>
    <legend>Dados Gerais</legend>
    <div class="campos">
        <div class="campo">
            <div class="nome">
                <g:message code="pessoa.nome.label" default="Nome"/>:
                <span class="required-indicator">*</span>
            </div>
            <div class="valor">
                <input type="text" id="nome" name="pessoa.nome" value="${pessoaInstance?.nome}" maxlength="200" size="100"/>
            </div>
        </div>
        <div class="campo">
            <div class="nome">
                <g:message code="pessoa.dataInclusao.label" default="Data Inclusao" />:
                <span class="required-indicator">*</span>
            </div>
            <div class="valor">
                <input type="text" id="dataInclusao" name="pessoa.dataInclusao" class="data" value="<g:formatDate date="${pessoaInstance?.dataInclusao}" format="dd/MM/yyyy"/>" readonly=""/>
            </div>
        </div>
    </div>
    <div class="campos">
        <div class="campo">
            <div class="nome">
                <g:message code="pessoa.diaMesNascimento.label"/>:
            </div>
            <div class="valor">
                <input type="text" id="diaMesNascimento" name="pessoa.diaMesNascimento" value="${pessoaInstance?.diaMesNascimento}" maxlength="5" size="7"/>
            </div>
        </div>
        <div class="campo">
            <div class="nome">
                <g:message code="pessoa.email.label"/>:
            </div>
            <div class="valor">
                <input type="text" id="email" name="pessoa.email" value="${pessoaInstance?.email}" maxlength="200" size="90"/>
            </div>
        </div>
    </div>
</fieldset>