package eu.unicorneducation.facade.impl;

import java.io.IOException;
import java.text.ParseException;

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
	public void importEmployees(MultipartFile file) throws IOException, ParseException {
		initService.addEmployees(file);
	}

}
