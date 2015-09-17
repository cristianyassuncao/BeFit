class Bairro implements Comparable {
    
    String nome
    Cidade cidade

    static constraints = {
    }
    
    static mapping = {
        table 'tb_bairro'
        version false
        id column: 'SEQ_BAIRRO', generator: 'increment'
        nome column: 'NOM_BAIRRO'
        cidade column: 'SEQ_CIDADE'
    }

	@Override
	public int compareTo(Object obj) {
		def bairro = (Bairro) obj
		def resultado = getNome().compareTo(bairro?.nome)
		if (resultado == 0) {
			resultado = getId().compareTo(bairro?.id)
		}
		return resultado;
	}
    
}
