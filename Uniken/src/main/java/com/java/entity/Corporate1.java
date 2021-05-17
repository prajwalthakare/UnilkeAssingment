// default package
// Generated 16 May, 2021 1:02:53 PM by Hibernate Tools 5.2.3.Final
package com.java.entity;
import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "corporate1", catalog = "uniken")
public class Corporate1 implements java.io.Serializable {

	private Integer srNo;
	private String corporateName;
	private String accountNumbers;
	private String corporateId;

	public Corporate1() {
	}

	public Corporate1(String corporateName, String accountNumbers, String corporateId) {
		this.corporateName = corporateName;
		this.accountNumbers = accountNumbers;
		this.corporateId = corporateId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "SrNo")
	public Integer getSrNo() {
		return this.srNo;
	}

	public void setSrNo(Integer srNo) {
		this.srNo = srNo;
	}

	@Column(name = "CorporateName")
	public String getCorporateName() {
		return this.corporateName;
	}

	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}

	@Column(name = "AccountNumbers")
	public String getAccountNumbers() {
		return this.accountNumbers;
	}

	public void setAccountNumbers(String accountNumbers) {
		this.accountNumbers = accountNumbers;
	}

	@Column(name = "CorporateID")
	public String getCorporateId() {
		return this.corporateId;
	}

	public void setCorporateId(String corporateId) {
		this.corporateId = corporateId;
	}

}
