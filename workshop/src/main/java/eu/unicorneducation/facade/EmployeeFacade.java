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
	
	public List<EmployeeModel> readByIds(String[] employeeIds);
	public EmployeeModel readByID(String employeeId);
	public List<EmployeeModel> readByLastName(String lastname, String branchid);
	public List<EmployeeModel> readByBranchAndNotPlanned(String branch);
	
}
