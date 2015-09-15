package eu.unicorneducation.facade;

import java.util.List;

import eu.unicorneducation.model.BranchModel;
import eu.unicorneducation.model.BranchTreeModel;

public interface BranchFacade {
	
	/**
	 * Read all Branches from database and transfer them to BranchModel
	 * @return List of BranchModel
	 */
	public List<BranchModel> readAll();
	/**
	 * Read exact Branch given by id and transfer it to BranchModel
	 * @param id Id of Branch
	 * @return BranchModel we read
	 */
	public BranchModel read(String id);
	/**
	 * Read exact Branch given by name and transfer it to BranchModel
	 * @param name Name of Branch
	 * @return BranchModel we read
	 */
	public BranchModel readByName(String name);
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

