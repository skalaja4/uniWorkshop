package eu.unicorneducation.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.unicorneducation.entity.Employee;
import eu.unicorneducation.facade.EvaluationPlanFacade;
import eu.unicorneducation.model.EvaluationPlanModel;
import eu.unicorneducation.model.transformation.EmployeeTransformation;
import eu.unicorneducation.model.transformation.EvaluationPlanTransformation;
import eu.unicorneducation.service.EmployeeService;
import eu.unicorneducation.service.EvaluationPlanService;

@Component
public class EvaluationPlanFacadeImpl implements EvaluationPlanFacade {

	@Autowired
	EvaluationPlanService evaPlanService;

	@Autowired
	EmployeeService employeeService;

	@Override
	public boolean create(EvaluationPlanModel evaPlanModel, String[] employeeIDs) {

		List<Employee> employees = employeeService.readByIds(employeeIDs);
		evaPlanModel.setEmployees(EmployeeTransformation.transToModelList(employees));
		return evaPlanService.create(EvaluationPlanTransformation.transToEntity(evaPlanModel));		
	}

	@Override
	public EvaluationPlanModel read(Long id) {
		return EvaluationPlanTransformation.transToModel(evaPlanService.read(id));	
	}

	@Override
	public boolean update(EvaluationPlanModel evaPlanModel, String[] employeeIDs) {
		return evaPlanService.update(EvaluationPlanTransformation.transToEntity(evaPlanModel));
	}

	@Override
	public boolean delete(EvaluationPlanModel evaPlanModel) {
		return evaPlanService.delete(EvaluationPlanTransformation.transToEntity(evaPlanModel));
	}

	@Override
	public List<EvaluationPlanModel> readAll() {
		return EvaluationPlanTransformation.transToModelList(evaPlanService.readAll());
	}

	@Override
	public List<EvaluationPlanModel> readAllBeforeDate() {
		return EvaluationPlanTransformation.transToModelList(evaPlanService.readAllBeforeDate());
	}

	@Override
	public List<EvaluationPlanModel> readAllAfterDate() {
		return EvaluationPlanTransformation.transToModelList(evaPlanService.readAllAfterDate());
	}

}
