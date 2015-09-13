package eu.unicorneducation.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import eu.unicorneducation.facade.ImportFacade;
import eu.unicorneducation.service.InicializationService;

@Component
public class ImportFacadeImpl implements ImportFacade {

	@Autowired
	InicializationService initService;
	
	@Override
	public void importEmployees(MultipartFile file) {
		initService.inicializateEmployees(file);
	}

}
