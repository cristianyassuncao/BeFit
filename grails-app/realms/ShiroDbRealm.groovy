import org.apache.shiro.authc.*
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.SecureRandomNumberGenerator

import java.sql.*
import java.util.prefs.Base64;

import org.apache.shiro.util.ByteSource
import org.apache.shiro.crypto.hash.Sha512Hash

class ShiroDbRealm {

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
			//createUser(authToken)
			accountResultSet = accountStmt.executeQuery("select txt_passwordHash password, txt_salt salt from tb_usuario where txt_username = '${authToken.getUsername()}'")
			if (! accountResultSet.next()) {
				throw new org.apache.shiro.authc.AuthenticationException()
			}
			isSenhaValida = passwordsMatch(accountResultSet.getString("password"), accountResultSet.getString("salt"), new String(authToken.getPassword()))
			accountResultSet.close()
			if (!isSenhaValida) {
				throw new org.apache.shiro.authc.AuthenticationException()
			}
			return buildAccount(authToken, conexao)
        } catch (Exception e) {
            log.error "Erro: "  e.getMessage()
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
		SimpleAccount account
		Statement accountStmt
		ResultSet accountResultSet
		UsuarioLogado principal

		accountStmt = conexao.createStatement()
		try {
			accountResultSet = accountStmt.executeQuery("select seq_usuario id, txt_username username from tb_usuario where txt_username = '${token.getUsername()}'")
			if (!accountResultSet.next()) {
				throw new org.apache.shiro.authc.AuthenticationException()
			}
			principal = new UsuarioLogado(accountResultSet.getLong("id"), accountResultSet.getString("username"))
			accountResultSet.close()
			account = new SimpleAccount(principal, null, "shiroDbRealm")
			accountResultSet = accountStmt.executeQuery("select nom_papel from tb_usuario u, tb_usuario_papel up, tb_papel p where up.seq_papel = p.seq_papel and up.seq_usuario = u.seq_usuario and u.txt_username = '${token.getUsername()}'")
			while (accountResultSet.next()) {
				principal.adicionarRole(accountResultSet.getString(1))
			}
			accountResultSet.close()
			return account
		} catch (Exception e) {
			log.error e.getMessage()
		} finally {
			accountStmt.close()
		}
		return account
	}
	
	public boolean passwordsMatch(String dbStoredHashedPassword, String dbStoredSalt, String plainPassword) {
		ByteSource salt = ByteSource.Util.bytes(Hex.decode(dbStoredSalt));
		String hashedPassword = hashAndSaltPassword(plainPassword, salt);
		return hashedPassword.equals(dbStoredHashedPassword);
	}
	
	private String hashAndSaltPassword(String plainPassword, Object salt) {
		final int SHIRO_CREDENTIAL_HASH_INTERATION = 1024
		return new Sha512Hash(plainPassword, salt, SHIRO_CREDENTIAL_HASH_INTERATION).toHex()
	}
	
	private ByteSource getSalt() {
		return new SecureRandomNumberGenerator().nextBytes();
	}
	
	public void createUser(UsernamePasswordToken token) {
		Object salt = getSalt();
		String plainPassword = new String(token.getPassword())
		String hashedPassword = hashAndSaltPassword(plainPassword, salt)
		
		Usuario usuario = new Usuario()
		usuario.username = token.getUsername()
		usuario.hashedPassword = hashedPassword
		usuario.salt = salt.toHex()
		usuario.save(flush: true);
	}

}