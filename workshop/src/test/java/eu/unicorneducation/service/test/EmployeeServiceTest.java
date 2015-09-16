package eu.unicorneducation.service.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eu.unicorneducation.dao.BranchDAO;
import eu.unicorneducation.dao.EmployeeDAO;
import eu.unicorneducation.entity.Branch;
import eu.unicorneducation.entity.Employee;
import eu.unicorneducation.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans-test.xml")
public class EmployeeServiceTest {
	
	@Autowired
	BranchDAO branchDAO;
	@Autowired
	EmployeeService emplserv;
	
	@Before
	public void beforeTest(){
		
		Branch branch = new Branch("BranchTest2","Test","Testaddress",null);
		branchDAO.create(branch);
		
	}
	
	

		@Test
		public void readBranchandCategoryTest() {		
			
			Branch branch = branchDAO.read("BranchTest2");
			List<Employee> list = new ArrayList<>();
			list.add(new Employee("EMP_Test","name","lname",branch,Calendar.getInstance().getTime(),eu.unicorneducation.enumeration.Category.NEW));
			
			Assert.assertEquals(list.get(0).getCategory(), emplserv
					.readByBranchAndCategory("BB_BRANCH_1", "NEW").get(0).getCategory());
			
			
			branchDAO.delete(branch);
			

		}

}
