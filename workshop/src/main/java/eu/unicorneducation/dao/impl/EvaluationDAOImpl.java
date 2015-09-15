package eu.unicorneducation.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import eu.unicorneducation.dao.EvaluationDAO;
import eu.unicorneducation.entity.Employee;
import eu.unicorneducation.entity.Evaluation;
@Component
public class EvaluationDAOImpl implements EvaluationDAO {
	private EntityManager em;

	
	/**
	 * @inheritDoc
	 */
	
	public EvaluationDAOImpl() {
		em = Persistence.createEntityManagerFactory("workshop").createEntityManager();
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public boolean create(Evaluation evaluation) {
		em.getTransaction().begin();
		em.persist(evaluation);
		em.getTransaction().commit();
		return true;
	}

	@Override
	public Evaluation read(Long id) {
		return em.find(Evaluation.class, id);
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public boolean delete(Evaluation evaluation) {
		em.getTransaction().begin();
		em.remove(evaluation);
		em.getTransaction().commit();
		return true;
	}

	
	/**
	 * @inheritDoc
	 */
	@Override
	public List readAll() {
		return em.createQuery("select e from Employee e", Employee.class).getResultList();
		
	}
	
	
	/**
	 * @inheritDoc
	 */
	@Override
	public List<Evaluation> getEvaluations(String empID) {
		
		return em.createQuery("select e from Evaluation e  where employee_id=:emplid ", Evaluation.class)
				.setParameter("emplid", empID).getResultList();
	}
}
