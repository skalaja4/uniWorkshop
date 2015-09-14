package eu.unicorneducation.model;

import java.util.Date;
import java.util.List;

import eu.unicorneducation.enumeration.Category;

public class EmployeeModel {
	
	private String id;
	
	private String  firstName ;
	
	private String lastName;
	
	private Date birthDate;
	
	private EvaluationPlanModel plan;
	
	private List<EvaluationModel> evaluation;
	
	private BranchModel branch;
	
	private Category category;
	
	
	
	public EmployeeModel() {
		super();
	}


	public EmployeeModel(String id, String firstName, String lastName,
			Date birthDate, EvaluationPlanModel plan,
			List<EvaluationModel> evaluation, BranchModel branch,
			Category category) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.plan = plan;
		this.evaluation = evaluation;
		this.branch = branch;
		this.category = category;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}	

	public EvaluationPlanModel getPlan() {
		return plan;
	}

	public void setPlan(EvaluationPlanModel plan) {
		this.plan = plan;
	}

	public List<EvaluationModel> getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(List<EvaluationModel> evaluation) {
		this.evaluation = evaluation;
	}

	public BranchModel getBranch() {
		return branch;
	}

	public void setBranch(BranchModel branch) {
		this.branch = branch;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
