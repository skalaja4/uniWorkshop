package eu.unicorneducation.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.unicorneducation.entity.Branch;
import eu.unicorneducation.entity.Employee;
import eu.unicorneducation.entity.EvaluationPlan;
import eu.unicorneducation.facade.EvaluationPlanFacade;
import eu.unicorneducation.model.BranchModel;
import eu.unicorneducation.model.EmployeeModel;
import eu.unicorneducation.model.EvaluationPlanModel;
import eu.unicorneducation.model.EvaluationPlanPartsModel;
import eu.unicorneducation.service.EmployeeService;
import eu.unicorneducation.service.EvaluationPlanService;

@Component
public class EvaluationPlanFacadeImpl implements EvaluationPlanFacade {

	@Autowired
	EvaluationPlanService evaPlanService;

	@Autowired
	EmployeeService employeeService;

	@Override
	public List<EvaluationPlanModel> readAll() {

		return null;
	}

	@Override
	public boolean create(EvaluationPlanModel evaPlanModel, String[] employeeIDs) {

		Branch branch = new Branch(evaPlanModel.getBranch().getId(),
				evaPlanModel.getBranch().getName(), evaPlanModel.getBranch()
						.getAddress(), evaPlanModel.getBranch()
						.getParrentBranch());

		return evaPlanService.create(new EvaluationPlan(evaPlanModel.getName(),
				evaPlanModel.getExpiration(), branch, employeeService
						.readByIds(employeeIDs), false));
	}

	@Override
	public EvaluationPlanModel read(Long id) {
		EvaluationPlan plan = evaPlanService.read(id);
		List<EmployeeModel> modelList = new ArrayList<EmployeeModel>(); 
		for (Employee emp : plan.getBranch().getEmployees()) {
			modelList.add(new EmployeeModel(emp.getId(), emp.getFirstName(),
					emp.getLastName(), emp.getBirthDate(), emp.getPlan(), emp.getEvaluation(), emp.getBranch(), emp.getCategory()));
		}
		BranchModel branch = new BranchModel(plan.getBranch().getId(), plan.getBranch().getName(),
				plan.getBranch().getAddress(), plan.getBranch().getParrentBranch(),modelList, plan.getBranch().getManager());
		List<EmployeeModel> employees = new ArrayList<EmployeeModel>(); 
		for (Employee emp : plan.getBranch().getEmployees()) {
			employees.add(new EmployeeModel(emp.getId(), emp.getFirstName(),
					emp.getLastName(), emp.getBirthDate(), emp.getPlan(), emp.getEvaluation(), emp.getBranch(), emp.getCategory()));
		}
		return new EvaluationPlanModel(id,plan.getName(), plan.getExpiration(), branch, employees);
	}

	@Override
	public boolean update(EvaluationPlanModel evaPlanModel, String[] employeeIDs) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(EvaluationPlanModel evaPlanModel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<EvaluationPlanPartsModel> readAllBeforeDate() {
		List<EvaluationPlan> evaPlans = evaPlanService.readAllBeforeDate();
		List<EvaluationPlanPartsModel> returnedList = new ArrayList<>();
		for (EvaluationPlan evaluationPlan : evaPlans) {
			List<String> emplIds=new ArrayList<>();
			List<String> emplFNames= new ArrayList<>();
			List<String> emplLNames = new ArrayList<>();
			for(Employee employees:evaluationPlan.getEmployees()){
				emplIds.add(employees.getId());
				emplFNames.add(employees.getFirstName());
				emplLNames.add(employees.getLastName());
			}
			returnedList.add(new EvaluationPlanPartsModel(evaluationPlan.getId(),evaluationPlan.getName(),
					evaluationPlan.getExpiration(),emplIds,emplFNames,emplLNames,evaluationPlan.getBranch().getName()));
			

		}

		return returnedList;

	}

	@Override
	public List<EvaluationPlanPartsModel> readAllAfterDate() {
		 List<EvaluationPlan> evaPlans = evaPlanService.readAllAfterDate();
		List<EvaluationPlanPartsModel> returnedList = new ArrayList<>();
		for (EvaluationPlan evaluationPlan : evaPlans) {
			List<String> emplIds=new ArrayList<>();
			List<String> emplFNames= new ArrayList<>();
			List<String> emplLNames = new ArrayList<>();
			for(Employee employees:evaluationPlan.getEmployees()){
				emplIds.add(employees.getId());
				emplFNames.add(employees.getFirstName());
				emplLNames.add(employees.getLastName());
			}
			returnedList.add(new EvaluationPlanPartsModel(evaluationPlan.getId(),evaluationPlan.getName(),
					evaluationPlan.getExpiration(),emplIds,emplFNames,emplLNames,evaluationPlan.getBranch().getName()));
			

		}

		return returnedList;
	
	}

	@Override
	public List<EvaluationPlanPartsModel> readAllCompleted() {
		List<EvaluationPlan> evaPlans = evaPlanService.readAllCompleted();
		List<EvaluationPlanPartsModel> returnedList = new ArrayList<>();
		for (EvaluationPlan evaluationPlan : evaPlans) {
			List<String> emplIds=new ArrayList<>();
			List<String> emplFNames= new ArrayList<>();
			List<String> emplLNames = new ArrayList<>();
			for(Employee employees:evaluationPlan.getEmployees()){
				emplIds.add(employees.getId());
				emplFNames.add(employees.getFirstName());
				emplLNames.add(employees.getLastName());
			}
			returnedList.add(new EvaluationPlanPartsModel(evaluationPlan.getId(),evaluationPlan.getName(),
					evaluationPlan.getExpiration(),emplIds,emplFNames,emplLNames,evaluationPlan.getBranch().getName()));
			

		}

		return returnedList;
	}

	@Override
	public boolean setCompleted(EvaluationPlanModel evaPlanModel) {
		Branch branch = new Branch(evaPlanModel.getBranch().getId(),
				evaPlanModel.getBranch().getName(), evaPlanModel.getBranch()
						.getAddress(), evaPlanModel.getBranch()
						.getParrentBranch());
		List<Employee> employees = new ArrayList<Employee>(); 
		for(EmployeeModel model:evaPlanModel.getEmployees()){
			employees.add(new Employee(model.getId(), model.getFirstName(), model.getLastName(), model.getBranch(), model.getBirthDate(), model.getCategory()));		
		}
		EvaluationPlan plan = new EvaluationPlan(evaPlanModel.getName(), evaPlanModel.getExpiration(),
				branch, employees, true);
		return evaPlanService.setCompleted(plan);
	}

}
