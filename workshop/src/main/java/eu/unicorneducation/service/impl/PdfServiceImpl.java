package eu.unicorneducation.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.unicorneducation.dao.EmployeeDAO;
import eu.unicorneducation.service.PdfService;

@Component
public class PdfServiceImpl implements PdfService {

	@Autowired
	EmployeeDAO employeeDao;

	@Override
	public InputStream generatePdf(String id) {

//		String sourceFileName = "pdfSchema.jasper";
//		String sourceFileName = "C:/Users/Student/uniWorkshop/workshop/src/main/resources/pdfSchema.jasper";
		
//		String printFileName = null;
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(Arrays.asList(employeeDao.read(id)));
//		JRBeanCollectionDataSource beanColDataSource =
//		         new JRBeanCollectionDataSource(DataForJasperFactory.getList());
		
		Map parameters = new HashMap();
		InputStream in = null;
		try {
			File temp = File.createTempFile("tempPdf", ".pdf");
//			printFileName = JasperFillManager.fillReportToFile(sourceFileName,
//					parameters, beanColDataSource);
			JasperPrint print = JasperFillManager.fillReport(new FileInputStream("pdfSchema.jasper"),
					parameters, beanColDataSource);
			
				/**
				 * 1- export to PDF
				 */
			JasperExportManager.exportReportToPdfFile(print, temp.getAbsolutePath());
//				JasperExportManager.exportReportToPdfFile(printFileName, temp.getAbsolutePath());
				in = new FileInputStream(temp);
			
		} catch (JRException | IOException e) {
			//TODO logger
			e.printStackTrace();
		}

		return in;
	}

}
