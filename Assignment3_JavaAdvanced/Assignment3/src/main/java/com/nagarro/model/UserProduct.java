package com.nagarro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity

public class UserProduct {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String userName;
	@Column(unique = true)
	private String productTitle;
	private double productQty;
	private double productSize;
	private String imageFileName;
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	@Transient
	private double maxSize;
	
	public UserProduct(String userName, String productTitle,double productQty, double productSize) {
		this.userName = userName;
		this.productTitle = productTitle;
		this.productQty=productQty;
		this.productSize = productSize;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getProductTitle() {
		return productTitle;
	}
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	public double getProductQty() {
		return productQty;
	}
	public void setProductQty(double productQty) {
		this.productQty=productQty;
	}
	public double getMaxSize() {
		return maxSize;
	}
	public void setMaxSize(double maxSize) {
		this.maxSize = maxSize;
	}
	public double getProductSize() {
		return productSize;
	}
	public void setProductSize(double productSize) {
		this.productSize = productSize;
	}
	public UserProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
