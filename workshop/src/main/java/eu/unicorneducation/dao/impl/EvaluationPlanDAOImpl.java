package eu.unicorneducation.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import eu.unicorneducation.dao.EvaluationPlanDAO;
import eu.unicorneducation.entity.Employee;
import eu.unicorneducation.entity.EvaluationPlan;
@Component
public class EvaluationPlanDAOImpl implements EvaluationPlanDAO {

	private EntityManager em;

	public EvaluationPlanDAOImpl() {
		em = Persistence.createEntityManagerFactory("workshop")
				.createEntityManager();
	}

	public boolean create(EvaluationPlan evaluationPlan) {
		em.getTransaction().begin();
		em.persist(evaluationPlan);
		em.getTransaction().commit();

		em.getTransaction().begin();
		for (Employee empl : evaluationPlan.getEmployees()) {
			// Employee employee = employeeDAO.read(empl.getId());
			Employee employee = (Employee) em
					.find(Employee.class, empl.getId());

			employee.setPlan(evaluationPlan);
		}
		em.getTransaction().commit();
		return true;
	}

	public EvaluationPlan read(Long id) {
		return em.find(EvaluationPlan.class, id);
	}

	public boolean update(EvaluationPlan evaluationPlan) {
		EvaluationPlan plan = read(evaluationPlan.getId());

		if (plan != null) {
			em.getTransaction().begin();
			em.merge(plan);
			em.getTransaction().commit();
			return true;
		}
		return false;
	}

	public boolean delete(EvaluationPlan evaluationPlan) {
		EvaluationPlan plan = read(evaluationPlan.getId());		

		if (plan != null) {
			em.getTransaction().begin();
			em.remove(plan);
			em.getTransaction().commit();
			return true;
		}
		return false;
	}

	public List<EvaluationPlan> readAll() {
		return em.createQuery("SELECT e FROM EvaluationPlan e ORDER BY e.date",
				EvaluationPlan.class).getResultList();
	}

	public List<EvaluationPlan> readAllBeforeDate() {
		return em
				.createQuery(
						"SELECT e FROM EvaluationPlan e  WHERE trunc(e.expiration) >= trunc(sysdate) AND e.completed=0 ORDER BY e.expiration",
						EvaluationPlan.class).getResultList();         
	}

	public List<EvaluationPlan> readAllAfterDate() {
		return em
				.createQuery(
						"SELECT e FROM EvaluationPlan e  WHERE trunc(e.expiration) < trunc(sysdate) AND e.completed=0 ORDER BY e.expiration",
						EvaluationPlan.class).getResultList();
	}

	@Override
	public List<EvaluationPlan> readAllCompleted() {
		
		return em
				.createQuery(
						"SELECT e FROM EvaluationPlan e  WHERE e.completed=1 ORDER BY e.expiration",
						EvaluationPlan.class).getResultList();
	}

	@Override
	public boolean setCompleted(Long id) {
		em.getTransaction().begin();
		EvaluationPlan e = read(id);
		e.setCompleted(true);
		em.getTransaction().commit();
		return true;
	}
	
	

}
