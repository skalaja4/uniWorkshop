package eu.unicorneducation.dao.test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eu.unicorneducation.dao.BranchDAO;
import eu.unicorneducation.dao.impl.BranchDAOImpl;
import eu.unicorneducation.entity.Branch;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans-test.xml")
public class BranchDAOImplTest {
	
	@Autowired
	BranchDAO branchDAO;

	@Test
	public void testCreateReadDelete() {
		Branch branch = new Branch("BB_BRANCH_999", "Èeská národní banka", "Na Pøíkopì 28, 115 03 Praha 1","");
		branchDAO.create(branch);
		Branch db = branchDAO.read("BB_BRANCH_999");
		
		Assert.assertEquals("Nestejna jmena!",branch.getName(),db.getName());
		Assert.assertEquals("Nestejne adresy!",branch.getAddress(),db.getAddress());
		
		branchDAO.delete(db);
	}

}
