package eu.unicorneducation.service;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.web.multipart.MultipartFile;

public interface InicializationService {

	public void inicializate(MultipartFile branchesFile, MultipartFile employeesFile) throws IOException, ParseException;
	
	public void addEmployees(MultipartFile branchesFile) throws IOException, ParseException;
}
