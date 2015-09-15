package eu.unicorneducation.dao;

import java.util.List;

import eu.unicorneducation.entity.Branch;
import eu.unicorneducation.entity.Employee;

/**
 * Interface representing DAO layer for Branch.
 * @author Jaroslav Skala
 *
 */
public interface BranchDAO {
	
	
	/**
	 * Creates branch in database
	 * 
	 * @return True if creation was successfull
	 *
	 */
	public boolean create(Branch branch);
	
	
	/**
	 * Creates branches got from parameter
	 * 
	 * @return True if creation was successfull
	 *
	 */
	public boolean createAll(List<Branch> branches);
	
	/**
	 * Gets branch by ID
	 *
	 * @param id ID of branch which is needed
	 * @return Evaluation by ID 
	 */
	public Branch read(String id);
	
	
	/**
	 * Removes branch from database
	 *
	 * @param branch Branch which needs to be deleted
	 * @return True if deletion was successfully done 
	 */
	public boolean delete(Branch branch);
	
	/**
	 * Gets all branches from database
	 *
	 * @return List of all branches
	 */
	public List<Branch> readAll();
	
	/**
	 * Modify exact Branch
	 * @param branch Id of Branch we want to modify
	 */
	public void modify(Branch branch);
	
	/**
	 * Gets branch  from database by name
	 *
	 * @return Branch 
	 * @param name Name of branch
	 */
	public Branch readByName(String name);
	
	/**
	 * Gets all Branches and order them by their parent
	 * @return
	 */
	public List<Branch> readAllOrderByPerrent();
	
	
}
