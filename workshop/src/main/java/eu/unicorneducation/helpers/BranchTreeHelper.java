package eu.unicorneducation.helpers;

import eu.unicorneducation.entity.Branch;
import eu.unicorneducation.model.BranchTreeModel;


public class BranchTreeHelper {
	public static String getTreeForBranch(String html,BranchTreeModel branchTreeModel){
		html += "<li>";
		html += "<ul>";
		html +="<a href=\"/workshop/employees?branchid="+branchTreeModel.getThisBranch().getId()+"\">";
		html += branchTreeModel.getThisBranch().getName();
		html +="</a>";
		
		
		if(branchTreeModel.getChildrens().size() > 0){
			for(BranchTreeModel sBranch : branchTreeModel.getChildrens()){
				html = getTreeForBranch(html, sBranch);
			}
		}
		
		html += "</ul>";
		html += "</li>";
		return html;
	}
}
