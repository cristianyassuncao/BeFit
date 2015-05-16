<script>
    $(function(){
        $("#diaMesNascimento").mask("99/99");                 
    })  
</script>

<fieldset>
    <legend>Dados Gerais</legend>
    <div class="campos">
        <div class="campo">
            <div class="nome">
                <g:message code="pessoa.nome.label" default="Nome"/>:
                <span class="required-indicator">*</span>
            </div>
            <div class="valor">
                <input type="text" id="nome" name="nome" value="${pessoaInstance?.nome}" maxlength="200" size="100"/>
            </div>
        </div>
        <div class="campo">
            <div class="nome">
                <g:message code="pessoa.dataInclusao.label" default="Data Inclusao" />:
                <span class="required-indicator">*</span>
            </div>
            <div class="valor">
                <input type="text" id="dataInclusao" name="dataInclusao" class="data" value="<g:formatDate date="${pessoaInstance?.dataInclusao}" format="dd/MM/yyyy"/>"/>
            </div>
        </div>
    </div>
    <div class="campos">
        <div class="campo">
            <div class="nome">
                <g:message code="pessoa.diaMesNascimento.label"/>:
            </div>
            <div class="valor">
                <input type="text" id="diaMesNascimento" name="diaMesNascimento" value="${pessoaInstance?.diaMesNascimento}" maxlength="5" size="7"/>
            </div>
        </div>
        <div class="campo">
            <div class="nome">
                <g:message code="pessoa.email.label"/>:
            </div>
            <div class="valor">
                <input type="text" id="email" name="email" value="${pessoaInstance?.email}" maxlength="200" size="90"/>
            </div>
        </div>
    </div>
</fieldset>    

<g:if test="${somenteLeitura == null}">
    <div class="adicionar">
        <input class="add" type="button" value="Novo Endere&ccedil;o" onclick="addEndereco(${pessoaInstance?.id});"/>
    </div>
    <fieldset>
        <legend>Endereços</legend>
        <g:render template="/endereco/list" model="['pessoaInstance': pessoaInstance]" />
    </fieldset>
    <fieldset>
        <legend>Telefones</legend>
    </fieldset>
</g:if>