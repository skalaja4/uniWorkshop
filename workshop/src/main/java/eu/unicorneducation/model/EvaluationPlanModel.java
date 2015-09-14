package eu.unicorneducation.model;

import java.util.Date;
import java.util.List;

public class EvaluationPlanModel {

	private Long id;
	private String name;
	private Date expiration;
	private BranchModel branch;
	private List<EmployeeModel> employees;
	private boolean completed;
		
	
	public EvaluationPlanModel(Long id, String name, Date expiration,
			BranchModel branch, List<EmployeeModel> employees, boolean completed) {
		super();
		this.id = id;
		this.name = name;
		this.expiration = expiration;
		this.branch = branch;
		this.employees = employees;
		this.completed = completed;
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
	public BranchModel getBranch() {
		return branch;
	}
	public void setBranch(BranchModel branch) {
		this.branch = branch;
	}
	public List<EmployeeModel> getEmployees() {
		return employees;
	}
	public void setEmployees(List<EmployeeModel> employees) {
		this.employees = employees;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}	
	
}
