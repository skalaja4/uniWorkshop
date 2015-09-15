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

	@Override
	public boolean create(Evaluation evaluation) {
		return evalDao.create(evaluation);
	}

	@Override
	public Evaluation read(Long id) {
		return evalDao.read(id);
	}

	@Override
	public boolean delete(Evaluation evaluation) {
		return evalDao.delete(evaluation);
	}

	@Override
	public List<Evaluation> readAll() {
		return evalDao.readAll();
	}
	

}
