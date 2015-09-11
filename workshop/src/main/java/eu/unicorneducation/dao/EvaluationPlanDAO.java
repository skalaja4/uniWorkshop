package eu.unicorneducation.dao;

import java.util.List;

import eu.unicorneducation.entity.EvaluationPlan;

public interface EvaluationPlanDAO {
	public boolean create(EvaluationPlan evaluationPlan);
	public EvaluationPlan read(String id);
	public boolean updeat(EvaluationPlan evaluationPlan);
	public boolean delete(EvaluationPlan valuationPlan);
	public List<EvaluationPlan> readAll();
}
