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
					e.getquestion7(),e.getquestion8(),e.getquestion9(),e.getquestion10()));
			
		}
		
		return listofev;
	}

}
