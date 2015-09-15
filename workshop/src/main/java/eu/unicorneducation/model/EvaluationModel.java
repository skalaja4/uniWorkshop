package eu.unicorneducation.model;

import java.util.Date;

import eu.unicorneducation.entity.Employee;

/**
 * Data Transfer Object of Evaluation.
 *
 */
public class EvaluationModel {

	private Long id;
	private String name;
	private Date fill_date;
	private int question1;
	private int question2;
	private int question3;
	private int question4;
	private int question5;
	private int question6;
	private int question7;
	private int question8;
	private int question9;
	private String question10;
	private Employee employee;
	
	
	
	public EvaluationModel(Long id, String name, Date fill_date, int question1,
			int question2, int question3, int question4, int question5,
			int question6, int question7, int question8, int question9,
			String question10,Employee empl) {
		super();
		this.id = id;
		this.name = name;
		this.fill_date = fill_date;
		this.question1 = question1;
		this.question2 = question2;
		this.question3 = question3;
		this.question4 = question4;
		this.question5 = question5;
		this.question6 = question6;
		this.question7 = question7;
		this.question8 = question8;
		this.question9 = question9;
		this.question10 = question10;
		this.employee = empl;
	}
	
	public EvaluationModel(String name, Date fill_date, int question1, int question2, int question3, int question4,
			int question5, int question6, int question7, int question8, int question9, String question10,
			Employee employee) {
		super();
		this.name = name;
		this.fill_date = fill_date;
		this.question1 = question1;
		this.question2 = question2;
		this.question3 = question3;
		this.question4 = question4;
		this.question5 = question5;
		this.question6 = question6;
		this.question7 = question7;
		this.question8 = question8;
		this.question9 = question9;
		this.question10 = question10;
		this.employee = employee;
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
	public Date getFill_date() {
		return fill_date;
	}
	public void setFill_date(Date fill_date) {
		this.fill_date = fill_date;
	}
	public int getQuestion1() {
		return question1;
	}
	public void setQuestion1(int question1) {
		this.question1 = question1;
	}
	public int getQuestion2() {
		return question2;
	}
	public void setQuestion2(int question2) {
		this.question2 = question2;
	}
	public int getQuestion3() {
		return question3;
	}
	public void setQuestion3(int question3) {
		this.question3 = question3;
	}
	public int getQuestion4() {
		return question4;
	}
	public void setQuestion4(int question4) {
		this.question4 = question4;
	}
	public int getQuestion5() {
		return question5;
	}
	public void setQuestion5(int question5) {
		this.question5 = question5;
	}
	public int getQuestion6() {
		return question6;
	}
	public void setQuestion6(int question6) {
		this.question6 = question6;
	}
	public int getQuestion7() {
		return question7;
	}
	public void setQuestion7(int question7) {
		this.question7 = question7;
	}
	public int getQuestion8() {
		return question8;
	}
	public void setQuestion8(int question8) {
		this.question8 = question8;
	}
	public int getQuestion9() {
		return question9;
	}
	public void setQuestion9(int question9) {
		this.question9 = question9;
	}
	public String getQuestion10() {
		return question10;
	}
	public void setQuestion10(String question10) {
		this.question10 = question10;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
	
}
