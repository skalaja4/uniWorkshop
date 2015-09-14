package eu.unicorneducation.facade;

import java.util.List;

import eu.unicorneducation.entity.Evaluation;
import eu.unicorneducation.model.EmployeeModel;
import eu.unicorneducation.model.EvaluationModel;

public interface EmployeeFacade {
	
	List<EmployeeModel> readAll();
	List<EmployeeModel>readByBranchAndCategory(String branch,String category);
	List<EmployeeModel>readByBranchWithoutCategory(String branch,String category);
	List<EmployeeModel> readByBranch(String branch);
	List<EmployeeModel> readByIds(String[] employeeIds);
	EmployeeModel readByID(String employeeId);
	
}
