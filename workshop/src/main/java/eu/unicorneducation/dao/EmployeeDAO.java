package eu.unicorneducation.dao;

import java.util.List;

import eu.unicorneducation.entity.Employee;
import eu.unicorneducation.entity.Evaluation;

public interface EmployeeDAO {

	public boolean create(Employee employee);
	public Employee read(String id);
	public boolean delete(Employee employee);
	public List<Employee> readAll();
	public boolean createAll(List<Employee> employees);
	public List<Employee> readByBranchAndCategory(String branch,String category);
	public List<Employee> readByBranchWithoutCategory(String branch, String category);
	public List<Employee> readByBranch(String branch);
	public List<Employee> readByIds(String[] employeeIds);
	Employee readByID(String employeeId);
	
	List<Employee> readByLastName(String lastname);
	
}
