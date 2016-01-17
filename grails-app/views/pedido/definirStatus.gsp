<fieldset id="statusPedido" class="padrao">
   <legend>Selecione o status</legend>
   <g:each in="${StatusPedido.values()}" var="s">
   		<input type="radio" name="statusADefinir" value="${s}"/>							       		
   		<span class="opcaoStatus">${s.descricao}</span>
   </g:each>	       
</fieldset>