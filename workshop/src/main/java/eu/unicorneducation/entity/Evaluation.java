package eu.unicorneducation.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Class representing evaluation for a employee.
 *
 */
@Entity
@Table(name="EVALUATION")
public class Evaluation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQUENCE1")
	@SequenceGenerator(name="SEQUENCE1", sequenceName="EVALUATION_SEQUENCE", allocationSize=1)
	private Long id;
	
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private Date fill_date;
	@Column(nullable=false)
	private int question1;
	@Column(nullable=false)
	private int question2;
	@Column(nullable=false)
	private int question3;
	@Column(nullable=false)
	private int question4;
	@Column(nullable=false)
	private int question5;
	@Column(nullable=false)
	private int question6;
	@Column(nullable=false)
	private int question7;
	@Column(nullable=false)
	private int question8;
	@Column(nullable=false)
	private int question9;
	private String question10;
	
	@ManyToOne
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Evaluation(){}
	public Evaluation(Long id,String name, Date fill_date, int question1,
			int question2, int question3, int question4, int question5, int question6,
			int question7, int question8, int question9, String question10, Employee employee) {
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

	public int getquestion1() {
		return question1;
	}

	public void setquestion1(int question1) {
		this.question1 = question1;
	}

	public int getquestion2() {
		return question2;
	}

	public void setquestion2(int question2) {
		this.question2 = question2;
	}

	public int getquestion3() {
		return question3;
	}

	public void setquestion3(int question3) {
		this.question3 = question3;
	}

	public int getquestion4() {
		return question4;
	}

	public void setquestion4(int question4) {
		this.question4 = question4;
	}

	public int getquestion5() {
		return question5;
	}

	public void setquestion5(int question5) {
		this.question5 = question5;
	}

	public int getquestion6() {
		return question6;
	}

	public void setquestion6(int question6) {
		this.question6 = question6;
	}

	public int getquestion7() {
		return question7;
	}

	public void setquestion7(int question7) {
		this.question7 = question7;
	}

	public int getquestion8() {
		return question8;
	}

	public void setquestion8(int question8) {
		this.question8 = question8;
	}

	public int getquestion9() {
		return question9;
	}

	public void setquestion9(int question9) {
		this.question9 = question9;
	}

	public String getquestion10() {
		return question10;
	}

	public void setquestion10(String question10) {
		this.question10 = question10;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((employee == null) ? 0 : employee.hashCode());
		result = prime * result
				+ ((fill_date == null) ? 0 : fill_date.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + question1;
		result = prime * result
				+ ((question10 == null) ? 0 : question10.hashCode());
		result = prime * result + question2;
		result = prime * result + question3;
		result = prime * result + question4;
		result = prime * result + question5;
		result = prime * result + question6;
		result = prime * result + question7;
		result = prime * result + question8;
		result = prime * result + question9;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evaluation other = (Evaluation) obj;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (fill_date == null) {
			if (other.fill_date != null)
				return false;
		} else if (!fill_date.equals(other.fill_date))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (question1 != other.question1)
			return false;
		if (question10 == null) {
			if (other.question10 != null)
				return false;
		} else if (!question10.equals(other.question10))
			return false;
		if (question2 != other.question2)
			return false;
		if (question3 != other.question3)
			return false;
		if (question4 != other.question4)
			return false;
		if (question5 != other.question5)
			return false;
		if (question6 != other.question6)
			return false;
		if (question7 != other.question7)
			return false;
		if (question8 != other.question8)
			return false;
		if (question9 != other.question9)
			return false;
		return true;
	}
}
