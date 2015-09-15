package eu.unicorneducation.facade;

import java.util.List;

import eu.unicorneducation.model.EmployeeModel;

public interface EmployeeFacade {
	/**
	 * Read all Employees from database and transfer them to EmployeeModel
	 * @return List of EmployeeModel
	 */
	public List<EmployeeModel> readAll();
	/**
	 * Reading Employees that are in exact branch, have exact category, don´t have planned evaluation and are not managers and transfer them into EmployeeModel
	 * @param branch Branch id that employees are in
	 * @param category Category of employees
	 * @return List of EmployeeModel
	 */
	public List<EmployeeModel>readByBranchAndCategory(String branch,String category);
	/**
	 * Reading Employees that are in exact branch, are not in exact category, don´t have planned evaluation and are not managers and transfer them into EmployeeModel
	 * @param branch Branch id that employees are in
	 * @param category Category of employees
	 * @return List of EmployeeModel
	 */
	public List<EmployeeModel>readByBranchWithoutCategory(String branch,String category);
	
	/**
	 * Reading employees that are in exact branch and transfer them into EmployeeModel
	 * @param branch Branch id that employees are in
	 * @return List of EmployeeModel
	 */
	public List<EmployeeModel> readByBranch(String branch);
	/**
	 * Reading Employees with exact Ids and transfer them into EmployeeModel
	 * @param employeeIds Ids of Employees we want to read
	 * @return List of EmployeeModel
	 */
	public List<EmployeeModel> readByIds(String[] employeeIds);
	
	/**
	 * Method for reading entity Employee by id and transfer them into EmployeeModel
	 * @param employeeId Id of Employee that we want to read
	 * @return return EmployeeModel 
	 */
	public EmployeeModel readByID(String employeeId);
	/**
	 * Method for reading entity Employees in exact branch with first or last name given by lastname and transfer them into EmployeeModel
	 * @param lastname first or last name of Employee
	 * @param branchid Id of Branch
	 * @return List of EmployeeModels
	 */
	public List<EmployeeModel> readByLastName(String lastname, String branchid);
	/**
	 * Reading Employees that are in exact branch, don´t have planned evaluation and are not managers and transfer them into EmployeeModel 
	 * @param branch Branch id that employees are in
	 * @return List of EmployeeModel
	 */
	public List<EmployeeModel> readByBranchAndNotPlanned(String branch);
	
}
