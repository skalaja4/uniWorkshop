package eu.unicorneducation.dao;

import java.util.List;

import eu.unicorneducation.entity.Employee;
import eu.unicorneducation.entity.Evaluation;

/**
 * Interface representing DAO layer for Employee.
 * @author Jaroslav Skala
 *
 */
public interface EmployeeDAO {

	/**
	 * Method for creation Employee in database
	 * @param employee Employee that we want to create
	 * @return true if creation is successful
	 */
	public boolean create(Employee employee);
	/**
	 * Method for reading entity Employee by id
	 * @param id Id of Employee that we want to read
	 * @return return Employee we got from database
	 */
	public Employee read(String id);
	/**
	 * Method for deleting Employee from database
	 * @param employee Employee we want to delete
	 * @return true if deleting is successful
	 */
	public boolean delete(Employee employee);
	/**
	 * Method for reading all employees in database
	 * @return List of Employees
	 */
	public List<Employee> readAll();
	/**
	 * Method for creation of all Employees to database.
	 * @param employees List of Employees we want to create
	 * @return true if creation is successful
	 */
	public boolean createAll(List<Employee> employees);
	/**
	 * Reading Employees that are in exact branch, have exact category, don´t have planned evaluation and are not managers  
	 * @param branch Branch id that employees are in
	 * @param category Category of employees
	 * @return List of Employees
	 */
	public List<Employee> readByBranchAndCategory(String branch,String category);
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
	 * Reading Employees that are in exact branch, don´t have planned evaluation and are not managers  
	 * @param branch Branch id that employees are in
	 * @return List of Employees
	 */
	public List<Employee> readByBranchAndNotPlaned(String branch) ;
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
	 * Method for reading entity Employee by i
	 * @param lastname
	 * @param branchid
	 * @return
	 */
	public List<Employee> readByLastName(String lastname, String branchid);
	
}
