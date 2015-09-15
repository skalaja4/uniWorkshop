package workshop;

import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.junit.Test;

import eu.unicorneducation.service.impl.DataForJasperFactory;

public class PdfExportTest {

	@Test
	public void exportTest() {
		String sourceFileName = "src/main/resources/pdfSchema.jasper";
	      String printFileName = null;
	      JRBeanCollectionDataSource beanColDataSource =
	         new JRBeanCollectionDataSource(DataForJasperFactory.getList());

	      Map parameters = new HashMap();
	      try {
	         printFileName = JasperFillManager.fillReportToFile(sourceFileName,
	            parameters, beanColDataSource);
	         if (printFileName != null) {
	            /**
	             * 1- export to PDF
	             */
	            JasperExportManager.exportReportToPdfFile(printFileName,
	                  "C://sample_report.pdf");
	         }
	      } catch (JRException e) {
	         e.printStackTrace();
	      }
	}
	
}
