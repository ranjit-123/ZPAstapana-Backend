package com.zpasthapana.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbluser")
public class User extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userID")
	private Long userId;

	@Column(name = "userName")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "IPAddress")
	private String IPAddress;

	@Column(name = "userType")
	private String userType;

	@Column(name = "userReferenceID")
	private Integer userReferenceID;

	@Column(name = "profilePhoto")
	private String profilePhoto;

	@Column(name = "userFullName")
	private String userFullName;

	@Column(name = "themeColor")
	private Integer themeColor;

	@Column(name = "addEditAccessFlag")
	private Integer addEditAccessFlag;

	@Column(name = "reportAccessFlag")
	private Integer reportAccessFlag;

	@Column(name = "accessFlag")
	private Integer accessFlag;

	@Column(name = "divisionID")
	private Long divisionID;

	@Column(name = "zillaParishadID")
	private Long zillaParishadID;

	@Column(name = "departmentID")
	private Long departmentID;

	@Column(name = "talukaID")
	private Long talukaID;

	@Column(name = "subDivisionID")
	private Long subDivisionID;

	@Column(name = "properOfficeID")
	private Long properOfficeID;
	
	@Column(name = "isActive")
	private Integer isActive;
	
	@Column(name = "email")
	private String email;

}
