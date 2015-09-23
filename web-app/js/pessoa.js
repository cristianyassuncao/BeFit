    
    function addEndereco(idPessoa) {
        modalForm = $("<div></div>");
        titulo = 'Incluir endereço';
        modalForm.load('/befit/pessoa/loadEndereco?idPessoa=' + idPessoa, 
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
                                        url     : '/befit/pessoa/updateEndereco',
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
        modalForm.load('/befit/pessoa/loadEndereco?idEndereco=' + idEndereco, 
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
                                        url     : '/befit/pessoa/updateEndereco',
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
        modalForm.load('/befit/pessoa/loadEndereco?idEndereco=' + idEndereco, 
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
                                        url     : '/befit/pessoa/deleteEndereco',
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

function addTelefone(idPessoa) {
        modalForm = $("<div></div>");
        titulo = 'Incluir telefone';
        modalForm.load('/befit/pessoa/loadTelefone?idPessoa=' + idPessoa, 
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
                                        url     : '/befit/pessoa/updateTelefone',
                                        type    : 'POST',
                                        data    : $("#formTelefone").serializeArray(),
                                        context: $(this),
                                        success: function(e){
                                            $("#listaTelefones").replaceWith(e);
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

    function editTelefone(idTelefone) {
        modalForm = $("<div></div>");
        titulo = 'Alterar telefone';
        modalForm.load('/befit/pessoa/loadTelefone?idTelefone=' + idTelefone, 
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
                                        url     : '/befit/pessoa/updateTelefone',
                                        type    : 'POST',
                                        data    : $("#formTelefone").serializeArray(),
                                        context: $(this),
                                        success: function(e){
                                            $("#listaTelefones").replaceWith(e);
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

function deleteTelefone(idTelefone) {
        modalForm = $("<div></div>");
        titulo = 'Excluir telefone';
        modalForm.load('/befit/pessoa/loadTelefone?idTelefone=' + idTelefone, 
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
                                        url     : '/befit/pessoa/deleteTelefone',
                                        type    : 'POST',
                                        data    : $("#formTelefone").serializeArray(),
                                        context: $(this),
                                        success: function(e){
                                            $("#listaTelefones").replaceWith(e);
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