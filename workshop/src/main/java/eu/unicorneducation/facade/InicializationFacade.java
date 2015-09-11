package eu.unicorneducation.facade;

import org.springframework.web.multipart.MultipartFile;

public interface InicializationFacade {

	public void inicializateBranches(MultipartFile file);
	
	public void inicializateEmployees(MultipartFile file);
	
}
