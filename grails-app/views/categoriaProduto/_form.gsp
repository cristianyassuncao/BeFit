<div class="campos">
    <div class="campo">
	<div class="nome">
            <g:message code="categoriaProduto.nome.label" default="Nome" />
            <span class="required-indicator">*</span>
	</div>
        <div class="valor">
            <g:textField name="nome" value="${categoriaProdutoInstance?.nome}" maxlength="100" size="70"/>
        </div>    
    </div>
</div>
<div class="campos">
    <div class="campo">
	<div class="nome">
            <g:message code="categoriaProduto.categoriaPai.label" default="Nome" />
	</div>
        <div class="valor">
            <g:select id="categoriaPai" name="categoriaPai.id" from="${CategoriaProduto.list()}" optionKey="id" optionValue="nome" value="${categoriaProdutoInstance?.categoriaPai?.id}" class="many-to-one" noSelection="['':'-Escolha a Categoria-']"/>
        </div>    
    </div>
</div>