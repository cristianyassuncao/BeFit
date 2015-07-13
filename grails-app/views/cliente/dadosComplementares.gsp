<fieldset id="enderecoEntrega" class="padrao inline">
    <legend>Endereço de Entrega</legend>
    <div class="campos">
        ${pedido?.rua} ${pedido?.numero}
    </div>
    <div class="campos">
        ${pedido?.complemento}
    </div>
    <div class="campos">
        ${pedido?.bairro?.nome}
    </div>
    <div class="campos">
        ${pedido?.pontoReferencia}
    </div>
</fieldset>    

<fieldset class="padrao inline">
    <legend>Selecionar outro endereço de entrega</legend>
    <ul>
        <g:each var="endereco" in="${enderecos}" status="i">
            <li class="detalhe">
                <input type="radio" name="enderecoEntrega" onclick="carregarEnderecoEntrega(${endereco?.id})"/>
                <div class="dados">
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
</fieldset>

<fieldset class="padrao inline">
    <legend>Telefones</legend>
    <ul>
        <g:each var="telefone" in="${telefones}" status="i">
            <li class="detalhe">
                <div class="dados">
                    <div class="campos">
                        ${telefone?.numeroComMascara}
                        <g:if test="${telefone?.whatsapp}">(Whatsapp)</g:if>
                    </div>
                </div>
            </li>                
        </g:each>
    </ul>
</fieldset>