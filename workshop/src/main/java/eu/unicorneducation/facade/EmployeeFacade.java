package eu.unicorneducation.facade;

import java.util.List;

import eu.unicorneducation.model.EmployeeModel;

public interface EmployeeFacade {
	
	List<EmployeeModel> readAll();
	List<EmployeeModel>readByBranchAndCategory(String branch,String category);
	List<EmployeeModel>readByBranchWithoutCategory(String branch,String category);
	List<EmployeeModel> readByBranch(String branch);
	List<EmployeeModel> readByIds(String[] employeeIds);
}
