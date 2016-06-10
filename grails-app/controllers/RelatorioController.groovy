import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.text.SimpleDateFormat
import java.util.Map;

import javax.servlet.http.HttpSession;

import liquibase.util.csv.opencsv.CSVWriter
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRXlsExporter

import org.apache.commons.lang.CharSet;
import org.codehaus.groovy.grails.plugins.jasper.*;

import au.com.bytecode.opencsv.*

class RelatorioController {
	JasperService jasperService
	
	def index = {
		def testModel = this.getProperties().containsKey('chainModel') ? chainModel : null
		params.SUBREPORT_DIR = "${servletContext.getRealPath('/reports')}/"
		JasperReportDef report = jasperService.buildReportDefinition(params, request.getLocale(), testModel)
		addJasperPrinterToSession(request.getSession(), report.jasperPrinter)		
		generateResponse(report)
	}

	/**
	 * Generate a html response.
	 */
	def generateResponse = {reportDef ->
		if (!reportDef.fileFormat.inline && !reportDef.parameters._inline) {
			response.setHeader("Content-disposition", "attachment; filename=" + (reportDef.parameters._name ?: reportDef.name) + "." + reportDef.fileFormat.extension);
		}
		response.contentType = reportDef.fileFormat.mimeTyp
		response.characterEncoding = "UTF-8"
		response.outputStream << reportDef.contentStream.toByteArray()
	}

	private def addJasperPrinterToSession(HttpSession session, JasperPrint jasperPrinter) {
		session.setAttribute(
				net.sf.jasperreports.j2ee.servlets.ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE,
				jasperPrinter)
	}
	
	def exibirParametrosRelatorioAnaliticoPedidosEntregues = {
		render(view:"/relatorio/analiticoPedidosEntreguesNoPeriodo")
	}
	
	def gerarCSVRelatorioAnaliticoPedidosEntregues = {
		def dateFormat = new SimpleDateFormat("dd/MM/yyyy")
		def pedidosSelecionados = Pedido.findAll("FROM Pedido WHERE dataEntrega BETWEEN :dataInicial AND :dataFinal", [dataInicial: dateFormat.parse(params?.dataInicial), dataFinal: dateFormat.parse(params?.dataFinal)])
		char separator = ';'

		ByteArrayOutputStream output = new ByteArrayOutputStream()
		CSVWriter wr = new CSVWriter(new OutputStreamWriter(output, Charset.forName("UTF-8").newEncoder()), separator);
		wr.writeNext((String[]) ['idPedido', 'idCliente', 'nomeCliente', 'dataEntrega', 'valorAPagar', 'valorPago', 'idEntregador', 'nomeEntregador', 'formaPagamento', 'idProduto', 'nomeProduto', 'quantidade', 'valorUnitario', 'valorItem'])
		pedidosSelecionados.each {p ->
			p?.itens?.each {i ->
				wr.writeNext((String[]) [p.id, 
										 p?.cliente?.id,
										 p?.cliente?.nome,
										 dateFormat.format(p?.dataEntrega),
										 p?.valorAPagar,
										 p?.valorPago,
										 p?.entregador?.id,
										 p?.entregador?.nome,
										 p?.formaPagamento?.nome,
										 i?.produto?.id,
										 i?.produto?.nome,
										 i?.quantidade,
										 i?.valorUnitario,
										 i?.valorItem])
			}
		}
		wr.close()
		byte[] bytes = output.toByteArray()
		response.setContentLength(bytes.length)
		response.setContentType("text/csv");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Disposition", String.format("attachment; filename=relatorioAnaliticoPedidos.csv"));
		response.outputStream << bytes
	}
	
}