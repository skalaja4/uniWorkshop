package eu.unicorneducation.facade;

import java.util.List;

import eu.unicorneducation.model.EmployeeModel;

public interface EmployeeFacade {
	
	List<EmployeeModel> readAll();
}
