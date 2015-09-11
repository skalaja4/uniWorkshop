package eu.unicorneducation.dao;

import java.util.List;

import eu.unicorneducation.entity.Branch;
import eu.unicorneducation.entity.Employee;

public interface InicializationDAO {

	public void inicializateBranches(List<Branch> branches);
	
	public void inicializateEmployees(List<Employee> employees);
	
}
