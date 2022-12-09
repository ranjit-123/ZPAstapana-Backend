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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "assetLiability")
public class AssetLiability extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String isAssetLiabilitySubmitted;
	private String financialYear;
	private Date submissionDate;
	private String whomToSubmitted;
	private String depositedLetterPdf;
	private Long employeeId;
	
	@Column(name = "active", nullable = false)
	@ColumnDefault(value = "true")
	@Generated(GenerationTime.INSERT)
	private Boolean isActive = true;

	private Long createdBy;
	private Long modifiedBy;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;
}                                           
