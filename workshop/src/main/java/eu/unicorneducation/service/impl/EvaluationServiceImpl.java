package eu.unicorneducation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.unicorneducation.dao.EvaluationDAO;
import eu.unicorneducation.entity.Evaluation;
import eu.unicorneducation.service.EvaluationService;
@Component
public class EvaluationServiceImpl implements EvaluationService{
	
	@Autowired
	private EvaluationDAO evalDao;
	
	
	@Override
	public List<Evaluation> getEvaluations(String empID) {
		
		return evalDao.getEvaluations(empID);
	}

}
