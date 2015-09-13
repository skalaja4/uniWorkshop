package eu.unicorneducation.facade;

import org.springframework.web.multipart.MultipartFile;

public interface ImportFacade {

	public void importEmployees(MultipartFile file);
	
}
