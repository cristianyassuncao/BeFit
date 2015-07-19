<ul>
    <g:each var="endereco" in="${enderecos}" status="i">
        <g:set var="idEndereco" value="${endereco.id}"/>
        <li class="detalhe">
            <div class="botaoSelecaoEndereco">
                <input type="radio" name="enderecoEntrega" value="${idEndereco}"/>
            </div>    
            <div id="endereco${idEndereco}" class="enderecoParaSelecao">
                <div class="campos">
                    <span id="rua${idEndereco}">${endereco?.rua}</span>
                    <span id="numero${idEndereco}">${endereco?.numero}</span>
                </div>
                <div class="campos">
                    <span id="complemento${idEndereco}">${endereco?.complemento}</span>
                </div>
                <div class="campos">
                    <input type="hidden" id="idBairro${idEndereco}" value="${endereco?.bairro?.id}"/>
                    <span id="nomeBairro${idEndereco}">${endereco?.bairro?.nome}</span>
                </div>
                <div class="campos">
                    <span id="pontoReferencia${idEndereco}">${endereco?.pontoReferencia}</span>
                </div>     
            </div>
        </li>                
    </g:each>
</ul>