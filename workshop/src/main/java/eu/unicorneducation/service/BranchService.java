package eu.unicorneducation.service;

import java.util.List;

import eu.unicorneducation.entity.Branch;
import eu.unicorneducation.model.BranchTreeModel;

public interface BranchService {
	List<Branch> readAll();
	Branch read(String id);
	Branch readByName(String name);
	List<BranchTreeModel> readStructure();
	String readStructureById(String id);
	
}
