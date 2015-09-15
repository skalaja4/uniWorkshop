package eu.unicorneducation.service;

import java.util.List;

import eu.unicorneducation.dao.EvaluationDAO;
import eu.unicorneducation.entity.Evaluation;

public interface EvaluationService {
	
	/**
	 * 
	 *@see  eu.unicorneducation.service.EvaluationService#getEvaluations(String)
	 */
	public List<Evaluation> getEvaluations(String empID);
	
	/**
	 * 
	 *@see EvaluationDAO
	 */
	public boolean create(Evaluation evaluation);
	
	/**
	 * 
	 *@see EvaluationDAO
	 */
	public Evaluation read(Long id);
	
	/**
	 * 
	 *@see EvaluationDAO
	 */
	public boolean delete(Evaluation evaluation);
	
	/**
	 * 
	 *@see EvaluationDAO
	 */
	public List<Evaluation> readAll();

}
