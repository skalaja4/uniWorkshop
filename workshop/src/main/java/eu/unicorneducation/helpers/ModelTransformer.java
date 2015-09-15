package eu.unicorneducation.helpers;

import java.util.ArrayList;
import java.util.List;

import eu.unicorneducation.entity.Evaluation;
import eu.unicorneducation.model.EmployeeModel;
import eu.unicorneducation.model.EmployeeRESTModel;
import eu.unicorneducation.model.EvaluationRESTModel;

/**
 * Class with static methods used to help transfor from one object to another.
 */
public class ModelTransformer {

	public static EmployeeRESTModel employeeModelToEmployeeRESTModel(
			EmployeeModel emp) {
		EmployeeRESTModel empRest;

		String evaluationPlanName = emp.getPlan() == null ? "null" : emp.getPlan().getName();
		
		empRest = new EmployeeRESTModel(emp.getId(), emp.getFirstName(),
				emp.getLastName(), emp.getBirthDate(), evaluationPlanName,
				ModelTransformer.evaluationToEvaluationRESTModel(emp.getEvaluation()),
				emp.getBranch().getId(), emp.getCategory());

		return empRest;
	}

	public static List<EvaluationRESTModel> evaluationToEvaluationRESTModel(List<Evaluation> eva) {
		List<EvaluationRESTModel> result = new ArrayList<>();

		for (Evaluation eval : eva) {
			result.add(new EvaluationRESTModel(eval.getId(), eval.getName(),
					eval.getFill_date(), eval.getquestion1(), eval
							.getquestion2(), eval.getquestion3(), eval
							.getquestion4(), eval.getquestion5(), eval
							.getquestion6(), eval.getquestion7(), eval
							.getquestion8(), eval.getquestion9(), eval
							.getquestion10()));
		}
		
		return result;
	}
}
