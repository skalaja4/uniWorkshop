package eu.unicorneducation.service;

import org.springframework.web.multipart.MultipartFile;

public interface InicializationService {

	public void inicializate(MultipartFile branchesFile, MultipartFile employeesFile);
	
	public void addEmployees(MultipartFile branchesFile);
}
