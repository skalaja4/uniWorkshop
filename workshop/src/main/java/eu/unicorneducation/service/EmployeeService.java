package eu.unicorneducation.service;

import java.util.List;

import eu.unicorneducation.entity.Employee;
import eu.unicorneducation.entity.Evaluation;
import eu.unicorneducation.model.EmployeeModel;

public interface EmployeeService {

	 List<Employee> readAll();
	 List<Employee> readByBranchAndCategory(String branch, String category);
	 List<Employee> readByBranchWithoutCategory(String branch, String category);
	 List<Employee> readByBranch(String branch);
	 List<Employee> readByIds(String[] employeeIds);
	 Employee readByID(String employeeId);
	 List <Evaluation> getEvaluations(String empID);
}
