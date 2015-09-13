package eu.unicorneducation.service;

import java.util.List;

import eu.unicorneducation.entity.Employee;

public interface EmployeeService {

	 List<Employee> readAll();
	 List<Employee> readByBranchAndCategory(String branch, String category);
	 List<Employee> readByBranchWithoutCategory(String branch, String category);
	 List<Employee> readByBranch(String branch);
	 List<Employee> readByIds(String[] employeeIds);
}
