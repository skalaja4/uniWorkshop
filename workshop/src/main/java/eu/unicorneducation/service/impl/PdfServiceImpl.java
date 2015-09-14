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

		String sourceFileName = "src/main/resources/pdfSchema.jasper";
//		String sourceFileName = "C:/Users/Student/uniWorkshop/workshop/src/main/resources/pdfSchema.jasper";
		
		String printFileName = null;
//		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(Arrays.asList(employeeDao.read(id)));
		JRBeanCollectionDataSource beanColDataSource =
		         new JRBeanCollectionDataSource(DataForJasperFactory.getList());
		
		Map parameters = new HashMap();
		InputStream in = null;
		try {
			File temp = File.createTempFile("tempPdf", ".pdf");
			System.out.println("tempFile:" + temp.getAbsolutePath());
			printFileName = JasperFillManager.fillReportToFile(sourceFileName,
					parameters, beanColDataSource);
			System.out.println("printFileName:" + printFileName);
			if (printFileName != null) {
				/**
				 * 1- export to PDF
				 */
				JasperExportManager.exportReportToPdfFile(printFileName, temp.getAbsolutePath());
				in = new FileInputStream(temp);
			}
		} catch (JRException | IOException e) {
			//TODO logger
			e.printStackTrace();
		}

		return in;
	}

}