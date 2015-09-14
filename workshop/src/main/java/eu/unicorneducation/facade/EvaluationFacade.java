package eu.unicorneducation.facade;

import java.util.List;

import eu.unicorneducation.model.EvaluationModel;

public interface EvaluationFacade {
	List<EvaluationModel> getEvaluations(String empID);
}
