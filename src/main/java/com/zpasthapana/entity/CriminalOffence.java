package com.zpasthapana.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "criminal_offence")
public class CriminalOffence extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long employeeId;
	private Date firDate;
	private String firNumber;
	private String districtName;
	private String policeStationName;
	private String crimeDetails;
	private Integer isSuspended;
	private Integer suspendCase;
	private String caseResult;
	private Date resultDate;
	private String resultPdf;
	private Integer courtResultImplemented;
	private String whichActionTaken;
	private Date actionTakenDate;
}
