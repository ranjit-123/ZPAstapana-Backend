package com.zpasthapana.entity;

import javax.persistence.Transient;

public class BaseEntity {
	@Transient
	public String employeeFullName;
	@Transient
	public String employeeFullNameEng;
	@Transient
	public String talukaName;
	@Transient
	public String subDivisionName;
	@Transient
	public String subDepartmentName;
	@Transient
	public String designationName;
	@Transient
	public String castCategoryName;
	@Transient
	public String payCommissionName;
}
