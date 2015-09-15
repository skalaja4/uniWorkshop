package eu.unicorneducation.facade;

import java.util.List;

import eu.unicorneducation.model.EvaluationPlanModel;

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
	public List<EvaluationPlanModel> readAllBeforeDate();
	
	/**
	 * 
	 * @return
	 */
	public List<EvaluationPlanModel> readAllAfterDate();
	
}
