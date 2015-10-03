<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="layout" content="main" />
  <title>Login</title>
  <style type="text/css">
  	#login {
  		display: none;
  	}
  </style>
</head>
<body>
  <g:if test="${flash.message}">
    <div class="message">${flash.message}</div>
  </g:if>
  <g:form action="signIn">
    <input type="hidden" name="targetUri" value="${targetUri}"/>
    <table>
      <tbody>
        <tr>
          <td>Digite seu email:</td>
          <td><input type="text" name="username" value="${username}"/></td>
        </tr>
        <tr>
          <td>Senha:</td>
          <td><input type="password" name="password" value=""/></td>
        </tr>
        <tr>
          <td/>
          <td><input type="submit" value="Entrar"/></td>
        </tr>
      </tbody>
    </table>
  </g:form>
</body>
</html>