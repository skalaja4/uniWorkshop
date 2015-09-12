package eu.unicorneducation.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import eu.unicorneducation.dao.EvaluationPlanDAO;
import eu.unicorneducation.entity.Evaluation;
import eu.unicorneducation.entity.EvaluationPlan;

public class EvaluationPlanDAOImpl implements EvaluationPlanDAO {

	private EntityManager em;

	public EvaluationPlanDAOImpl() {
		em = Persistence.createEntityManagerFactory("workshop").createEntityManager();
	}

	public boolean create(EvaluationPlan evaluationPlan) {
		em.getTransaction().begin();
		em.persist(evaluationPlan);
		em.getTransaction().commit();
		return true;
	}

	public EvaluationPlan read(Long id) {
		
		return em.find(EvaluationPlan.class, id);
	}

	public boolean delete(EvaluationPlan evaluationPlan) {
		em.getTransaction().begin();
		em.remove(evaluationPlan);
		em.getTransaction().commit();
		return true;
	}

	public List<EvaluationPlan> readAll() {
		return em.createQuery("SELECT e FROM EvaluationPlan e",EvaluationPlan.class).getResultList();
	}

}
