/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

organizaMenu =  function horizontal() {
    var navItems = document.getElementById("menuBar").getElementsByTagName("li");
    for (var i=0; i< navItems.length; i++) {
        if(navItems[i].className == "submenu"){
            if(navItems[i].getElementsByTagName('ul')[0] != null){
                navItems[i].onmouseover=function() {
                    this.getElementsByTagName('ul')[0].style.display= "block";
                }
                navItems[i].onmouseout=function() {
                    this.getElementsByTagName('ul')[0].style.display = "none";
                }
            }
        }
    }
}

var Ajax;
if (Ajax && (Ajax != null)) {
    Ajax.Responders.register({
        onCreate: function() {
            if ($('spinner') && Ajax.activeRequestCount > 0)
                Effect.Appear('spinner', {duration:0.5, queue:'end'});
        },
        onComplete: function() {
            if ($('spinner') && Ajax.activeRequestCount == 0)
                Effect.Fade('spinner', {duration:0.5, queue:'end'});
        }
    });
}

window.onload = organizaMenu;

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
      $("input.cep").mask("99999-999");            
      $("input.telefone").mask("(99) 99999-999?9");
}); 