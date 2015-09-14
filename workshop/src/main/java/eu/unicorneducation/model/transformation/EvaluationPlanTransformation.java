package eu.unicorneducation.model.transformation;

import java.util.ArrayList;
import java.util.List;

import eu.unicorneducation.entity.EvaluationPlan;
import eu.unicorneducation.model.EvaluationPlanModel;

public class EvaluationPlanTransformation {
	
	public static EvaluationPlanModel transToModel(EvaluationPlan plan) {
		EvaluationPlanModel model =  new EvaluationPlanModel(plan.getId(),
				plan.getName(), plan.getExpiration(),
				BranchTransformation.transToModel(plan.getBranch()),
				EmployeeTransformation.transToModelList(plan.getEmployees()),
				plan.isCompleted());
		return model;
	}
	
	public static EvaluationPlan transToEntity(EvaluationPlanModel model) {
		EvaluationPlan plan = new EvaluationPlan(model.getId(),model.getName(),
				model.getExpiration(), BranchTransformation.transToEntity(model.getBranch()),
				EmployeeTransformation.transToEntityList(model.getEmployees()), model.isCompleted());				
		return plan;
	}
	
	public static List<EvaluationPlanModel> transToModelList(List<EvaluationPlan> list) {
		List<EvaluationPlanModel> modelList = new ArrayList<EvaluationPlanModel>();
		for (EvaluationPlan evaluation : list) {
			modelList.add(transToModel(evaluation));
		}
		return modelList;
	}
	
	public static List<EvaluationPlan> transToEntityList(List<EvaluationPlanModel> list) {
		List<EvaluationPlan> evaluationPlans = new ArrayList<EvaluationPlan>();
		for (EvaluationPlanModel model : list) {
			evaluationPlans.add(transToEntity(model));
		}
		return evaluationPlans;
	}

}
