package eu.unicorneducation.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import eu.unicorneducation.entity.Branch;

public class BranchTreeModel {

	private BranchTreeModel parrent;
	private Branch thisBranch;
	private List<BranchTreeModel> childrens;
	
	public BranchTreeModel(Branch thisBranch) {
		super();
		this.thisBranch=thisBranch;
		childrens = new ArrayList<>();
	}
	
	
	public Branch getThisBranch() {
		return thisBranch;
	}
	public void setThisBranch(Branch thisBranch) {
		this.thisBranch = thisBranch;
	}
	
	public void addChildren(Branch branch){
		for (BranchTreeModel branchTreeModel : childrens) {
			if(branchTreeModel.getThisBranch().getId().equalsIgnoreCase(branch.getId())){
				return;
			}
		}
		childrens.add(new BranchTreeModel(branch));
	}


	public BranchTreeModel getParrent() {
		return parrent;
	}


	public void setParrent(BranchTreeModel parrent) {
		this.parrent = parrent;
	}


	public List<BranchTreeModel> getChildrens() {
		return childrens;
	}


	public void setChildrens(List<BranchTreeModel> childrens) {
		this.childrens = childrens;
	}
	public void printChildrens(int cislo){
		for(BranchTreeModel models:childrens){
			models.printChildrens(cislo++);
		}
		System.out.println(thisBranch.getName());
	}
	
	
}
