package com.app.emandi11.Pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CONSUMERS_REQUIREMENT")
public class ConsumerRequirement 
{
	//private Integer p_Id;//join from product table
	//private String c_id;//join from consumer table
	private Integer c_requirement_id;
	private String c_pcategory;
	private String c_pname;
	private String c_pquantity;
	private String c_pquality;
	private LocalDate c_expected_date;
	
	private ConsumerPojo consumer;
	
	public ConsumerRequirement() {
		super();
		System.out.println("Inside CosumerRequirement");
	}

	public ConsumerRequirement(Integer c_requirement_id, String c_pcategory, String c_pname, String c_pquantity,
			String c_pquality, LocalDate c_expected_date, ConsumerPojo consumer) {
		super();
		this.c_requirement_id = c_requirement_id;
		this.c_pcategory = c_pcategory;
		this.c_pname = c_pname;
		this.c_pquantity = c_pquantity;
		this.c_pquality = c_pquality;
		this.c_expected_date = c_expected_date;
		this.consumer = consumer;
	}
	

	public ConsumerRequirement(Integer c_requirement_id, String c_pcategory, String c_pname, String c_pquantity,
			String c_pquality, LocalDate c_expected_date) {
		super();
		this.c_requirement_id = c_requirement_id;
		this.c_pcategory = c_pcategory;
		this.c_pname = c_pname;
		this.c_pquantity = c_pquantity;
		this.c_pquality = c_pquality;
		this.c_expected_date = c_expected_date;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REQUIREMENT_ID")
	public Integer getC_requirement_id() {
		return c_requirement_id;
	}

	@Column(name = "PRODUCT_CATEGORY",length = 50)
	public String getC_pcategory() {
		return c_pcategory;
	}
	
	@Column(name = "PRODUCT_NAME")
	public String getC_pname() {
		return c_pname;
	}
	@Column(name = "PRODUCT_QUANTITY")
	public String getC_pquantity() {
		return c_pquantity;
	}
	@Column(name = "PRODUCT_QUALITY")
	public String getC_pquality() {
		return c_pquality;
	}
	@Column(name = "PRODUCT_ExpectedDate")
	public LocalDate getC_expected_date() {
		return c_expected_date;
	}
	
	@ManyToOne
	@JoinColumn(name="CONSUMER_ID")
	public ConsumerPojo getConsumer() {
		return consumer;
	}



	public void setConsumer(ConsumerPojo consumer) {
		this.consumer = consumer;
	}



	public void setC_requirement_id(Integer c_requirement_id) {
		this.c_requirement_id = c_requirement_id;
	}

	public void setC_pcategory(String c_pcategory) {
		this.c_pcategory = c_pcategory;
	}

	public void setC_pname(String c_pname) {
		this.c_pname = c_pname;
	}

	public void setC_pquantity(String c_pquantity) {
		this.c_pquantity = c_pquantity;
	}

	public void setC_pquality(String c_pquality) {
		this.c_pquality = c_pquality;
	}

	public void setC_expected_date(LocalDate c_expected_date) {
		this.c_expected_date = c_expected_date;
	}



	@Override
	public String toString() {
		return "ConsumerRequirement [c_requirement_id=" + c_requirement_id + ", c_pcategory=" + c_pcategory
				+ ", c_pname=" + c_pname + ", c_pquantity=" + c_pquantity + ", c_pquality=" + c_pquality
				+ ", c_expected_date=" + c_expected_date + ", consumer=" + consumer + "]";
	}

	
	
	
	
	
	
	    

}
