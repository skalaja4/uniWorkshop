package eu.unicorneducation.service;

import java.util.List;

import eu.unicorneducation.entity.Employee;
import eu.unicorneducation.entity.Evaluation;
import eu.unicorneducation.model.EmployeeModel;

public interface EmployeeService {

	/**
	 * Method for reading all employees in database
	 * @return List of Employees
	 */
	public List<Employee> readAll();
	/**
	 * Reading Employees that are in exact branch, have exact category, don´t have planned evaluation and are not managers  
	 * @param branch Branch id that employees are in
	 * @param category Category of employees
	 * @return List of Employees
	 */
	public List<Employee> readByBranchAndCategory(String branch, String category);
	/**
	 * Reading Employees that are in exact branch, are not in exact category, don´t have planned evaluation and are not managers  
	 * @param branch Branch id that employees are in
	 * @param category Category of employees
	 * @return List of Employees
	 */
	public List<Employee> readByBranchWithoutCategory(String branch, String category);
	/**
	 * Reading employees that are in exact branch
	 * @param branch Branch id that employees are in
	 * @return List of Employees
	 */
	public List<Employee> readByBranch(String branch);
	/**
	 * Reading Employees with exact Ids
	 * @param employeeIds Ids of Employees we want to read
	 * @return List of Employees
	 */
	public List<Employee> readByIds(String[] employeeIds);
	/**
	 * Method for reading entity Employee by id
	 * @param employeeId Id of Employee that we want to read
	 * @return return Employee we got from database
	 */
	public Employee readByID(String employeeId);
	/**
	 * Method for reading entity Employees in exact branch with first or last name given by lastname
	 * @param lastname first or last name of Employee
	 * @param branchid Id of Branch
	 * @return List of Employees
	 */
	public List<Employee> readByLastName(String lastname, String branchid);
	/**
	 * Reading Employees that are in exact branch, don´t have planned evaluation and are not managers  
	 * @param branch Branch id that employees are in
	 * @return List of Employees
	 */
	public List<Employee> readByBranchAndNotPlanned(String branch);
	
}
