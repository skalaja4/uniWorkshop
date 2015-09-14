package eu.unicorneducation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import eu.unicorneducation.dao.EvaluationDAO;
import eu.unicorneducation.entity.Evaluation;

public class EvaluationServiceImpl implements eu.unicorneducation.service.EvaluationService{

	@Autowired
	private EvaluationDAO evalDao;
	
	@Override
	public boolean create(Evaluation evaluation) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Evaluation read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Evaluation evaluation) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Evaluation> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Evaluation> getEvaluations(String empID) {
		
		return evalDao.getEvaluations(empID);
	}

}
