package com.company.SpringRestBoot2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "customers")
public class CustomerModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int custId;
	@Column
	private String custName;
	private String custEmail;
	private String custAddr;
	
	public CustomerModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerModel(int custId, String custName, String custEmail, String custAddr) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custEmail = custEmail;
		this.custAddr = custAddr;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustAddr() {
		return custAddr;
	}

	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}

	@Override
	public String toString() {
		return "CustomerModel [custId=" + custId + ", custName=" + custName + ", custEmail=" + custEmail + ", custAddr="
				+ custAddr + "] \n";
	}

}
