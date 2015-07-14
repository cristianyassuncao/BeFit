/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function isTelefonePreenchido(valor) {
    return (valor != '(__) _____-____');
}

function atualizarSelect(idControle, valor) {
    var controle = $('#' + idControle);
    controle.val(valor);
    controle.trigger("chosen:updated");
}

function carregarDadosComplementares(idCliente) {
    jQuery.ajax({
		  url: 'carregarDadosComplementares?idCliente=' + idCliente,
		  async: false,
		  success: function(data) {
			  $("#dadosComplementares").html(data);
		  }	  
	});
}

function exibirDadosCliente(data) {
    var clientes = JSON.parse(data);
    if (clientes.length == 0) {
        alert('Não há clientes cadastrados com esse número de telefone.');
        return;
    }
    if (clientes.length > 1) {
        alert('Este telefone está associado a mais de um cliente. Efetue o filtro pelo nome do cliente.');
        return;
    }
    atualizarSelect('cliente', clientes[0].id);
    carregarDadosComplementares(clientes[0].id);
}

function selecionarEnderecoEntrega(idCliente) {
    modalForm = $("<div></div>");
    titulo = 'Selecionar Outro Endereço de Entrega';
    modalForm.load('/BeFit/pedido/carregarEnderecos?idCliente=' + idCliente, 
                  function( response, status, xhr ) {
                    if ( status == "error" ) {
                        alert(response);
                        $(this).dialog("close");
                        $(this).dialog("destroy");
                    }
                 })
             .dialog({
                    modal: true,
                    autoOpen: false,
                    height: 400,
                    width: 367,
                    title: titulo,
                    show: "blind",
                    hide: "explode",
                    dialogClass: "system-dialog",
                    buttons: [
                        {
                            text: "Confirmar",
                            click: function() {
                                alert('cliquei');
                            }
                        },    
                        {
                            text: "Cancelar",
                            click: function() {
                                $(this).dialog("close");
                                $(this).dialog("destroy");
                            }
                        }
                    ]

              });	    
    modalForm.dialog('open');
    return false;
}        