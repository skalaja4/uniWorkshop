package eu.unicorneducation.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.unicorneducation.entity.Employee;
import eu.unicorneducation.facade.EmployeeFacade;
import eu.unicorneducation.model.EmployeeModel;
import eu.unicorneducation.model.transformation.EmployeeTransformation;
import eu.unicorneducation.service.EmployeeService;

@Component
public class EmployeeFacadeImpl implements EmployeeFacade {

	@Autowired
	private EmployeeService employeeserv;

	public List<EmployeeModel> readAll() {
		return EmployeeTransformation.transToModelList(employeeserv.readAll());
	}

	@Override
	public List<EmployeeModel> readByBranchAndCategory(String branch,
			String category) {
		List<EmployeeModel> listofserv = EmployeeTransformation
				.transToModelList(employeeserv.readByBranchAndCategory(branch,
						category));
		return listofserv;
	}

	@Override
	public List<EmployeeModel> readByBranchWithoutCategory(String branch,
			String category) {
		List<EmployeeModel> listofserv = EmployeeTransformation
				.transToModelList(employeeserv.readByBranchWithoutCategory(
						branch, category));
		return listofserv;
	}

	@Override
	public List<EmployeeModel> readByBranch(String branch) {
		List<EmployeeModel> listofserv = EmployeeTransformation
				.transToModelList(employeeserv.readByBranch(branch));
		return listofserv;
	}

	@Override
	public List<EmployeeModel> readByIds(String[] employeeIds) {
		List<EmployeeModel> listofserv = EmployeeTransformation
				.transToModelList(employeeserv.readByIds(employeeIds));
		return listofserv;
	}

	@Override
	public EmployeeModel readByID(String employeeId) {
		Employee emp = employeeserv.readByID(employeeId);
		return EmployeeTransformation.transToModel(emp);
	}

}
