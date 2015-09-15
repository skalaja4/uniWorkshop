package eu.unicorneducation.model;

import java.util.Date;
import java.util.List;

import eu.unicorneducation.enumeration.Category;

/**
 * Data Transfer Object of Employee for REST.
 *
 */
public class EmployeeRESTModel {

	private String id;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String evaluationPlan;
	private List<EvaluationRESTModel> evaluation;
	private String branchId;
	private Category category;

	public EmployeeRESTModel() {
		super();
	}

	public EmployeeRESTModel(String id, String firstName, String lastName,
			Date birthDate, String plan,
			List<EvaluationRESTModel> evaluation, String branchId,
			Category category) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.evaluationPlan = plan;
		this.evaluation = evaluation;
		this.branchId = branchId;
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

	public String getPlan() {
		return evaluationPlan;
	}

	public void setPlan(String plan) {
		this.evaluationPlan = plan;
	}

	public List<EvaluationRESTModel> getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(List<EvaluationRESTModel> evaluation) {
		this.evaluation = evaluation;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
