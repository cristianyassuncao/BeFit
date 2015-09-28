class Usuario {
	
	String username;
	String hashedPassword;
	String salt;
	
	static mapping = {
		table 'tb_usuario'
		version false
		id column: 'SEQ_USUARIO', generator: 'increment'
		username column: 'TXT_USERNAME'
		hashedPassword column: 'TXT_PASSWORDHASH'
		salt column: 'TXT_SALT'
	}
	
}