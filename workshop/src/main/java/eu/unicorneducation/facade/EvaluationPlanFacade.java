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
	 * 
	 * @param evaPlanModel
	 * @param employeeIDs
	 * @return
	 */
	public boolean create(EvaluationPlanModel evaPlanModel, String[] employeeIDs);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public EvaluationPlanModel read(Long id);
	
	/**
	 * 
	 * @param evaPlanModel
	 * @param employeeIDs
	 * @return
	 */
	public boolean update(EvaluationPlanModel evaPlanModel, String[] employeeIDs);
	
	/**
	 * 
	 * @param evaPlanModel
	 * @return
	 */
	public boolean delete(EvaluationPlanModel evaPlanModel);
	
	/**
	 * 
	 * @return
	 */
	public List<EvaluationPlanModel> readAll();
	
	/**
	 * 
	 * @return
	 */
	public List<EvaluationPlanPartsModel> readAllBeforeDate();
	
	/**
	 * 
	 * @return
	 */
	public List<EvaluationPlanPartsModel> readAllAfterDate();
	
	public List<EvaluationPlanPartsModel> readAllCompleted();
	
	public boolean setCompleted(EvaluationPlanModel evaluationPlanModel);
	
}
