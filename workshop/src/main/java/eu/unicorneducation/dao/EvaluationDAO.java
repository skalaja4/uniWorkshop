package eu.unicorneducation.dao;

import java.util.List;

/**
 * Interface representing DAO layer for EvaluationPlan.
 * 
 * @author Petr
 *
 */

import eu.unicorneducation.entity.Evaluation;

public interface EvaluationDAO {
	
	
	/**
	 * Interface representing DAO layer for Evaluation.
	 * 
	 * @return True if creation was successfully 
	 *
	 */
	
	public boolean create(Evaluation evaluation);
	public Evaluation read(Long id);
	public boolean delete(Evaluation evaluation);
	public List<Evaluation> readAll();
	public List<Evaluation> getEvaluations(String empID);
}
