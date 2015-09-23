/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function loadFile(event) {
    $("#imagemProduto").attr("src", URL.createObjectURL(event.target.files[0]));
};

function addPreco(idProduto) {
        modalForm = $("<div></div>");
        titulo = 'Incluir Preço';
        modalForm.load('/befit/produto/loadPreco?idProduto=' + idProduto, 
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
		        height: 237,
		        width: 452,
		        title: titulo,
		        show: "blind",
		        hide: "explode",
                        dialogClass: "system-dialog",
		        buttons: [
                            {
                                text: "Confirmar",
                                click: function() {
                                    $.ajax({
                                        url     : '/befit/produto/updatePreco',
                                        type    : 'POST',
                                        data    : $("#formPreco").serializeArray(),
                                        context: $(this),
                                        success: function(e){
                                            $("#historicoPrecos").replaceWith(e);
                                            $(this).dialog("close");
                                            $(this).dialog("destroy");
                                        },
                                        error: function(e){
                                            modalForm.html(e.responseText);
                                        }
                                     });
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
    };

    function editPreco(idPreco) {
        modalForm = $("<div></div>");
        titulo = 'Alterar preço';
        modalForm.load('/befit/produto/loadPreco?idPreco=' + idPreco, 
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
		        height: 237,
		        width: 452,
		        title: titulo,
		        show: "blind",
		        hide: "explode",
                        dialogClass: "system-dialog",
		        buttons: [
                            {
                                text: "Confirmar",
                                click: function() {
                                    $.ajax({
                                        url     : '/befit/produto/updatePreco',
                                        type    : 'POST',
                                        data    : $("#formPreco").serializeArray(),
                                        context: $(this),
                                        success: function(e){
                                            $("#historicoPrecos").replaceWith(e);
                                            $(this).dialog("close");
                                            $(this).dialog("destroy");
                                        },
                                        error: function(e){
                                            modalForm.html(e.responseText);
                                        }
                                     });
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
};

function deletePreco(idPreco) {
        modalForm = $("<div></div>");
        titulo = 'Excluir preço';
        modalForm.load('/befit/produto/loadPreco?idPreco=' + idPreco, 
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
		        height: 237,
		        width: 452,
		        title: titulo,
		        show: "blind",
		        hide: "explode",
                        dialogClass: "system-dialog",
		        buttons: [
                            {
                                text: "Confirmar",
                                click: function() {
                                    $.ajax({
                                        url     : '/befit/produto/deletePreco',
                                        type    : 'POST',
                                        data    : $("#formPreco").serializeArray(),
                                        context: $(this),
                                        success: function(e){
                                            $("#historicoPrecos").replaceWith(e);
                                            $(this).dialog("close");
                                            $(this).dialog("destroy");
                                        },
                                        error: function(e){
                                            modalForm.html(e.responseText);
                                        }
                                     });
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
};