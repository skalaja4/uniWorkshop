package eu.unicorneducation.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EVALUATION")
public class Evaluation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQUENCE1")
	@SequenceGenerator(name="SEQUENCE1", sequenceName="SEQUENCE1", allocationSize=1)
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
	
	@ManyToOne
	private Employee employee;
	
	public Evaluation(String name, Date fill_date, int question1,
			int question2, int question3, int question4, int question5, int question6,
			int question7, int question8, int question9, String question10) {
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
	
	
	
	
	
		
}
