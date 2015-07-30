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
                                var idEndereco = $("input[name='enderecoEntrega']:checked").val();
                                var rua = $('#rua' + idEndereco).text();
                                var numero = $('#numero' + idEndereco).text();
                                var complemento = $('#complemento' + idEndereco).text();
                                var idBairro = $('#idBairro' + idEndereco).val();
                                var nomeBairro = $('#nomeBairro' + idEndereco).text();
                                var pontoReferencia = $('#pontoReferencia' + idEndereco).text();
                                $("input[name='endereco.rua']").val(rua);
                                $("input[name='endereco.numero']").val(numero);
                                $("input[name='endereco.complemento']").val(complemento);
                                $("input[name='endereco.bairro.id']").val(idBairro);
                                $("input[name='endereco.pontoReferencia']").val(pontoReferencia);
                                $("#ruaEntrega").text(rua);
                                $("#numeroEntrega").text(numero);
                                $("#complementoEntrega").text(complemento);
                                $("#bairroEntrega").text(nomeBairro);
                                $("#pontoReferenciaEntrega").text(pontoReferencia);
                                $(this).dialog("close");
                                $(this).dialog("destroy");
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

function definirTelefone(idCliente) {
	jQuery.ajax({
		  url: 'carregarTelefonePrincipal?idCliente=' + idCliente,
		  async: false,
		  success: function(data) {
			  $("#numeroTelefone").val(data);
		  }
	});
}

function incluirProduto() {
	 jQuery.ajax({
		  url: 'incluirNovoProduto',
		  async: false,
		  success: function(data) {
			  $("#itensPedido").append(data);
		  }	  
	});
}

function carregarValorUnitario(idProduto, data) {
	if (data == "") {
		alert("Para carregar o valor unitário desse produto é necessário definir uma data de entrega para o pedido!")
		return;
	}
	
    jQuery.ajax({
		  url: 'carregarValorUnitario?idProduto=' + idProduto + '&' + 'data=' + data,
		  async: false,
		  success: function(valor) {
			  $("#valorUnitario").val(valor);
		  }	  
	});
}

function addItem() {
		
}