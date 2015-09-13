package eu.unicorneducation.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.unicorneducation.entity.Employee;
import eu.unicorneducation.facade.EmployeeFacade;
import eu.unicorneducation.model.EmployeeModel;
import eu.unicorneducation.service.EmployeeService;

@Component
public class EmployeeFacadeImpl implements EmployeeFacade {
	
	@Autowired
	private EmployeeService employeeserv;

	public List<EmployeeModel> readAll() {
	
			List<EmployeeModel> listofserv = new ArrayList<EmployeeModel>();
		
		for (Employee s: employeeserv.readAll()) {
			listofserv.add(new EmployeeModel(s));
		}
		
		return listofserv;
	}

	@Override
	public List<EmployeeModel> readByBranchAndCategory(String branch, String category) {
		List<EmployeeModel> listofserv = new ArrayList<EmployeeModel>();

		for (Employee s : employeeserv.readByBranchAndCategory(branch, category)) {
			listofserv.add(new EmployeeModel(s));
		}

		return listofserv;
	}

	@Override
	public List<EmployeeModel> readByBranchWithoutCategory(String branch, String category) {

		List<EmployeeModel> listofserv = new ArrayList<EmployeeModel>();

		for (Employee s : employeeserv.readByBranchWithoutCategory(branch, category)) {
			listofserv.add(new EmployeeModel(s));
		}

		return listofserv;
	}

	@Override
	public List<EmployeeModel> readByBranch(String branch) {
		List<EmployeeModel> listofserv = new ArrayList<EmployeeModel>();

		for (Employee s : employeeserv.readByBranch(branch)) {
			listofserv.add(new EmployeeModel(s));
		}

		return listofserv;
	}

	@Override
	public List<EmployeeModel> readByIds(String[] employeeIds) {
		List<EmployeeModel> listofserv = new ArrayList<EmployeeModel>();

		for (Employee s : employeeserv.readByIds(employeeIds)) {
			listofserv.add(new EmployeeModel(s));
		}

		return listofserv;
	}

}
