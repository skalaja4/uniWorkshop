package eu.unicorneducation.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;






import org.springframework.stereotype.Component;

import eu.unicorneducation.dao.EmployeeDAO;
import eu.unicorneducation.entity.Employee;
import eu.unicorneducation.entity.Evaluation;
import eu.unicorneducation.enumeration.Category;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManager em;

	public EmployeeDAOImpl() {
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
		return em.createQuery("select e from Employee e", Employee.class).getResultList();

	}

	@Override
	public boolean createAll(List<Employee> employees) {
		em.getTransaction().begin();

		for (Employee employee : employees) {
			em.persist(employee);
		}

		em.getTransaction().commit();
		return true;
	}

	@Override
	public List<Employee> readByBranchAndCategory(String branch, String category) {
		return em
				.createQuery(
						"select e from Employee e left join e.branch b where b.id=:branchName and e.category=:categoryName and e.plan is null and e.category<>:notManager",
						Employee.class)
				.setParameter("branchName", branch).setParameter("categoryName", Category.valueOf(category))
				.setParameter("notManager", Category.MANAGER).getResultList();

	}

	@Override
	public List<Employee> readByBranchWithoutCategory(String branch, String category) {
		return em
				.createQuery(
						"select e from Employee e left join e.branch b where b.id=:branchName and e.category<>:categoryName and e.plan is null and e.category<>:notManager",
						Employee.class)
				.setParameter("branchName", branch).setParameter("categoryName", Category.valueOf(category))
				.setParameter("notManager", Category.MANAGER).getResultList();
	}

	@Override
	public List<Employee> readByBranch(String branch) {
		return em
				.createQuery(
						"select e from Employee e left join e.branch b where b.id=:branchName and e.plan is null and e.category<>:notManager",
						Employee.class)
				.setParameter("branchName", branch).setParameter("notManager", Category.MANAGER).getResultList();

	}

	@Override
	public List<Employee> readByIds(String[] employeeIds) {
		List<Employee> list = new ArrayList<>();
		for (String employeeId : employeeIds) {
			list.add(em.createQuery("select e from Employee e where e.id=:idOfEmployee", Employee.class)
					.setParameter("idOfEmployee", employeeId).getResultList().get(0));
		}
		return  list;
	}

	@Override
	public Employee readByID(String employeeId) {
		return em.createQuery("select e from Employee e  where e.id=:empid ", Employee.class).setParameter("empid", employeeId).getSingleResult();
	}

	@Override
	public List<Employee> readByLastName(String lastname, String branchid) {
		
		return em.createQuery("select e from Employee e  where lastname=:last or firstname=:last and branch_id=:branch ",
						Employee.class).setParameter("last", lastname).setParameter("branch", branchid).getResultList();
	}

	
	
	
	

}

	
	
