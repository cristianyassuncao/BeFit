<link rel="stylesheet" href="${createLinkTo(dir:'css',file:'pessoa.css')}"/>
<!-- Chosen: plugin JQuery com a habilidade de filtrar itens num campo select -->
<script type="text/javascript">
    jQuery(document).ready(function(){
        jQuery(".chosen").chosen({width: "200px", no_results_text: "Não há itens que correspondam ao critério especificado", search_contains: true});
    });
</script>
<!-- Fim do bloco Chosen -->
<div class="campos">
    <div class="campo">
        <div class="nome">
            <g:message code="endereco.rua.label"/>
            <span class="required-indicator">*</span>
        </div>
        <div class="valor">
            <input type="text" id="rua" name="rua" maxlength="200" size="80" value="${enderecoInstance?.rua}"/>
        </div>    
    </div>
</div>
<div class="campos">
    <div class="campo">
        <div class="nome">
            <g:message code="endereco.numero.label"/>
            <span class="required-indicator">*</span>
        </div>
        <div class="valor">
            <input type="text" id="numero" name="numero" maxlength="10" size="10" value="${enderecoInstance?.numero}"/>
        </div>    
    </div>
</div>
<div class="campos">
    <div class="campo">
        <div class="nome">
            <g:message code="endereco.complemento.label"/>
        </div>
        <div class="valor">
            <input type="text" id="complemento" name="complemento" maxlength="200" size="80" value="${enderecoInstance?.complemento}"/>
        </div>    
    </div>
</div>
<div class="campos">
    <div class="campo">
        <div class="nome">
            <g:message code="endereco.bairro.label" default="Bairro" />
            <span class="required-indicator">*</span>
        </div>
        <div class="valor">
            <select data-placeholder="Selecione um bairro" class="chosen" id="bairro" name="bairro.id"> 
                <option value=""></option>
                <g:each in="${Bairro.list(sort: 'nome')}" var="bairro">
                    <g:set var="isBairroSelecionado" value="${enderecoInstance?.bairro?.id == bairro?.id}"/>
                    <g:if test="${isBairroSelecionado}">
                        <option value="${bairro.id}" selected="selected">${bairro.nome}</option>
                    </g:if>
                    <g:if test="${!isBairroSelecionado}">
                        <option value="${bairro.id}">${bairro.nome}</option>
                    </g:if>
                </g:each>
            </select>
        </div>    
    </div>
</div>
<div class="campos">
    <div class="campo">
        <div class="nome">
            <g:message code="endereco.cep.label" default="Cep" />
        </div>
        <div class="valor">
            <input class="cep" type="text" id="cep" name="cep" maxlength="9" size="9" value="${enderecoInstance?.cep}"/>
        </div>    
    </div>
</div>
<div class="campos">
    <div class="campo">
        <div class="nome">
            <g:message code="endereco.pontoReferencia.label"/>
        </div>
        <div class="valor">
            <textarea id="pontoReferencia" name="pontoReferencia" rows="3" cols="70">${enderecoInstance?.pontoReferencia}</textarea>
        </div>    
    </div>
</div>
<div class="campos">
    <div class="campo">
        <div class="nome">
            <g:message code="endereco.tipoEndereco.label" default="Tipo" />
        </div>
        <div class="valor">
            <g:select id="tipoEndereco" name="tipoEndereco.id" from="${TipoEndereco.list(sort: 'descricao')}" optionKey="id" optionValue="descricao" noSelection="['':'-Escolha o Tipo de Endereço-']" value="${enderecoInstance?.tipoEndereco?.id}"/>
        </div>    
    </div>
</div>