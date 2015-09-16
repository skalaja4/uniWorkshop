package eu.unicorneducation.facade;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.web.multipart.MultipartFile;

public interface ImportFacade {

	public void importEmployees(MultipartFile file) throws IOException, ParseException;
	
}
