package com.app.emandi11.Pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="FARMERS")
public class FarmerPojo 
{
	
	
	private Integer f_Id;
	
	private String f_name;
	
	private String f_adhaarId;
	
	private String f_email;
	
	private String f_contact;
	
	private String f_address;
	
	private String f_city;
	
	private String f_state;
	
	private String f_pincode;
	
	private String f_password;
	
	@JsonIgnore
	private List<FarmerProduct> products = new ArrayList<FarmerProduct>(); 
	
	public FarmerPojo()
	{
		super();
		System.out.println("In Farmer default constructor");
		
	}
	

	public FarmerPojo(Integer f_Id, String f_name, String f_adhaarId, String f_email, String f_contact,
			String f_address, String f_city, String f_state, String f_pincode, String f_password,
			List<FarmerProduct> products) {
		super();
		this.f_Id = f_Id;
		this.f_name = f_name;
		this.f_adhaarId = f_adhaarId;
		this.f_email = f_email;
		this.f_contact = f_contact;
		this.f_address = f_address;
		this.f_city = f_city;
		this.f_state = f_state;
		this.f_pincode = f_pincode;
		this.f_password = f_password;
		this.products = products;
	}
	




	public FarmerPojo(Integer f_Id) {
		super();
		this.f_Id = f_Id;
		
	}


	public void setF_Id(Integer f_Id) 
	{
		this.f_Id = f_Id;
	}
	
	public void setF_adhaarId(String f_adhaarId)
	{
		this.f_adhaarId = f_adhaarId;
	}
	
	public void setF_email(String f_email) 
	{
		this.f_email = f_email;
	}
	
	public void setF_contact(String f_contact)
	{
		this.f_contact = f_contact;
	}
	
	public void setF_address(String f_address)
	{
		this.f_address = f_address;
	}
	
	public void setF_city(String f_city) 
	{
		this.f_city = f_city;
	}
	
	public void setF_state(String f_state)
	{
		this.f_state = f_state;
	}
	
	public void setF_pincode(String f_pincode) 
	{
		this.f_pincode = f_pincode;
	}
	
	public void setF_password(String f_password)
	{
		this.f_password = f_password;
	}
	
	public void setF_name(String f_name)
	{
		this.f_name = f_name;
	}

	public void setProducts(List<FarmerProduct> products) {
		this.products = products;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "farmer", cascade = CascadeType.ALL)
   
	public List<FarmerProduct> getProducts() {
		return products;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FARMER_ID")
	public Integer getF_Id() 
	{
		return f_Id;
	}
	
	@NotEmpty(message = "Name may not be Null")
	@Column(name="FARMER_NAME",length = 60,nullable = false)
	public String getF_name() 
	{
		return f_name;
	}

	@NotNull
	@Size(min=12,max=12)
	@Column(name="FARMER_ADHAARID",unique = true, nullable = false)
	public String getF_adhaarId() {
		return f_adhaarId;
	}
	@NotNull
	@Column(name="FARMER_EMAIL",length = 50,unique = true,nullable = false)
	public String getF_email()
	{
		return f_email;
	}
	@Size(min = 10,max = 13)
	@Column(name="FARMER_CONTACT",unique = true, nullable = false)
	public String getF_contact() {
		return f_contact;
	}
	
	
	@Column(name="FARMER_ADDRESS")
	public String getF_address()
	{
		return f_address;
	}
	
	@Column(name="FARMER_CITY",length = 20)
	public String getF_city() 
	{
		return f_city;
	}
	
	@Column(name="FARMER_STATE",length = 20)
	public String getF_state()
	{
		return f_state;
	}
	
	@Column(name="FARMER_PINCODE",length = 6)
	public String getF_pincode()
	{
		return f_pincode;
	}
	
	@NotNull
	@Column(name="FARMER_PASSWORD",nullable = false)
	public String getF_password()
	{
		return f_password;
	}
	
	
	
	@Override
	public String toString() 
	{
		return "FarmerPojo [f_Id=" + f_Id + ", f_adhaarId=" + f_adhaarId + ", f_email=" + f_email + ", f_contact="
				+ f_contact + ", f_address=" + f_address + ", f_city=" + f_city + ", f_state=" + f_state
				+ ", f_pincode=" + f_pincode + "]";
	}
	public void deleteFarmerProduct(FarmerProduct fproduct)
	{
		products.remove(fproduct);
		fproduct.setFarmer(null);
		
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((f_Id == null) ? 0 : f_Id.hashCode());
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
		FarmerPojo other = (FarmerPojo) obj;
		if (f_Id == null) {
			if (other.f_Id != null)
				return false;
		} else if (!f_Id.equals(other.f_Id))
			return false;
		return true;
	}
	
	

	
	/*
	 * public void addproduct(FarmerProduct fproduct) {
	 * 
	 * 
	 * products.add(fproduct); fproduct.setFarmer(this);
	 * 
	 * }
	 * 
	 * public void removeProduct(FarmerProduct fproduct) {
	 * 
	 * products.remove(fproduct); fproduct.setFarmer(null); }
	 */
}
