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
	private int otazka1;
	private int otazka2;
	private int otazka3;
	private int otazka4;
	private int otazka5;
	private int otazka6;
	private int otazka7;
	private int otazka8;
	private int otazka9;
	private String otazka10;
	
	@ManyToOne
	private Employee employee;
	
	public Evaluation(String name, Date fill_date, int otazka1,
			int otazka2, int otazka3, int otazka4, int otazka5, int otazka6,
			int otazka7, int otazka8, int otazka9, String otazka10) {
		super();
		this.id = id;
		this.name = name;
		this.fill_date = fill_date;
		this.otazka1 = otazka1;
		this.otazka2 = otazka2;
		this.otazka3 = otazka3;
		this.otazka4 = otazka4;
		this.otazka5 = otazka5;
		this.otazka6 = otazka6;
		this.otazka7 = otazka7;
		this.otazka8 = otazka8;
		this.otazka9 = otazka9;
		this.otazka10 = otazka10;
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

	public int getOtazka1() {
		return otazka1;
	}

	public void setOtazka1(int otazka1) {
		this.otazka1 = otazka1;
	}

	public int getOtazka2() {
		return otazka2;
	}

	public void setOtazka2(int otazka2) {
		this.otazka2 = otazka2;
	}

	public int getOtazka3() {
		return otazka3;
	}

	public void setOtazka3(int otazka3) {
		this.otazka3 = otazka3;
	}

	public int getOtazka4() {
		return otazka4;
	}

	public void setOtazka4(int otazka4) {
		this.otazka4 = otazka4;
	}

	public int getOtazka5() {
		return otazka5;
	}

	public void setOtazka5(int otazka5) {
		this.otazka5 = otazka5;
	}

	public int getOtazka6() {
		return otazka6;
	}

	public void setOtazka6(int otazka6) {
		this.otazka6 = otazka6;
	}

	public int getOtazka7() {
		return otazka7;
	}

	public void setOtazka7(int otazka7) {
		this.otazka7 = otazka7;
	}

	public int getOtazka8() {
		return otazka8;
	}

	public void setOtazka8(int otazka8) {
		this.otazka8 = otazka8;
	}

	public int getOtazka9() {
		return otazka9;
	}

	public void setOtazka9(int otazka9) {
		this.otazka9 = otazka9;
	}

	public String getOtazka10() {
		return otazka10;
	}

	public void setOtazka10(String otazka10) {
		this.otazka10 = otazka10;
	}
	
	
	
	
	
		
}
