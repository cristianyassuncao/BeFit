<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Relatório Analítico de Vendas no Período</title>
	</head>
<body>
	<div class="nav" role="navigation">
		<ul>
			<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
		</ul>
	</div>
	<div class="body">
		<div class="conteudo">
			<g:form id="parametros" name="parametros" controller="relatorio" action="gerarCSVRelatorioAnaliticoPedidos" update="[sucess:'message',failure:'error']">
                <div class="detalhes">
                    <table class="parametros">
                        <tr align='left'>
                            <td valign='middle'>
             	                <label for="datas">Pedidos efetuados entre:</label>
	                			<input type="text" id="dataInicial" name="dataInicial" class="data"/>
	                			e
	                			<input type="text" id="dataFinal" name="dataFinal" class="data"/>
            				</td>
            			</tr>
            		</table>
            	</div>
            	<fieldset class="buttons">
                    <input class="procurar" type="submit" value="Download" />
                    <g:actionSubmit class="clear" action="clear" value="Limpar"/>
                </fieldset>
            </g:form>				
		</div>
	</div>
</body>
</html>