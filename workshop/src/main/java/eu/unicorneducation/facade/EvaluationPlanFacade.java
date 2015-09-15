package eu.unicorneducation.facade;

import java.util.List;

import eu.unicorneducation.entity.EvaluationPlan;
import eu.unicorneducation.model.EvaluationModel;
import eu.unicorneducation.model.EvaluationPlanModel;
import eu.unicorneducation.model.EvaluationPlanPartsModel;

/**
 * 
 * @author Ondrej
 *
 */
public interface EvaluationPlanFacade {

	/**
	 * Method for storing new EvaluationPlanModel to database.
	 * @param evaPlanModel object that should be 
	 * 		  save to database.
	 * @param employeeIDs IDs of employees that are in this plan 
	 * @return True if creation operation was successful.
	 */
	public boolean create(EvaluationPlanModel evaPlanModel, String[] employeeIDs);
	
	/**
	 * Read EvaluationPlanModel from database given by ID
	 * @param id ID of EvaluationPlanModel
	 * @return EvaluationPlanModel
	 */
	public EvaluationPlanModel read(Long id);
	
	/**
	 * Method for updating EvaluationPlanModel to database.
	 * @param evaPlanModel object that should be 
	 * 		  updated to database.
	 * @param employeeIDs IDs of employees that are in this plan 
	 * @return True if updating was successful.
	 */
	public boolean update(EvaluationPlanModel evaPlanModel, String[] employeeIDs);
	
	/**
	 * Removes EvaluationPlanMdel represents EvaluationPlan from database
	 *
	 * @param evaPlanModel EvaluationPlan which needs to be deleted
	 * @return True if deletion was successfully done 
	 */
	public boolean delete(EvaluationPlanModel evaPlanModel);
	
	/**
	 * Method for finding all existing EvaluationPlans and transfer them into Model
	 * @return List of existing EvaluationPlanModels.
	 */
	public List<EvaluationPlanModel> readAll();
	
	/**
	 * Method for getting all EvaluationPlans before expiration and transfer them into Model
	 * @return List of all EvaluationPlanModels thats are
	 * 		   before expiration date.
	 */
	public List<EvaluationPlanPartsModel> readAllBeforeDate();
	
	/**
	 * Method for getting all EvaluationPlans after date of expiration and transfer them into Model
	 * @return List of EvaluationModels after expiration date.
	 */
	public List<EvaluationPlanPartsModel> readAllAfterDate();
	
	/**
	 * Method for getting all EvaluationPlans that are completed (filled).
	 * @return List of EvaluationModels that are completed (filled).
	 */
	public List<EvaluationPlanPartsModel> readAllCompleted();
	
	/**
	 * Method for setting EvaluationPlan as completed using id
	 * @param id Id of plan that we want to change
	 * @return true if changing is successful
	 */
	public boolean setCompleted(Long id);
	
}
