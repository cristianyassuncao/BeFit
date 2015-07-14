<ul>
    <g:each var="endereco" in="${enderecos}" status="i">
        <li class="detalhe">
            <div class="botaoSelecaoEndereco">
                <input type="radio" name="enderecoEntrega"/>
            </div>    
            <div class="enderecoParaSelecao">
                <div class="campos">
                    ${endereco?.rua}
                    ${endereco?.numero}
                </div>
                <div class="campos">
                    ${endereco?.complemento}
                </div>
                <div class="campos">
                    ${endereco?.bairro?.nome}
                </div>
                <div class="campos">
                    ${endereco?.pontoReferencia}
                </div>     
            </div>
        </li>                
    </g:each>
</ul>