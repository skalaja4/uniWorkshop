package eu.unicorneducation.model.transformation;

import java.util.ArrayList;
import java.util.List;

import eu.unicorneducation.entity.Evaluation;
import eu.unicorneducation.model.EvaluationModel;

public class EvaluationTransformation {

	public static EvaluationModel transToModel(Evaluation evaluation) {
		EvaluationModel model = new EvaluationModel(evaluation.getId(),
				evaluation.getName(), evaluation.getFill_date(),
				evaluation.getQuestion1(), evaluation.getQuestion2(),
				evaluation.getQuestion3(), evaluation.getQuestion4(),
				evaluation.getQuestion5(), evaluation.getQuestion6(),
				evaluation.getQuestion7(), evaluation.getQuestion8(),
				evaluation.getQuestion9(), evaluation.getQuestion10());
		return model;
	}

	public static Evaluation transToEntity(EvaluationModel model) {
		Evaluation evaluation = new Evaluation(model.getId(), model.getName(),
				model.getFill_date(), model.getQuestion1(),
				model.getQuestion2(), model.getQuestion3(),
				model.getQuestion4(), model.getQuestion5(),
				model.getQuestion6(), model.getQuestion7(),
				model.getQuestion8(), model.getQuestion9(),
				model.getQuestion10(),
				EmployeeTransformation.transToEntity(model.getEmployeeModel()));
		return evaluation;
	}

	public static List<EvaluationModel> transToModelList(List<Evaluation> list) {
		List<EvaluationModel> modelList = new ArrayList<EvaluationModel>();
		for (Evaluation evaluation : list) {
			modelList.add(transToModel(evaluation));
		}
		return modelList;
	}

	public static List<Evaluation> transToEntityList(List<EvaluationModel> list) {
		List<Evaluation> entityList = new ArrayList<Evaluation>();
		for (EvaluationModel evaluationModel : list) {
			entityList.add(transToEntity(evaluationModel));
		}
		return entityList;
	}
}