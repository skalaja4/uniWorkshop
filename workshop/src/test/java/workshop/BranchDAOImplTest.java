package workshop;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import eu.unicorneducation.dao.BranchDAO;
import eu.unicorneducation.dao.impl.BranchDAOImpl;
import eu.unicorneducation.entity.Branch;

public class BranchDAOImplTest {
	
	@Autowired
	BranchDAO branchDAO;

	@Test
	public void testCreate() {
		Branch branch = new Branch("BB_BRANCH_001", "Èeská národní banka", "Na Pøíkopì 28, 115 03 Praha 1", "");
		
		branchDAO.create(branch);
		Assert.assertEquals("", ,);
	}

}
