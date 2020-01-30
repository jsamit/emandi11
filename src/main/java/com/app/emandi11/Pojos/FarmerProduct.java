package com.app.emandi11.Pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "FARMER_PRODUCT")
public class FarmerProduct {

	
	@ManyToOne
	@JoinColumn(name = "FARMER_ID")
	private FarmerPojo farmer;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ID")

	private Integer pId;
	@Column(name = "PRODUCT_CATEGORY", length = 50)
	private String pCategory;
	@Column(name = "PRODUCT_NAME")
	private String prodName;
	@Column(name = "PRODUCT_PRICE")
	private double pPrice;
	
	
	

	@Column(name = "PRODUCT_QUANTITY")

	private Integer pQuantity;

	@Column(name = "PRODUCT_QUALITY")
	private String pQuality;

	public FarmerProduct() {
		super();
		System.out.println("In Farmer Product pojo default constructor");
	}

	@JsonIgnore
	public FarmerPojo getFarmer() {
		return farmer;
	}

	public void setFarmer(FarmerPojo farmer) {
		this.farmer = farmer;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getpCategory() {
		return pCategory;
	}

	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}

	public String getProdName() {
		return prodName;
	}

	public void setpName(String pName) {
		this.prodName = pName;
	}

	public double getpPrice() {
		return pPrice;
	}

	public void setpPrice(double pPrice) {
		this.pPrice = pPrice;
	}

	public Integer getpQuantity() {
		return pQuantity;
	}

	public void setpQuantity(Integer pQuantity) {
		this.pQuantity = pQuantity;
	}

	public String getpQuality() {
		return pQuality;
	}

	public void setpQuality(String pQuality) {
		this.pQuality = pQuality;
	}
	


	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	@Override
	public String toString() {
		return "FarmerProduct [farmer=" + farmer + ", pId=" + pId + ", pCategory=" + pCategory + ", prodName="
				+ prodName + ", pPrice=" + pPrice + ", pQuantity=" + pQuantity + ", pQuality=" + pQuality + "]";
	}

}
