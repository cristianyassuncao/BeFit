<fieldset>
    <legend>Detalhes do Produto</legend>
    <div class="detalhesProduto">
        <div class="dadosProduto">
            <div class="campos">
                <div class="campo">
                    <div class="nome">
                        <g:message code="produto.nome.label"/>:
                        <span class="required-indicator">*</span>
                    </div>
                    <div class="valor">
                        <input type="text" id="nome" name="nome" value="${produtoInstance?.nome}" maxlength="200" size="70"/>
                    </div>
                </div>
            </div>
            <div class="campos">
                <div class="campo">
                    <div class="nome">
                        <g:message code="produto.descricao.label"/>:
                    </div>
                    <div class="valor">
                        <textarea id="descricao" name="descricao" rows="3" cols="70">${produtoInstance?.descricao}</textarea>
                    </div>
                </div>
            </div>
            <div class="campos">
                <div class="campo">
                    <div class="nome">
                        <g:message code="produto.categorias.label"/>:
                    </div>
                    <div class="valor">
                        <g:select name="categorias" from="${CategoriaProduto.list()}" multiple="multiple" optionKey="id" optionValue="nome" size="5" value="${produtoInstance?.categorias*.id}" class="many-to-many"/>
                    </div>
                </div>
            </div>
            <g:if test="${isCadastroCompleto}">
                <div class="campos">
                    <div class="campo">
                        <div class="nome">
                            <g:message code="preco.valor.label"/>:
                        </div>
                        <div class="valor">
                            <input type="text" id="valor" name="valor" value="${precoInstance?.valor}"/>
                        </div>
                    </div>
                </div>
            </g:if>    
        </div>
        <div class="imagemExibicao">
            <div id="moldura">
                <g:if test="${produtoInstance?.imagem != null}">
                    <img id="imagemProduto" src="/BeFit/produto/exibirImagem?id=${produtoInstance?.id}" width='150' height="150"/>
                </g:if>    
                <g:if test="${produtoInstance?.imagem == null}">
                    <img id="imagemProduto" width='150' height="150"/>
                </g:if>    
            </div>        
            <div class="campos">
                <div class="campo">
                    <div class="nome">
                        <g:message code="produto.imagem.label"/>:
                    </div>
                    <div class="valor">
                        <input type="file" id="imagem" name="imagemFile" onchange="loadFile(event)" value=""/>
                    </div>  
                </div>    
            </div>
        </div>
    </div>    
</fieldset>    