package eu.unicorneducation.facade;

import java.util.List;

import eu.unicorneducation.model.EvaluationModel;

public interface EvaluationFacade {
	/**
	 * Gets evaluations of specific employee and transfer it into EvaluationModel
	 *
	 * @param empID ID of employe whose evaluations are wanted to be obtained from database
	 * @return List of EvaluationModel 
	 */
	public List<EvaluationModel> getEvaluations(String empID);
	/**
	 * Send EvaluationModel to database to be created.
	 * 
	 * @return True if creation was successfull
	 *
	 */
	public boolean create(EvaluationModel evaluation);
	/**
	 * Gets evaluation by ID and transfer it into EvaluationModel
	 *
	 * @param id ID of evaluation which is needed
	 * @return EvaluationModel by ID 
	 */
	public EvaluationModel read(Long id);
	
	/**
	 * Method for reading all employees in database and transfer them into EvaluationModel
	 * @return List of EmployeeModels
	 */
	public List<EvaluationModel> readAll();
}
