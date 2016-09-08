
class PrecoPacote extends Preco {
	
	Pacote pacote;
	
 	static mapping = {
		table 'tb_preco_pacote'
		version false
		columns {
		  id column: 'SEQ_PRECO'
		  pacote column: 'SEQ_PACOTE'
		}
	}

}