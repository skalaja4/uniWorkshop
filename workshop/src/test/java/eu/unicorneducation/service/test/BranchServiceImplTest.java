package eu.unicorneducation.service.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eu.unicorneducation.model.BranchTreeModel;
import eu.unicorneducation.service.BranchService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans-test.xml")
public class BranchServiceImplTest {
	@Autowired
	BranchService branchService;
	
	@Test
	public void readStructureTest(){
		List<BranchTreeModel> listOfParrents = branchService.readStructure();
		
		if(!listOfParrents.get(0).equals(null)){
			BranchTreeModel btm = listOfParrents.get(0);
			List<BranchTreeModel> listOfChildrens = btm.getChildrens();
			if(!listOfChildrens.get(0).equals(null)){
				Assert.assertEquals(btm.getThisBranch().getId(),listOfChildrens.get(0).getThisBranch().getParrentBranch());
			}
			
		}
		Assert.assertTrue(true);
		
	}
	
}
