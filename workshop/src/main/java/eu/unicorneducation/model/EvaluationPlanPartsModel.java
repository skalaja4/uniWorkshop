
package eu.unicorneducation.model;

import java.util.Date;
import java.util.List;

/**
 * Data Transfer Object of Evaluation Plan containing only necessary parts.
 *
 */
public class EvaluationPlanPartsModel {

	private Long id;
	private String name;
	private Date expiration;
	private String branchName;
	List<String> employeeID;
	List<String> employeeFirstName;
	List<String> employeeLastName;
	
	
	public EvaluationPlanPartsModel(Long id, String name, Date expiration,
			List<String> employeeID, List<String> employeeFirstName,
			List<String> employeeLastName,String branchName) {
		super();
		this.id = id;
		this.name = name;
		this.expiration = expiration;
		this.employeeID = employeeID;
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.branchName=branchName;
	}
	
	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getExpiration() {
		return expiration;
	}
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}
	public List<String> getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(List<String> employeeID) {
		this.employeeID = employeeID;
	}
	public List<String> getEmployeeFirstName() {
		return employeeFirstName;
	}
	public void setEmployeeFirstName(List<String> employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}
	public List<String> getEmployeeLastName() {
		return employeeLastName;
	}
	public void setEmployeeLastName(List<String> employeeLastName) {
		this.employeeLastName = employeeLastName;
	}
	
}
