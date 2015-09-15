package eu.unicorneducation.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.unicorneducation.entity.Employee;
import eu.unicorneducation.entity.Evaluation;
import eu.unicorneducation.facade.EmployeeFacade;
import eu.unicorneducation.model.EmployeeModel;
import eu.unicorneducation.model.EvaluationModel;


import eu.unicorneducation.service.EmployeeService;

@Component
public class EmployeeFacadeImpl implements EmployeeFacade {

	@Autowired
	private EmployeeService employeeserv;

	public List<EmployeeModel> readAll() {

		List<EmployeeModel> listofserv = new ArrayList<EmployeeModel>();

		for (Employee emp : employeeserv.readAll()) {
			listofserv.add(new EmployeeModel(emp.getId(), emp.getFirstName(),
					emp.getLastName(), emp.getBirthDate(), emp.getPlan(), emp
							.getEvaluation(), emp.getBranch(), emp
							.getCategory()));
		}

		return listofserv;
	}

	@Override
	public List<EmployeeModel> readByBranchAndCategory(String branch,
			String category) {
		List<EmployeeModel> listofserv = new ArrayList<EmployeeModel>();

		for (Employee emp : employeeserv.readByBranchAndCategory(branch,
				category)) {
			listofserv.add(new EmployeeModel(emp.getId(), emp.getFirstName(),
					emp.getLastName(), emp.getBirthDate(), emp.getPlan(), emp
							.getEvaluation(), emp.getBranch(), emp
							.getCategory()));
		}

		return listofserv;
	}

	@Override
	public List<EmployeeModel> readByBranchWithoutCategory(String branch,
			String category) {

		List<EmployeeModel> listofserv = new ArrayList<EmployeeModel>();

		for (Employee emp : employeeserv.readByBranchWithoutCategory(branch,
				category)) {
			listofserv.add(new EmployeeModel(emp.getId(), emp.getFirstName(),
					emp.getLastName(), emp.getBirthDate(), emp.getPlan(), emp
							.getEvaluation(), emp.getBranch(), emp
							.getCategory()));
		}

		return listofserv;
	}

	@Override
	public List<EmployeeModel> readByBranch(String branch) {
		List<EmployeeModel> listofserv = new ArrayList<EmployeeModel>();

		for (Employee emp : employeeserv.readByBranch(branch)) {
			listofserv.add(new EmployeeModel(emp.getId(), emp.getFirstName(),
					emp.getLastName(), emp.getBirthDate(), emp.getPlan(), emp
							.getEvaluation(), emp.getBranch(), emp
							.getCategory()));
		}

		return listofserv;
	}

	@Override
	public List<EmployeeModel> readByIds(String[] employeeIds) {
		List<EmployeeModel> listofserv = new ArrayList<EmployeeModel>();

		for (Employee emp : employeeserv.readByIds(employeeIds)) {
			listofserv.add(new EmployeeModel(emp.getId(), emp.getFirstName(),
					emp.getLastName(), emp.getBirthDate(), emp.getPlan(), emp
							.getEvaluation(), emp.getBranch(), emp
							.getCategory()));
		}

		return listofserv;
	}

	@Override
	public EmployeeModel readByID(String employeeId) {
		Employee emp = employeeserv.readByID(employeeId);
		EmployeeModel e = new EmployeeModel(emp.getId(), emp.getFirstName(),
				emp.getLastName(), emp.getBirthDate(), emp.getPlan(), emp
				.getEvaluation(), emp.getBranch(), emp
				.getCategory());
		
		return e;
	}

	@Override
	public List<EmployeeModel> readByBLastName(String lastname, String branch) {
		List<Employee> list = employeeserv.readByLastName(lastname, branch);
		List<EmployeeModel> listofmodels = new ArrayList<EmployeeModel>();
		for (Employee emp : list) {
			listofmodels.add(new EmployeeModel(emp.getId(), emp.getFirstName(),
					emp.getLastName(), emp.getBirthDate(), emp.getPlan(), emp
							.getEvaluation(), emp.getBranch(), emp
							.getCategory()));
		}
		return listofmodels;
	}

	

}
