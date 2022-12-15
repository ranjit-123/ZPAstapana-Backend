package com.zpasthapana.pojo;

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
	private String addNewPromotionLastDateOfService;
	private Integer addNewPromotionTravelPeriodFlag;
	private String dateOfTravelPeriodStart;
	private String addNewPromotionOrderDate;
	private String addNewPromotionOrderNumber;
	private String addNewPromotionDateOfHumanitySeniority;
	private String dateOfPromotionAppointment;
	private String holidayPerioddateOfTravelPeriodEnd;
	private String holidayPerioddateOfTravelPeriodStart;
	private Integer holidayPeriodFlag;
	private String dateOfTravelPeriodEnd;
	private Long talukaID;
	private Long subDivisionID;
	private Long subDepartmentId;
	private Integer additionalQualificationApplicableFlag;
	private Integer promotionsQualificationFlag;
	private String promotionsQualificationExamName;
	private String passDate;
	private MultipartFile promotionsQualificationPDF;
	private Long addNewPromotionCastecategory;
	private String certificateNumber;
}
