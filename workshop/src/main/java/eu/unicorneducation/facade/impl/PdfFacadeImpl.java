package eu.unicorneducation.facade.impl;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.unicorneducation.facade.PdfFacade;
import eu.unicorneducation.service.PdfService;

@Component
public class PdfFacadeImpl implements PdfFacade {

	@Autowired
	PdfService pdfService;
	
	@Override
	public InputStream generatePdf(String id) {
		return pdfService.generatePdf(id);
	}

}
