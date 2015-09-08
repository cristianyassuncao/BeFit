/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 */

var itemEditado = null;
var excluirItemSelectAposEdicao = false;

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
		  url: '/BeFit/pedido/carregarDadosComplementares?idCliente=' + idCliente,
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
		  url: '/BeFit/pedido/carregarTelefonePrincipal?idCliente=' + idCliente,
		  async: false,
		  success: function(data) {
			  $("#numeroTelefone").val(data);
		  }
	});
}

function carregarValorUnitario(idProduto, data) {
	if (data == "") {
		alert("Para carregar o valor unitário desse produto é necessário definir uma data de entrega para o pedido!")
		return;
	}
	
    jQuery.ajax({
		  url: '/BeFit/pedido/carregarValorUnitario?idProduto=' + idProduto + '&' + 'data=' + data,
		  async: false,
		  success: function(valor) {
			  $("#valorUnitario").val(valor);
		  }	  
	});
}

function getItem() {
	return {idProduto: $('#produto').val(),
		    nomeProduto: $('#produto option:selected').html(),
			quantidade: $('#quantidade').val(),
			valorUnitario: $('#valorUnitario').val(),
			alteracaoPrato: $("#alteracaoPrato").val(),
			alteracaoMolho: $("#alteracaoMolho").val(),
			valorTotal: $('#valorTotalItem').val()
		   };
}

function calculaValorTotalItem(quantidadeFormatada, valorUnitarioFormatado) {
	var quantidadeValor = converterValorUsandoPontoSeparadorDecimal(quantidadeFormatada);
	var valorUnitario = converterValorUsandoPontoSeparadorDecimal(valorUnitarioFormatado);
	return converterValorUsandoVirgulaSeparadorDecimal(parseFloat(quantidadeValor * valorUnitario).toFixed(2))
}

function atualizarValorTotalItem() {
	var quantidade = $('#quantidade').val();
    var valorUnitario = $("#valorUnitario").val();
	var valorTotalItem = calculaValorTotalItem(quantidade, valorUnitario);
	$("#valorTotalItem").val(valorTotalItem);
}

function addItem() {
	var item = getItem();
	if (!isItemPreenchido(item)) return false; 
	inserirLinhaTabelaItens(item);
	limparFormularioAdicaoItens();
	totalizarPedido();
	if (excluirItemSelectAposEdicao) {
		removeOptionFromSelect("produto", itemEditado.idProduto);
		excluirItemSelectAposEdicao = false;
	}
	itemEditado = null;
}

function inserirLinhaTabelaItens(item) {
	var idProduto = item.idProduto;
	var nomeProduto = item.nomeProduto;
	var quantidade = item.quantidade;
	var valorUnitario = item.valorUnitario;
	var alteracaoPrato = item.alteracaoPrato;
	var alteracaoMolho = item.alteracaoMolho;
	var valorTotalItem = item.valorTotal;
	
	var cell1 = "<td><input type='hidden' name='itemPedido.produto' value='" + idProduto + "'/>" +
				"<input type='hidden' name='itemPedido.nomeProduto' value='" + nomeProduto + "'/>" + nomeProduto + "</td>";
	var cell2 = "<td class='valorNumerico'><input type='hidden' name='itemPedido.quantidade' value='" + quantidade + "'/>" + quantidade + "</td>";
	var cell3 = "<td class='valorNumerico'><input type='hidden' name='itemPedido.valorUnitario' value='" + valorUnitario + "'/>" + valorUnitario + "</td>";
	var cell4 = "<td class='valorNumerico'><input type='hidden' name='itemPedido.valorTotalItem' value='" + valorTotalItem + "'/>" + valorTotalItem + "</td>";
	var cell5 = "<td><textarea class='hidden' name='itemPedido.alteracaoPrato' rows='3'>" + alteracaoPrato + "</textarea>" + alteracaoPrato +"</td>";
	var cell6 = "<td><textarea class='hidden' name='itemPedido.alteracaoMolho' rows='3'>" + alteracaoMolho + "</textarea>" + alteracaoMolho +"</td>";
	var cell7 = "<td><input class='edit' type='button' onclick='editItem(this)'><input class='delete' type='button' onclick='deleteItem(this)'></td>";
	 
	$("#itensPedido tbody").append("<tr class='separador'>" + cell1 + cell2 + cell3 + cell4 + cell5 + cell6 + cell7 + "</tr>");
}

function atualizarValorTotalPedido() {
	var totalPedido = 0;
	$("input[name='itemPedido.valorTotalItem']").each(
		function(index, element) {
			totalPedido = totalPedido + parseFloat(converterValorUsandoPontoSeparadorDecimal(this.value));
		}
	);
	$("#valorAPagar").val(converterValorUsandoVirgulaSeparadorDecimal(totalPedido.toFixed(2).toString()));
}

function getValorNumerico(idControle) {
	var texto = $("#" + idControle).val();
	if (texto != '') {
		return parseFloat(converterValorUsandoPontoSeparadorDecimal(texto));
	} else {
		return null;
	}
}

function atualizarValorTroco() {
	var troco = 0;
	var valorPedido = getValorNumerico('valorAPagar');
	var isValorPedidoPreenchido = (valorPedido != null);
	var trocoPara = getValorNumerico('trocoPara');
	var isTrocoParaPreenchido = (trocoPara != null);
	if (isValorPedidoPreenchido && isTrocoParaPreenchido) {
		troco = trocoPara - valorPedido;
	}
	$("#valorTroco").val(converterValorUsandoVirgulaSeparadorDecimal(troco.toFixed(2).toString()));
}

function totalizarPedido() {
	atualizarValorTotalPedido();
	atualizarValorTroco();
}

function adicionarCliente() {
	window.open('/BeFit/cliente/create','_blank');
}

function limparFormularioAdicaoItens() {
	$('#produto').val('').trigger("chosen:updated");;
	$('#quantidade').val('');
    $('#valorUnitario').val('');
    $('#valorTotalItem').val('');
    $('#alteracaoPrato').val('');
    $('#alteracaoMolho').val('');
}

function isItemPreenchido(item) {
	var isProdutoPreenchido = (item.idProduto != null);
	var isQuantidadePreenchida = (item.quantidade != "");
	var isValorUnitarioPreenchido = (item.valorUnitario != "");
	
	return isProdutoPreenchido && isQuantidadePreenchida && isValorUnitarioPreenchido;
}

function converterValorUsandoPontoSeparadorDecimal(valor) {
    var valorConvertido = valor;
	valorConvertido = valorConvertido.replace(/\./g, '');
    valorConvertido = valorConvertido.replace(/\,/g, '.');
    return valorConvertido;
}

function converterValorUsandoVirgulaSeparadorDecimal(valor) {
	var valorConvertido = valor;
	valorConvertido = valorConvertido.replace(/\,/g, '');
    valorConvertido = valorConvertido.replace(/\./g, ',');
    return valorConvertido;
}

function editItem(buttonClicked) {
	var rowToEdit = buttonClicked.closest("tr");
	loadItem(rowToEdit);
	deleteItem(buttonClicked);
}

function deleteItem(buttonClicked) {
	var rowToDelete = buttonClicked.closest("tr");
	rowToDelete.remove();
}

function loadItem(selectedRow) {
	itemEditado = {idProduto: $("input[name='itemPedido.produto']", selectedRow).val(),
				   nomeProduto: $("input[name='itemPedido.nomeProduto']", selectedRow).val(),
				   quantidade: $("input[name='itemPedido.quantidade']", selectedRow).val(),
				   valorUnitario: $("input[name='itemPedido.valorUnitario']", selectedRow).val(),
				   alteracaoPrato: $("textarea[name='itemPedido.alteracaoPrato']", selectedRow).val(),
				   alteracaoMolho: $("textarea[name='itemPedido.alteracaoMolho']", selectedRow).val(),
				   valorTotal: $("input[name='itemPedido.valorTotalItem']", selectedRow).val()
	};
	
	var selectProdutos = $('#produto');
	selectProdutos.val(itemEditado.idProduto);
	//---Se o item não consta no select, inclua-o
	if (selectProdutos.val() == null) {
		addOptionToSelect(selectProdutos, itemEditado.idProduto, itemEditado.nomeProduto);
		selectProdutos.val(itemEditado.idProduto);
		excluirItemSelectAposEdicao = true;
	}
	selectProdutos.trigger("chosen:updated");
	$('#quantidade').val(itemEditado.quantidade);
	$('#valorUnitario').val(itemEditado.valorUnitario);
	$("#alteracaoPrato").val(itemEditado.alteracaoPrato);
	$("#alteracaoMolho").val(itemEditado.alteracaoMolho);
	$('#valorTotalItem').val(itemEditado.valorTotal);
}

function cancelarEdicao() {
	if (itemEditado != null) {
		inserirLinhaTabelaItens(itemEditado);
		itemEditado = null;
		if (excluirItemSelectAposEdicao) {
			removeOptionFromSelect("produto", itemEditado.idProduto);
			excluirItemSelectAposEdicao = false;
		}
	}
	limparFormularioAdicaoItens();
	totalizarPedido();
}

function recarregarListaProdutos(somenteItensDoDia) {
	var url = '/BeFit/pedido/recarregarListaProdutos';
	if (somenteItensDoDia) {
		var dataEntrega = $("#dataEntrega").val();
		if (dataEntrega == "") {
			alert('Informe uma data de entrega antes de restringir os produtos disponíveis no dia!');
			return
		}
		url = url + '?data=' + dataEntrega;
	}
	jQuery.ajax({
		  url: url,
		  async: false,
		  success: function(listaProdutos) {
			  var selectOptions = JSON.parse(listaProdutos);
			  var selectProdutos = $("#produto");
			  selectProdutos.empty();
			  addOptionToSelect(selectProdutos, "", "");
			  $.each(selectOptions, function(i, produto) {
				  addOptionToSelect(selectProdutos, produto.codigo, produto.nome);
			  });
			  $("#produto").trigger("chosen:updated");
		  }
	});
}

function removeOptionFromSelect(id, value) {
	$("#" + id + " option[value='" + value + "']").remove();
}

function addOptionToSelect(select, value, text) {
	select.append($("<option></option>").attr("value", value).text(text));
}