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
@Table(name = "rejected_promotion")
public class RejectedPromotion extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long employeeId;
	private Long rejectedPromotionPayCommission;
	private Long rejectedPromotionDisignation;
	private String rejectedPromotionGrade;
	private String rejectedPromotionOrderNumber;
	private String rejectedPromotionPDF;
	private Date rejectedPromotionOrderDate;
	private Long rejectedPromotionCastecategory;
	private Integer rejectedGotPromotionFlag;
	private String rejectedGotPromotionOrderNumber;
	private Date rejectedGotPromotionOrderDate;
	private String rejectedGotPromotionPDF;
	private String rejectedGotPromotionDetails;
	private String rejectedGotPromotionTermsAndConditions;
	
	@OneToOne
	@JoinColumn(table = "rejected_promotion", name ="employeeId", insertable = false, updatable = false)
	private Employee employee;
}
