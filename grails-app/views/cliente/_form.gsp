<script>
    $(function(){
        $("#diaMesNascimento").mask("99/99");                 
    })  
</script>

<g:render template="/pessoa/dadosPrincipaisPF" model="['pessoaInstance': clienteInstance?.pessoa]" />
<g:render template="/pessoa/detalhes" model="['pessoaInstance': clienteInstance?.pessoa]" />