package com.zpasthapana.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.UpdateTimestamp;

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
@Table(name = "retierment")
public class Retierment extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String retirementOrderNumber;
	
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="Asia/Calcutta")
	private Date orderDate;
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.sss'Z'", timezone="Asia/Calcutta")
	private Date retirementDate;
	private String retirementReason;
	private Integer isPayAfterRetirement;
	private Integer isPension;
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.sss'Z'", timezone="Asia/Calcutta")
	private Date declarationDate;
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.sss'Z'", timezone="Asia/Calcutta")
	private Date fromDate;
	private Integer pendingLevel;
	private String currentCondition;
	private Boolean homeLoanPending;
	private Boolean castCertificatePending;
	private Boolean docsIncomplte;
	private Boolean amountDue;
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
}
