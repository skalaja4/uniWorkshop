package eu.unicorneducation.dao;

import java.util.List;

import eu.unicorneducation.entity.EvaluationPlan;

public interface EvaluationPlanDAO {
	public boolean create(EvaluationPlan evaluationPlan);
	public EvaluationPlan read(Long id);
	public boolean delete(EvaluationPlan evaluationPlan);
	public List<EvaluationPlan> readAll();
}
