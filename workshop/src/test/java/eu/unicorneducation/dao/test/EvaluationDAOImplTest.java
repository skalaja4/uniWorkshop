package eu.unicorneducation.dao.test;

import java.util.Calendar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eu.unicorneducation.dao.BranchDAO;
import eu.unicorneducation.dao.EmployeeDAO;
import eu.unicorneducation.dao.EvaluationDAO;
import eu.unicorneducation.entity.Branch;
import eu.unicorneducation.entity.Employee;
import eu.unicorneducation.entity.Evaluation;
import eu.unicorneducation.enumeration.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans-test.xml")
public class EvaluationDAOImplTest {

	@Autowired
	EvaluationDAO evalDao;

	@Autowired
	EmployeeDAO empDao;
	
	@Autowired
	BranchDAO branchDao;

	@Before
	public void beforeTest() {

		Branch branch = new Branch("BRA_TEST", "name", "address", null);
		branchDao.create(branch);
		
		Employee emp = new Employee("EMP_TEST", "name", "surname", branch, Calendar.getInstance().getTime(), Category.NEW);
		empDao.create(emp);
	}

	@Test
	public void createDeleteTest() {
		
		Employee emp = empDao.read("EMP_TEST");
		Evaluation e1 = new Evaluation(null, "name", Calendar.getInstance().getTime(), 1, 1, 1, 1, 1, 1, 1, 1, 1, "bla", emp);
		
		evalDao.create(e1);
		
		Assert.assertEquals(e1, evalDao.getEvaluations("EMP_TEST").get(0));
		
		evalDao.delete(e1);
		
		Assert.assertEquals(true, evalDao.getEvaluations("EMP_TEST").isEmpty());
	}
	
	@After
	public void afterTest() {
		Employee emp = empDao.read("EMP_TEST");
		empDao.delete(emp);
		
		Branch branch = branchDao.read("BRA_TEST");
		branchDao.delete(branch);
	}
	
}
