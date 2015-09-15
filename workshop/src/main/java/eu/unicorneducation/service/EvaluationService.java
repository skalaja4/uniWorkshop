package eu.unicorneducation.service;

import java.util.List;

import eu.unicorneducation.entity.Evaluation;

public interface EvaluationService {
	
	public List<Evaluation> getEvaluations(String empID);
	public boolean create(Evaluation evaluation);
	public Evaluation read(Long id);
	public boolean delete(Evaluation evaluation);
	public List<Evaluation> readAll();

}
