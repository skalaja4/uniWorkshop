package eu.unicorneducation.facade;

import java.util.List;

import eu.unicorneducation.model.EvaluationModel;

public interface EvaluationFacade {
	List<EvaluationModel> getEvaluations(String empID);
	public boolean create(EvaluationModel evaluation);
	public EvaluationModel read(Long id);
	public List<EvaluationModel> readAll();
}
