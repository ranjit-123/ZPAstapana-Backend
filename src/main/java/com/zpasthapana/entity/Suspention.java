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
@Table(name = "suspention")
public class Suspention extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long employeeId;
	private Integer suspensionOrderNo;
	private Date suspensionOrderDate;
	private Date suspensionDate;
	private String suspensionReason;
	private Integer suspensionTaluka;
	private Integer suspensionSubdivision;
	private String suspensionOfficeName;
	private Integer subsistenceIncreased;
	private Integer subsistenceOrderNo;
	private Date subsistenceOrderDate;
	private Double subsistenceAmt;
	private Integer isAcbReviewed;
	private Date acbReviewedDate;
	private Integer officeChangedInSuspension;
	private Integer changedTaluka;
	private Integer changedSubdivision;
	private Integer changedOfficeName;
	private Integer isReinstated;
	private Integer reinstatedOrderNo;
	private Date reinstatedOrderDate;
	private String reinstatedOrderReason;
	private Date presentDateInReinstated;
	private Integer reinstatedTaluka;
	private Integer reinstatedSubdivision;
	private Integer reinstatedOfficeName;
	private String suspensionPdf;

	@OneToOne
	@JoinColumn(table = "suspention", name ="employeeId", insertable = false, updatable = false)
	private Employee employee;
	
	@OneToOne
	@JoinColumn(table = "suspention", name ="employeeId", insertable = false, updatable = false)
	private EmployeeWorklocation employeeWorkLocation;
	
	@OneToOne
	@JoinColumn(table = "suspention", name ="employeeId", insertable = false, updatable = false)
	private EmployeeCastDetails employeeCastDetails;
	
}
