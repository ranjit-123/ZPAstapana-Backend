package com.zpasthapana.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "court_case")
public class CourtCase extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date caseStartDate;
	private Integer caseNumber;
	private String caseDetails;
	private String districtName;
	private Integer courtName;
	private Date resultDate;
	private String resultPdf;
	private String courtResult;
	private Integer courtResultImplemented;
	private String whichActionTaken;
	private Date actionTakenDate;
	private Long employeeId;
	
	@OneToOne
	@JoinColumn(table = "court_case", name ="employeeId", insertable = false, updatable = false)
	private Employee employee;
	
}
