
public class CaixaDiario {
	
	Date dataHoraAbertura
	Date dataHoraFechamento
	
	static hasMany = [lancamentos: Lancamento]
	
	static mapping = {
		table 'tb_caixa_diario'
		version false
		id column: 'SEQ_CAIXA_DIARIO', generator: 'increment'
		dataHoraAbertura column: 'DTH_ABERTURA'
		dataHoraFechamento column: 'DTH_FECHAMENTO'
		lancamentos joinTable: false, column: 'SEQ_CAIXA_DIARIO'
	}

}
