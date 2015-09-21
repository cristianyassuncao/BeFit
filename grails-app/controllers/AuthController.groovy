import org.apache.jasper.security.SecurityUtil;
import org.apache.shiro.authc.*
import org.apache.shiro.SecurityUtils

class AuthController {
    
    def index = { redirect(action: 'login', params: params) }

    def login = {
        return [username: params.username, rememberMe: (params.rememberMe != null), targetUri: params.targetUri]
    }

    def signIn = {
        def authToken = new UsernamePasswordToken(params.username, params.password)

        if (params.rememberMe) {
            authToken.rememberMe = true
        }

        try {
			SecurityUtils.subject.login(authToken)
			def principal = SecurityUtils.subject?.principal
	        def targetUri = params.targetUri ?: "/"
            log.info "Redirecting to '${targetUri}'."
            redirect(uri: targetUri)
	    } catch (AuthenticationException ex) {
            log.info "Authentication failure for user '${params.username}'."
            flash.message = message(code: "login.failed")

			def m = [ username: params.username ]
            
			if (params.rememberMe) {
                m['rememberMe'] = true
            }

            if (params.targetUri) {
                m['targetUri'] = params.targetUri
            }

            redirect(action: 'login', params: m)
        }
    }

    def signOut = {
        SecurityUtils.subject?.logout()
    }

    def unauthorized = {
        render 'Você não tem permissão de acessar essa página.'
    }
		
}