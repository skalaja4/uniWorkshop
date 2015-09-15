package eu.unicorneducation.facade;

import java.text.DateFormat;


import java.util.List;

import eu.unicorneducation.model.BranchModel;
import eu.unicorneducation.model.BranchTreeModel;

public interface BranchFacade {
	

	List<BranchModel> readAll();
	BranchModel read(String id);
	BranchModel readByName(String name);
	List<BranchTreeModel> readStructure();
	String readStructureById(String id);
}

