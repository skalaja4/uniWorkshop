package eu.unicorneducation.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import eu.unicorneducation.dao.BranchDAO;
import eu.unicorneducation.entity.Branch;
import eu.unicorneducation.entity.Employee;

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
	
	@Override
	public boolean createAll(List<Branch> branches) {
		em.getTransaction().begin();
		
		for(Branch branch : branches) {
			em.persist(branch);
		}
		
		em.getTransaction().commit();
		return true;
	}
	@Override
	public void modify(Branch branch) {
		em.getTransaction().begin();
		em.merge(branch);
		em.getTransaction().commit();
	}
	@Override
	public Branch readByName(String name) {
		return em.createQuery("SELECT b FROM Branch b where b.id=:name",Branch.class).setParameter("name", name).getResultList().get(0);
		
	}
	@Override
	public List<Branch> readAllOrderByPerrent() {
		 return em.createQuery("SELECT b FROM Branch b ORDER BY parrentbranch",Branch.class).getResultList();
		
	}
	
	

}
