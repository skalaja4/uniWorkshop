package eu.unicorneducation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.unicorneducation.dao.EvaluationPlanDAO;
import eu.unicorneducation.entity.EvaluationPlan;

/**
 * 
 * @author Ondrej
 *
 */
@Component
public interface EvaluationPlanService {

	/**
	 * 
	 * @param evaluationPlan
	 * @return
	 */
	public boolean create(EvaluationPlan evaluationPlan);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public EvaluationPlan read(Long id);
	
	/**
	 * 
	 * @param evaluationPlan
	 * @return
	 */
	public boolean update(EvaluationPlan evaluationPlan);
	
	/**
	 * 
	 * @param evaluationPlan
	 * @return
	 */
	public boolean delete(EvaluationPlan evaluationPlan);
	
	/**
	 * 
	 * @return
	 */
	public List<EvaluationPlan> readAll();
	
	/**
	 * 
	 * @return
	 */
	public List<EvaluationPlan> readAllBeforeDate();
	
	/**
	 * 
	 * @return
	 */
	public List<EvaluationPlan> readAllAfterDate();
	
	public List<EvaluationPlan> readAllCompleted();
	
	public boolean setCompleted(Long id);
}
