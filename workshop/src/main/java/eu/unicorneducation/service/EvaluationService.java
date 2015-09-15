package eu.unicorneducation.service;

import java.util.List;

import eu.unicorneducation.entity.Evaluation;

public interface EvaluationService {
	 List <Evaluation> getEvaluations(String empID);
}
