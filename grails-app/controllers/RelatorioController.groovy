import java.util.Map;

import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.*;
import org.codehaus.groovy.grails.plugins.jasper.*;

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
	
}