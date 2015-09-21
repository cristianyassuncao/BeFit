class UsuarioLogado {
	
    String login
    HashSet roles

    public UsuarioLogado(String login) {
        this.login = login
		roles = new HashSet()
    }

    public void adicionarRole(String role) {
        roles.add(role);
    }

    public boolean hasRole(String role) {
        return roles.contains(role)
    }

}