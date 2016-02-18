
public class Lancamento {
	
	Operacao operacao
	FormaPagamento formaPagamento
	Date data
	BigDecimal valor
	Usuario operador
	
	static belongsTo = [caixaDiario: CaixaDiario]
	
	static mapping = {
		table 'tb_lancamento'
		version false
		id column: 'SEQ_LANCAMENTO', generator: 'increment'
		data column: 'DTH_LANCAMENTO'
		valor column: 'VAL_LANCAMENTO'
		operacao column: 'SEQ_OPERACAO'
		formaPagamento column: 'SEQ_FORMA_PAGAMENTO'
		operador column: 'SEQ_OPERADOR'
		caixaDiario column: 'SEQ_CAIXA_DIARIO'
	}
	
}