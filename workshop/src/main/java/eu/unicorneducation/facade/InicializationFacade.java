package eu.unicorneducation.facade;

import org.springframework.web.multipart.MultipartFile;

public interface InicializationFacade {

	public void inicializate(MultipartFile branchesFile, MultipartFile employeesFile);
}
