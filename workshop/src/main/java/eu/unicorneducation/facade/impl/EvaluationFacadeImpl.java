package eu.unicorneducation.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.unicorneducation.entity.Evaluation;
import eu.unicorneducation.facade.EvaluationFacade;
import eu.unicorneducation.model.EvaluationModel;
import eu.unicorneducation.service.EvaluationService;
@Component
public class EvaluationFacadeImpl implements EvaluationFacade {

	@Autowired
	private EvaluationService evalserv;
	
	@Override
	public List<EvaluationModel> getEvaluations(String empID) {
		List<EvaluationModel> listofev = new ArrayList<EvaluationModel>();
		for(Evaluation e : evalserv.getEvaluations(empID))
		{
			listofev.add(new EvaluationModel(e.getId(),e.getName(),e.getFill_date(),e.getquestion1(),
					e.getquestion2(),e.getquestion3(),e.getquestion4(),e.getquestion5(),e.getquestion6(),
					e.getquestion7(),e.getquestion8(),e.getquestion9(),e.getquestion10(),e.getEmployee()));
			
		}
		
		return listofev;
	}

	@Override
	public boolean create(EvaluationModel model ) {
		Evaluation eval = new Evaluation(model.getId(), model.getName(), model.getFill_date(),
				model.getQuestion1(), model.getQuestion2(), model.getQuestion3(), model.getQuestion4(),
				model.getQuestion5(), model.getQuestion6(), model.getQuestion7(), model.getQuestion8(),
				model.getQuestion9(), model.getQuestion10(), model.getEmployee());
		evalserv.create(eval);
		return false;
	}

	@Override
	public EvaluationModel read(Long id) {
		Evaluation evaluation = evalserv.read(id);
		return (new EvaluationModel(evaluation.getId(), evaluation.getName(), evaluation.getFill_date(),
				evaluation.getquestion1(), evaluation.getquestion2(), evaluation.getquestion3(), 
				evaluation.getquestion4(), evaluation.getquestion5(), evaluation.getquestion6(),
				evaluation.getquestion7(), evaluation.getquestion8(), evaluation.getquestion9(),
				evaluation.getquestion10(), evaluation.getEmployee()));
	}

	@Override
	public List<EvaluationModel> readAll() {
		List<EvaluationModel> listofev = new ArrayList<EvaluationModel>();
		for(Evaluation e : evalserv.readAll())
		{
			listofev.add(new EvaluationModel(e.getId(),e.getName(),e.getFill_date(),e.getquestion1(),
					e.getquestion2(),e.getquestion3(),e.getquestion4(),e.getquestion5(),e.getquestion6(),
					e.getquestion7(),e.getquestion8(),e.getquestion9(),e.getquestion10(),e.getEmployee()));			
		}
		
		return listofev;
	}

}
