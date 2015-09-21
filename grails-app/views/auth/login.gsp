<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="layout" content="main"/>
  <title>Login</title>
  <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'login.css')}">
  <g:javascript library="prototype"/>
  <g:javascript library="util"/>
</head>
<body>
  <g:if test="${flash.message}">
    <div class="message">${flash.message}</div>
  </g:if>
  <shiro:isNotLoggedIn>
      <g:form action="signIn">
        <input type="hidden" name="targetUri" value="${targetUri}" />
        <table>
          <tbody>
            <tr>
              	<td>Login:</td>
              	<td><input type="text" name="username" id="username" value="${username}" onblur="${remoteFunction(controller:'auth',action:'getUnidadesLotacao',params:'\'login=\' + escape(this.value) + \'&idSelect=\' + \'codigoUnidadeLotacao\' + \'&nameSelect=\' + \'codigoUnidadeLotacao\'',onSuccess:'exibirSelect(\'spanSelectUnidadeLotacao\', e)')}"/></td>
            </tr>
            <tr>
            	<td>Senha:</td>
              	<td><input type="password" name="password" id="password" value=""/></td>
            </tr>
            <tr>
              <td/>
              <td><input type="submit" value="Acessar"/></td>
            </tr>
          </tbody>
        </table>
      </g:form>
  </shiro:isNotLoggedIn>
</body>
</html>