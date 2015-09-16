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

		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(Arrays.asList(employeeDao.read(id)));
		
		Map parameters = new HashMap();
		InputStream in = null;
		try {
			File temp = File.createTempFile("tempPdf", ".pdf");
			JasperPrint print = JasperFillManager.fillReport(new FileInputStream("pdfSchema.jasper"),
					parameters, beanColDataSource);
			
			JasperExportManager.exportReportToPdfFile(print, temp.getAbsolutePath());
				in = new FileInputStream(temp);
			
		} catch (JRException | IOException e) {
			//TODO logger
			e.printStackTrace();
		}

		return in;
	}

}
