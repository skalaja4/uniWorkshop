package eu.unicorneducation.model;

import java.util.Date;
import java.util.List;

import eu.unicorneducation.entity.Branch;
import eu.unicorneducation.entity.Evaluation;
import eu.unicorneducation.entity.EvaluationPlan;
import eu.unicorneducation.enumeration.Category;

/**
 * Data Transfer Object of Employee.
 *
 */
public class EmployeeModel {
	
	private String id;
	private String  firstName ;
	private String lastName;
	private Date birthDate;
	private EvaluationPlan plan;
	private List<Evaluation> evaluation;
	private Branch branch;
	private Category category;
	
	
	
	public EmployeeModel() {
		super();
	}

	public EmployeeModel(String id, String firstName, String lastName,
			Date birthDate, EvaluationPlan plan, List<Evaluation> evaluation,
			Branch branch, Category category) {
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

	public EvaluationPlan getPlan() {
		return plan;
	}

	public void setPlan(EvaluationPlan plan) {
		this.plan = plan;
	}

	public List<Evaluation> getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(List<Evaluation> evaluation) {
		this.evaluation = evaluation;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
