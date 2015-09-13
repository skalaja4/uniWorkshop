package eu.unicorneducation.facade;

import java.util.List;

import eu.unicorneducation.model.EvaluationPlanModel;

public interface EvaluationPlanFacade {

	
	List<EvaluationPlanModel> readAll();
	boolean create(EvaluationPlanModel evaPlanModel, String[] employeeIDs);
}
