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

	public boolean create(EvaluationPlan evaluationPlan) {
		return evaPlanDAO.create(evaluationPlan);
	}

	public EvaluationPlan read(Long id) {
		return evaPlanDAO.read(id);
	}

	public boolean update(EvaluationPlan evaluationPlan) {
		return evaPlanDAO.update(evaluationPlan);
	}

	public boolean delete(EvaluationPlan evaluationPlan) {		
		return evaPlanDAO.delete(evaluationPlan);
	}

	public List<EvaluationPlan> readAll() {
		return evaPlanDAO.readAll();
	}

	public List<EvaluationPlan> readAllBeforeDate() {
		return evaPlanDAO.readAllBeforeDate();
	}

	public List<EvaluationPlan> readAllAfterDate() {
		return evaPlanDAO.readAllAfterDate();
	}

	@Override
	public List<EvaluationPlan> readAllCompleted() {
		
		return evaPlanDAO.readAllCompleted();
	}

	@Override
	public boolean setCompleted(EvaluationPlan evaluationPlan) {
		return  evaPlanDAO.setCompleted(evaluationPlan);
	}

}
