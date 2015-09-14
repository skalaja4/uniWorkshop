package eu.unicorneducation.dao;

import java.util.List;

import eu.unicorneducation.entity.Evaluation;

public interface EvaluationDAO {
	public boolean create(Evaluation evaluation);
	public Evaluation read(Long id);
	public boolean delete(Evaluation evaluation);
	public List<Evaluation> readAll();
	List<Evaluation> getEvaluations(String empID);
}
