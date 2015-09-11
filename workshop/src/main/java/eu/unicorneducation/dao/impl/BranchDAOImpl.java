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

	public boolean updeat(Branch branch) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Branch branch) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Branch> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
