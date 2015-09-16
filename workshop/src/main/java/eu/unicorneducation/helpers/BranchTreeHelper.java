package eu.unicorneducation.helpers;

import eu.unicorneducation.model.BranchTreeModel;

/**
 * Class for generating tree structure.
 *
 */
public class BranchTreeHelper {
	
	/**
	 * Method generating tree structure.
	 * @param html string from page
	 * @param branchTreeModel model of branches
	 * @return html tree branch model
	 */
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
