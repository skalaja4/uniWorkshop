package eu.unicorneducation.service;

import java.util.List;

import eu.unicorneducation.entity.Branch;
import eu.unicorneducation.model.BranchTreeModel;

public interface BranchService {
	/**
	 * Read all Branches from database
	 * @return List of Branch
	 */
	public List<Branch> readAll();
	/**
	 * Gets branch by ID
	 *
	 * @param id ID of branch which is needed
	 * @return Evaluation by ID 
	 */
	public Branch read(String id);
	/**
	 * Gets branch  from database by name
	 *
	 * @return Branch 
	 * @param name Name of branch
	 */
	public Branch readByName(String name);
	
	/**
	 * Read Tree model of branch hierarchy. 
	 * @return List of trees that represents hierarchy of branches
	 */
	public List<BranchTreeModel> readStructure();
	
	/**
	 * Read all branch parents of exact branch given by id.  
	 * @param id Id of branch.
	 * @return String that represents ordered names of all parents.
	 */
	public String readStructureById(String id);
	
}
