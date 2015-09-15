package eu.unicorneducation.dao;

import java.util.List;
import eu.unicorneducation.entity.EvaluationPlan;

/**
 * Interface representing DAO layer for EvaluationPlan.
 * 
 * @author Ondrej
 *
 */
public interface EvaluationPlanDAO {

	/**
	 * Method for storing new Evaluation plan to database.
	 * @param evaluationPlanrequire object that should be 
	 * 		  save to database.
	 * @return True if creation operation was successful.
	 */
	public boolean create(EvaluationPlan evaluationPlan);
	
	/**
	 * Method for reading specific Evaluation plan.
	 * 
	 * @param id Require id of type long for searching.
	 * @return Evaluation plan if plan exist otherwise null;
	 */
	public EvaluationPlan read(Long id);

	/**
	 * Method for updating existing Evaluation plan in the database.
	 * @param evaluationPlan
	 * @return True if updating operation was successful.
	 */
	public boolean update(EvaluationPlan evaluationPlan);


	/**
	 * Method for deleting Evaluation plan from database.
	 * @param evaluationPlan Require evaluation plan that
	 * 		  should be deleted.
	 * @return True if given parameter exists and was
	 * 		   removed, False if the plan does not exist
	 * 		   in database.
	 */
	public boolean delete(EvaluationPlan evaluationPlan);

	/**
	 * Method for finding all existing Evaluation plans. 
	 * @return List of existing Evaluation plans.
	 */
	public List<EvaluationPlan> readAll();
	
	/**
	 * Method for getting all Evaluations before expiration.
	 * @return List of all planed Evaluations thats are
	 * 		   before termination date.
	 */
	public List<EvaluationPlan> readAllBeforeDate();
	
	/**
	 * Method for getting all Evaluations after date of 
	 * @return List of Evaluations after date.
	 */
	public List<EvaluationPlan> readAllAfterDate();
	
	public List<EvaluationPlan> readAllCompleted();
}
