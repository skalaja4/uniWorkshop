package eu.unicorneducation.facade;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.web.multipart.MultipartFile;

public interface InicializationFacade {

	public void inicializate(MultipartFile branchesFile, MultipartFile employeesFile) throws IOException, ParseException;
}
