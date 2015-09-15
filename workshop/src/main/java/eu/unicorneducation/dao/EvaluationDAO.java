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
	
	
	
	/**
	 * Removes evaluation from database
	 *
	 * @param evaluation Evaluation which needs to be deleted
	 * @return True if deletion was successfully done 
	 */
	public boolean delete(Evaluation evaluation);
	
	
	/**
	 * Gets all evaluations from database
	 *
	 * @return List of all evaluations 
	 */
	public List<Evaluation> readAll();
	
	
	/**
	 * Gets evaluations of specific employee
	 *
	 * @param empID ID of employe whose evaluations are wanted to be obtained from database
	 * @return List of evaluations 
	 */
	public List<Evaluation> getEvaluations(String empID);
}
