package eu.unicorneducation.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import eu.unicorneducation.dao.EvaluationDAO;
import eu.unicorneducation.entity.Employee;
import eu.unicorneducation.entity.Evaluation;

public class EvaluationDAOImpl implements EvaluationDAO {
	private EntityManager em;

	public EvaluationDAOImpl() {
		em = Persistence.createEntityManagerFactory("workshop")
				.createEntityManager();
	}

	public boolean create(Evaluation evaluation) {
		em.getTransaction().begin();
		em.persist(evaluation);
		em.getTransaction().commit();
		return true;
	}

	public Evaluation read(Long id) {
		return em.find(Evaluation.class, id);
	}

	public boolean delete(Evaluation evaluation) {
		em.getTransaction().begin();
		em.remove(evaluation);
		em.getTransaction().commit();
		return true;
	}

	public List<Evaluation> readAll() {
		return em.createQuery("SELECT e FROM Evaluation e",Evaluation.class).getResultList();
	}
}
