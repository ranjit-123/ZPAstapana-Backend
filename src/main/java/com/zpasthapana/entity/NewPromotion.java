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
@Table(name = "new_promotion")
public class NewPromotion extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long employeeId;
	private Integer addNewPromotionRegularPromotionsFlag;
	private Integer addNewPromotioneEployeeSelectionCategoryIDFlag;
	private String addNewPromotionGrade;
	private String addNewPromotionPDF;
	private String addNewPromotionDisignation;
	private String addNewPromotionPayCommission;
	private Date addNewPromotionLastDateOfService;
	private Integer addNewPromotionTravelPeriodFlag;
	private Date dateOfTravelPeriodStart;
	private Date addNewPromotionOrderDate;
	private String addNewPromotionOrderNumber;
	private Date addNewPromotionDateOfHumanitySeniority;
	private Date dateOfPromotionAppointment;
	private Date holidayPerioddateOfTravelPeriodEnd;
	private Date holidayPerioddateOfTravelPeriodStart;
	private Integer holidayPeriodFlag;
	private Date dateOfTravelPeriodEnd;
	private Long talukaID;
	private Long subDivisionID;
	private Long subDepartmentId;
	private Integer additionalQualificationApplicableFlag;
	private Integer promotionsQualificationFlag;
	private String promotionsQualificationExamName;
	private Date passDate;
	private String promotionsQualificationPDF;
	private Long addNewPromotionCastecategory;
	private Integer certificateNumber;
	
	@OneToOne
	@JoinColumn(table = "new_promotion", name ="employeeId", insertable = false, updatable = false)
	private Employee employee;
}
