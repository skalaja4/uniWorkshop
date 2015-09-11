package eu.unicorneducation.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import eu.unicorneducation.dao.BranchDAO;
import eu.unicorneducation.entity.Branch;

@Component
public class BranchDAOImpl implements BranchDAO{
	private EntityManager em;
	
	public BranchDAOImpl(){
		em = Persistence.createEntityManagerFactory("workshop").createEntityManager();
	}
	public boolean create(Branch branch) {
		em.getTransaction().begin();
		em.persist(branch);
		em.getTransaction().commit();
		return true;
	}

	public Branch read(String id) {
		return em.find(Branch.class, id);
	}
	

	public boolean delete(Branch branch) {
		em.getTransaction().begin();
		em.remove(branch);
		em.getTransaction().commit();
		return true;
	}

	public List<Branch> readAll() {
		 return em.createQuery("SELECT b FROM Branch b",Branch.class).getResultList();
	}

}
