<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
  		<asset:stylesheet src="application.css"/>
		<asset:javascript src="application.js"/>
                <asset:javascript src="main.js"/>
                <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'menu.css')}" />
                <link rel="stylesheet" href="${createLinkTo(dir:'js/jquery-ui-1.11.3.custom',file:'jquery-ui.css')}"/>
                <g:javascript src="jquery-2.1.3.js"/>
                <g:javascript src="jquery-ui-1.11.3.custom/jquery-ui.js"/>
                <g:javascript src="jquery.maskedinput.js"/>
                <g:layoutHead/>
	</head>
	<body>
            <div id="systemLogo" role="banner">
                <a href="/BeFit"><asset:image src="BeFitLogo.png" alt="BeFit"/></a>
            </div>
            <div class="menu">
                <ul id="menuBar">
                    <li class="submenu"><a href="#">Cadastros Básicos</a>
                        <ul>
                            <li>
                                <a href="${createLinkTo(dir:'bairro')}">Bairros</a>
                            </li>
                            <li>
                                <a href="${createLinkTo(dir:'categoriaProduto')}">Categorias de Produtos</a>
                            </li>
                            <li>
                                <a href="${createLinkTo(dir:'produto')}">Produtos</a>
                            </li>
                            <li>
                                <a href="${createLinkTo(dir:'itemDia')}">Itens do Dia</a>
                            </li>
                        </ul>
                    </li>
                    <li class="submenu">
                        <a href="${createLinkTo(dir:'cliente')}">Clientes</a>
                    </li>
                    <li class="submenu">
                        <a href="${createLinkTo(dir:'pedido')}">Pedidos</a>
                    </li>
                </ul>
            </div>    
            <g:layoutBody/>
            <div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
	</body>
</html>