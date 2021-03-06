package eu.unicorneducation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.swing.BranchTreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.unicorneducation.dao.BranchDAO;
import eu.unicorneducation.entity.Branch;
import eu.unicorneducation.model.BranchTreeModel;
import eu.unicorneducation.service.BranchService;

@Component
public class BranchServiceImpl implements BranchService {

	@Autowired
	private BranchDAO branchDAO;

	@Override
	public List<Branch> readAll() {
		return branchDAO.readAll();

	}

	@Override
	public Branch read(String id) {

		return branchDAO.read(id);
	}

	@Override
	public Branch readByName(String name) {

		return branchDAO.readByName(name);
	}

	@Override
	public List<BranchTreeModel> readStructure() {
		List<Branch> orderedBranches = branchDAO.readAllOrderByPerrent(); 
		List<BranchTreeModel> treeStructure = new ArrayList<>();

		for (Branch branch : orderedBranches) {

			if (branch.getParrentBranch() == null) {
				treeStructure.add(new BranchTreeModel(branch));
			}
		}

		int numberOfBranches = orderedBranches.size();
		while (numberOfBranches > 0) {
			for (Branch branch : orderedBranches) {
				if (branch.getParrentBranch() == null) {
					numberOfBranches--;
					continue;
				}
				BranchTreeModel node;
				for (int j = 0; j < treeStructure.size(); j++) {
					if ((node = findNode(treeStructure.get(j), branch)) != null) {
						numberOfBranches--;
						node.addChildren(branch);
						break;
					}
				}

			}
		}
		
		
		
		return treeStructure;
	}
/**
 * Method for finding specific Node in tree structure
 * @param node BranchTreeModel(Node of tree)
 * @param keyNode Node that we are looking for
 * @return Node that we are looking for
 */
	private BranchTreeModel findNode(BranchTreeModel node, Branch keyNode) {
		if (node == null)
			return null;
		if (node.getThisBranch().getId()
				.equalsIgnoreCase(keyNode.getParrentBranch()))
			return node;
		else {
			BranchTreeModel cnode = null;
			for (BranchTreeModel child : node.getChildrens())
				if ((cnode = findNode(child, keyNode)) != null)
					return cnode;
		}
		return null;
	}


	@Override
	public String readStructureById(String id) {
			Branch branch = branchDAO.read(id);
		String output = "Pobo�ky:  ";
		while(branch.getParrentBranch()!=null){
			
			
			output += branch.getName();
			branch=branchDAO.read(branch.getParrentBranch());
			output += " <- ";
		}
		
		output += branch.getName();
		return output;
	}
}
