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
	public List<EvaluationModel> getEvaluations(String empID) {
		List<EvaluationModel> listofev = new ArrayList<EvaluationModel>();
		for(Evaluation e : employeeserv.getEvaluations(empID))
		{
			listofev.add(new EvaluationModel(e.getId(),e.getName(),e.getFill_date(),e.getQuestion1(),
					e.getQuestion2(),e.getQuestion3(),e.getQuestion4(),e.getQuestion5(),e.getQuestion6(),
					e.getQuestion7(),e.getQuestion8(),e.getQuestion9(),e.getQuestion10()));
			
		}
		
		return listofev;
	}

}
