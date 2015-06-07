<script>
    $(function(){
          $("input.data").mask("99/99/9999");
          $("input.data").datepicker({
            dateFormat: 'dd/mm/yy',
            dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado'],
            dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
            dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
            monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
            monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],
            nextText: 'Próximo',
            prevText: 'Anterior'
           });
    }); 
</script>
<div class="campos">
    <div class="campo">
        <div class="nome">
            <g:message code="preco.aPartirDe.label"/>
            <span class="required-indicator">*</span>
        </div>
        <div class="valor">
            <input type="text" id="aPartirDe" name="aPartirDe" class="data" value="<g:formatDate date="${precoInstance?.aPartirDe}" format="dd/MM/yyyy"/>"/>
        </div>    
    </div>
</div>
<div class="campos">
    <div class="campo">
        <div class="nome">
            <g:message code="preco.valor.label"/>
            <span class="required-indicator">*</span>
        </div>
        <div class="valor">
            <input type="text" id="valor" name="valor" value="<g:formatNumber number="${precoInstance?.valor}" format="###,##0.00"/>"/>
        </div>    
    </div>
</div>