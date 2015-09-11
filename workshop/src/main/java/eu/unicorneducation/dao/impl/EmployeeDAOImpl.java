package eu.unicorneducation.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import eu.unicorneducation.dao.EmployeeDAO;
import eu.unicorneducation.entity.Branch;
import eu.unicorneducation.entity.Employee;
@Component
public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManager em;
	
	public EmployeeDAOImpl(){
		em = Persistence.createEntityManagerFactory("workshop").createEntityManager();
	}
	public boolean create(Employee employee) {
		em.getTransaction().begin();
		em.persist(employee);
		em.getTransaction().commit();
		return true;
	}

	public Employee read(String id) {
		
		return em.find(Employee.class, id);
		
	}

	public boolean delete(Employee employee) {
		em.getTransaction().begin();
		em.remove(employee);
		em.getTransaction().commit();
		return true;
	}

	public List<Employee> readAll() {
		return em.createQuery("SELECT * FROM Employee",Employee.class).getResultList();


	}

}
