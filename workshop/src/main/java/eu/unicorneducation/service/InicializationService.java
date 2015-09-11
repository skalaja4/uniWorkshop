package eu.unicorneducation.service;

import org.springframework.web.multipart.MultipartFile;

public interface InicializationService {

	public void inicializateBranches(MultipartFile file);
	
	public void inicializateEmployees(MultipartFile file);
	
}
