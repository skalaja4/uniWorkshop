package eu.unicorneducation.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import eu.unicorneducation.dao.InicializationDAO;
import eu.unicorneducation.entity.Branch;
import eu.unicorneducation.entity.Employee;

@Component
public class InicializationDAOImpl implements InicializationDAO {

	private EntityManager entityManager;
	
	public InicializationDAOImpl() {
		entityManager = Persistence.createEntityManagerFactory("workshop").createEntityManager();
	}
	
	public void inicializateBranches(List<Branch> branches) {
		// TODO Auto-generated method stub
		
	}

	public void inicializateEmployees(List<Employee> employees) {
		// TODO Auto-generated method stub
		
	}


}
