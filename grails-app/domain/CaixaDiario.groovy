
public class CaixaDiario {
	
	Date abertura
	Date fechamento
	Usuario abertoPor
	
	static hasMany = [lancamentos: Lancamento]
	
	static mapping = {
		table 'tb_caixa_diario'
		version false
		id column: 'SEQ_CAIXA_DIARIO', generator: 'increment'
		abertura column: 'DTH_ABERTURA'
		fechamento column: 'DTH_FECHAMENTO'
		abertoPor column: 'SEQ_USUARIO_RESPONSAVEL_ABERTURA'
		lancamentos joinTable: false, column: 'SEQ_CAIXA_DIARIO'
	}

}
