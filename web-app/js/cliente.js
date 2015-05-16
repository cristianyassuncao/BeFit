    
    function addEndereco(idCliente) {
        modalForm = $("<div></div>");
        titulo = 'Incluir endereço';
        modalForm.load('/BeFit/cliente/loadEndereco?idCliente=' + idCliente, 
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
		        width: 900,
		        title: titulo,
		        show: "blind",
		        hide: "explode",
                        dialogClass: "system-dialog",
		        buttons: [
                            {
                                text: "Confirmar",
                                click: function() {
                                    $.ajax({
                                        url     : '/BeFit/cliente/updateEndereco',
                                        type    : 'POST',
                                        data    : $("#formEndereco").serializeArray(),
                                        context: $(this),
                                        success: function(e){
                                            $("#listaEnderecos").replaceWith(e);
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

    function editEndereco(idEndereco) {
        modalForm = $("<div></div>");
        titulo = 'Alterar endereço';
        modalForm.load('/BeFit/cliente/loadEndereco?idEndereco=' + idEndereco, 
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
		        width: 900,
		        title: titulo,
		        show: "blind",
		        hide: "explode",
                        dialogClass: "system-dialog",
		        buttons: [
                            {
                                text: "Confirmar",
                                click: function() {
                                    $.ajax({
                                        url     : '/BeFit/cliente/updateEndereco',
                                        type    : 'POST',
                                        data    : $("#formEndereco").serializeArray(),
                                        context: $(this),
                                        success: function(e){
                                            $("#listaEnderecos").replaceWith(e);
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

function deleteEndereco(idEndereco) {
        modalForm = $("<div></div>");
        titulo = 'Excluir endereço';
        modalForm.load('/BeFit/cliente/loadEndereco?idEndereco=' + idEndereco, 
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
		        width: 900,
		        title: titulo,
		        show: "blind",
		        hide: "explode",
                        dialogClass: "system-dialog",
		        buttons: [
                            {
                                text: "Confirmar",
                                click: function() {
                                    $.ajax({
                                        url     : '/BeFit/cliente/deleteEndereco',
                                        type    : 'POST',
                                        data    : $("#formEndereco").serializeArray(),
                                        context: $(this),
                                        success: function(e){
                                            $("#listaEnderecos").replaceWith(e);
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