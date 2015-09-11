package eu.unicorneducation.dao;

import java.util.List;

import eu.unicorneducation.entity.Evaluation;

public interface EvaluationDAO {
	public boolean create(Evaluation evaluation);
	public Evaluation read(String id);
	public boolean updeat(Evaluation evaluation);
	public boolean delete(Evaluation evaluation);
	public List<Evaluation> readAll();
}
