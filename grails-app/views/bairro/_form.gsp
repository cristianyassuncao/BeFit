<div class="campos">
    <div class="campo">
		<div class="nome">
	            <g:message code="bairro.nome.label" default="Nome" />
	            <span class="required-indicator">*</span>
		</div>
        <div class="valor">
            <input type="text" id="nome" name="nome" required="" value="${bairroInstance?.nome}" maxlength="100" size="50"/>
        </div>
	</div>    
</div>   
<div class="campos">
    <div class="campo">
		<div class="nome">
			<g:message code="bairro.cidade.label" default="Cidade" />
			<span class="required-indicator">*</span>
		</div>
        <div class="valor">
            <g:select id="cidade" name="cidade.id" from="${Cidade.list()}" optionKey="id" optionValue="nome" required="" value="${bairroInstance?.cidade?.id}" class="many-to-one"/>
        </div>
	</div>    
</div>