package eu.unicorneducation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.unicorneducation.dao.EvaluationPlanDAO;
import eu.unicorneducation.entity.EvaluationPlan;
import eu.unicorneducation.service.EvaluationPlanService;

@Component
public class EvaluationPlanServiceImpl implements EvaluationPlanService{
	
	@Autowired
	EvaluationPlanDAO evaPlanDAO;
	
	@Override
	public List<EvaluationPlan> readAll() {
		
		return evaPlanDAO.readAll();
		
	}

	@Override
	public boolean create(EvaluationPlan evalPlan) {
		return evaPlanDAO.create(evalPlan);
	}

}
