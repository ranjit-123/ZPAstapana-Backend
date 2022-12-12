package com.zpasthapana.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "deputation")
public class Deputation extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String deputationOrderNumber;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Calcutta")
	private Date deputationDate;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Calcutta")
	private Date deputationOfficeDate;
	private String deputationPdf;
	private String deputationReason;
	private Integer commissionerPermission;
	private Integer commissionerOrderNumber;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Calcutta")
	private Date commissionerOrderDate;
	private String commissionerOrderPdf;
	private Integer deputationSection;
	private Integer cmbSubDivisionID;
	private Integer cmbProperOfficeID;
	private Integer deputationEndOrderNumbe;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Calcutta")
	private Date deputationEndOrderDate;
	private String deputationEndPdf;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Calcutta")
	private Date deputationServiceEndDate;
	private String dtpDateOfRegularOfficeRejoining;
	private Long employeeId;
	
	@OneToOne
	@JoinColumn(table = "deputation", name ="employeeId", insertable = false, updatable = false)
	private Employee employee;
	
}
