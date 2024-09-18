package com.zpasthapana.entity;

public class EmployeeEducationDTO {
	private String certificatePDF;
	private String universityName;
	private String degreeName;
	private String passoutDate;
	private String certificatePDF;

	public Long getEmployeeEducationId() {
		return employeeEducationId;
	}

	public void setEmployeeEducationId(Long employeeEducationId) {
		this.employeeEducationId = employeeEducationId;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getDegreeName() {
		return degreeName;
	}

	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}

	public String getPassoutDate() {
		return passoutDate;
	}

	public void setPassoutDate(String passoutDate) {
		this.passoutDate = passoutDate;
	}

	public String getCertificatePDF() {
		return certificatePDF;
	}

	public void setCertificatePDF(String certificatePDF) {
		this.certificatePDF = certificatePDF;
	}

}
