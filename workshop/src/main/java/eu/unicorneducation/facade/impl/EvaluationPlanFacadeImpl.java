package eu.unicorneducation.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.unicorneducation.entity.Branch;
import eu.unicorneducation.entity.EvaluationPlan;
import eu.unicorneducation.facade.EvaluationPlanFacade;
import eu.unicorneducation.model.EvaluationPlanModel;
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

	
		Branch branch = new Branch(evaPlanModel.getBranch().getId(), evaPlanModel.getBranch().getName(),
				evaPlanModel.getBranch().getAddress(), evaPlanModel.getBranch().getParrentBranch());

		
		return evaPlanService.create(new EvaluationPlan(evaPlanModel.getName(), evaPlanModel.getExpiration(), branch,
				employeeService.readByIds(employeeIDs), false));
	}

	@Override
	public EvaluationPlanModel read(Long id) {
		// TODO Auto-generated method stub
		return null;
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
	public List<EvaluationPlanModel> readAllBeforeDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EvaluationPlanModel> readAllAfterDate() {
		// TODO Auto-generated method stub
		return null;
	}

}
