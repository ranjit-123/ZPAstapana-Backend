package com.zpasthapana.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "crime")
public class Crime extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer isArrested;
	private Integer isSuspended;
	private Integer suspendCase;
	private String reasonNotSuspended;
	private Integer indictmentNumber;
	
	private Date indictmentDate;
	private String actualIndictmentNumber;
	
	private Date actualIndictmentDate;
	private String conditionOfCase;
	private Integer courtResult;
	private String courtResultReason;
	private String whatIsActionTaken;
	private Integer punishmentOrderNo;
	private String punishmentOrderPdf;
	
	private Date punishmentOrderDate;
	private String resultPdf;
	private Integer appealedInHigherCourt;
	private String caseDetails;
	private Integer appealNumber;
	
	private Date appealDate;
	private Long employeeId;

	@Column(name = "active", nullable = false)
	@ColumnDefault(value = "true")
	@Generated(GenerationTime.INSERT)
	private Boolean isActive;

	private Long createdBy;
	private Long modifiedBy;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	
	private Date createDate;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	
	private Date modifyDate;
	
	@OneToOne
	@JoinColumn(table = "crime", name ="employeeId", insertable = false, updatable = false)
	private Employee employee;
	
}
