package eu.unicorneducation.dao;

import java.util.List;

import eu.unicorneducation.entity.Branch;
import eu.unicorneducation.entity.Employee;

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
	
	
	public void modify(Branch branch);
	
	/**
	 * Gets branch  from database by name
	 *
	 * @return Branch 
	 * @param name Name of branch
	 */
	public Branch readByName(String name);
	
	
	public List<Branch> readAllOrderByPerrent();
	
	
}
