package eu.unicorneducation.facade;

import java.io.InputStream;

public interface PdfFacade {

	public InputStream generatePdf(String id);
}
