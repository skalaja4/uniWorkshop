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
		em = Persistence.createEntityManagerFactory("workshop").createEntityManager();
	}

	public boolean create(EvaluationPlan evaluationPlan) {
		em.getTransaction().begin();
		em.persist(evaluationPlan);
		em.getTransaction().commit();
		em.getTransaction().begin();
		for(Employee empl:evaluationPlan.getEmployees()){
			//Employee employee = employeeDAO.read(empl.getId());
			Employee employee = (Employee) em.find(Employee.class, empl.getId());
		
			employee.setPlan(evaluationPlan);
		}
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
