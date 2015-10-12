import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Util {
	
	final static SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
	final static DecimalFormat formatoDecimal = new DecimalFormat("###,##0.00", new DecimalFormatSymbols(new Locale ("pt", "BR")));
	
	public static Date getDataAtual() throws ParseException {
		return formatoData.parse(formatoData.format(new Date()));
	}
	
	public static Date parse(String data) throws ParseException {
		return formatoData.parse(data);
	}
	
	public static String formatCurrency(BigDecimal value) {
		return formatoDecimal.format(value);
	}

}
