package com.zpasthapana.pojo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewPromotionRequest extends BaseRequest{
	private Long employeeId;
	private Integer addNewPromotionRegularPromotionsFlag;
	private Integer addNewPromotioneEployeeSelectionCategoryIDFlag;
	private String addNewPromotionGrade;
	private MultipartFile addNewPromotionPDF;
	private String addNewPromotionDisignation;
	private String addNewPromotionPayCommission;
	private Date addNewPromotionLastDateOfService;
	private Integer addNewPromotionTravelPeriodFlag;
	private Date dateOfTravelPeriodStart;
	private String addNewPromotionOrderDate;
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
	private MultipartFile promotionsQualificationPDF;
	private Long addNewPromotionCastecategory;
	private Integer certificateNumber;
}
