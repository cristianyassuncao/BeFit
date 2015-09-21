import java.sql.*
import org.apache.shiro.authc.*

class beFitRealm {

	static authTokenClass = org.apache.shiro.authc.UsernamePasswordToken
	
	def dataSource

    def authenticate(authToken) {
        Connection conexao
        PreparedStatement dbFunction
        boolean isSenhaValida
		Statement accountStmt
		ResultSet accountResultSet
		
        conexao = dataSource.getConnection()
		accountStmt = conexao.createStatement()
		try {
			accountResultSet = accountStmt.executeQuery("select txt_password password from tb_usuario where txt_login = '${authToken.getUsername()}'")
			if (! accountResultSet.next()) {
				throw new org.apache.shiro.authc.AuthenticationException()
			}
			isSenhaValida = accountResultSet.getString("password").equals(new String(authToken.getPassword()))
            accountResultSet.close()
			if (!isSenhaValida) {
				throw new org.apache.shiro.authc.AuthenticationException()
			}
			return buildAccount(authToken, conexao)
        } catch (Exception e) {
            log.error "Erro: " + e.getMessage()
        } finally {
            conexao.close()
        }
    }

    def hasRole(principal, roleName) {
        return principal.hasRole(roleName)
    }

    def isPermitted(principal, permission) {
        return true
    }
	
	private Account buildAccount(UsernamePasswordToken token, Connection conexao) throws AuthenticationException {
		UsuarioLogado principal = new UsuarioLogado(token.getUsername())
		principal.adicionarRole("administrador")
		SimpleAccount account = new SimpleAccount(principal, null, "beFitRealm")
		return account
	}

}