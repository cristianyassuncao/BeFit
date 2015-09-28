class UsuarioLogado {
	
    Long id
	String username
    HashSet roles

    public UsuarioLogado(Long id, String username) {
        this.username = username
        roles = new HashSet()
    }

    public String getUsername() {
        return username;
    }
    
    public void adicionarRole(String role) {
        roles.add(role);
    }

    public boolean hasRole(String role) {
        return roles.contains(role)
    }

}