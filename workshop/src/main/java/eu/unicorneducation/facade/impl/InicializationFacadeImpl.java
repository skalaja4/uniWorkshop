package eu.unicorneducation.facade.impl;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import eu.unicorneducation.facade.InicializationFacade;
import eu.unicorneducation.service.InicializationService;

@Component
public class InicializationFacadeImpl implements InicializationFacade {

	@Autowired
	InicializationService service;
	
	public void inicializate(MultipartFile branchesFile, MultipartFile employeesFile) throws IOException, ParseException {
		service.inicializate(branchesFile, employeesFile);
	}
}
