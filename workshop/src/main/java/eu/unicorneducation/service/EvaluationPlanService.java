package eu.unicorneducation.service;

import java.util.List;

import eu.unicorneducation.entity.EvaluationPlan;


public interface EvaluationPlanService {

	List<EvaluationPlan> readAll();
	boolean create(EvaluationPlan evalPlan);
}
