package eu.unicorneducation.service;

import java.io.InputStream;

public interface PdfService {

	public InputStream generatePdf(String id);
}
