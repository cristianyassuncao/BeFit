<fieldset>
    <legend>Dados Gerais</legend>
    <div class="campos">
        <div class="campo">
            <div class="nome">
                <g:message code="pessoa.nome.label" default="Nome"/>:
            </div>
            <div class="valor">
                <g:fieldValue bean="${pessoaInstance}" field="nome"/>
            </div>
        </div>
        <div class="campo">
            <div class="nome">
                <g:message code="pessoa.dataInclusao.label" default="Data Inclusao" />:
            </div>
            <div class="valor">
                <g:formatDate date="${pessoaInstance?.dataInclusao}" format="dd/MM/yyyy"/>
            </div>
        </div>
    </div>
    <div class="campos">
        <div class="campo">
            <div class="nome">
                <g:message code="pessoa.diaMesNascimento.label"/>:
            </div>
            <div class="valor">
                ${pessoaInstance?.diaMesNascimento}
            </div>
        </div>
        <div class="campo">
            <div class="nome">
                <g:message code="pessoa.email.label"/>:
            </div>
            <div class="valor">
                ${pessoaInstance?.email}
            </div>
        </div>    
    </div>
</fieldset>