package com.zpasthapana.pojo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponse {
	private Long employeeId;
	private Long employeeBasicDetailsId;
	private String loginEmail;
	private String contactNumber;
	private String alternateContactNumber;
	private String pancardNumber;
	private String aadhaarCardNumber;
	private LocalDate dateOfBirth;
	private Long religionID;
	private Integer gender;
	private Long employeeWorklocationId;
	private LocalDate retirementDate;
	private String txtSalaryServiceIDNumber;
	private String permanentAddress;
	private String currentAddress;
	private String declaredScale;
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String firstNameEng;
	private String middleNameEng;
	private String lastNameEng;
	
	private String caste;
	private String castecategory;
	private Integer casteCertificateFlag;
	private Long appointmentCasteCategoryID;
	private String casteCertificateNumber;
	private LocalDate casteCertificateDate;
	private String casteCertificatedIssuedOfficerName;
	private String casteCertificatePDF;
	private Integer casteValidityFlag;
	private String casteValidityNumber;
	private LocalDate casteValidityDate;
	private String casteValidityPDF;
	private String casteValidityCommitteeName;
	private Integer casteCategoryChangedAfterAppointmentFlag;
	private Integer casteCategoryChangedAfterAppointmentID;
	private String casteCategoryChangedAfterAppointmentNumber;
	private LocalDate casteCategoryChangedAfterAppointmentDate;
	private String casteValidityChangedAfterAppointmentPDF;
	
	private String employeeselectioncategory;
	private String payCommission;
	private Integer appointmentQualificationFlag;
	private Long qualification;
	private Long parallelReservationType;
	private String salaryRange;
	private LocalDate dateOfAppointed;
	private String appointedDateFirstPagePDF;
	private String appointmentOrderPDF;
	private LocalDate dateOfHumanitySeniority;
	private String appointmentOrderNumber;
	private LocalDate appointmentOrderDate;
	private String serviceBookFirstPagePDF;
	
	private Integer disabilityFlag;
	private Integer disabilityReservation;
	private String appointmentDisability;
	private Integer disabilityID;
	private String disabilityPercentage;
	private LocalDate certificateDisabilityDate;
	private String disabilityCertificatePDF;
	
	private String universityName; 
	private String degreeName ;
	private String passoutDate  ;
	private String certificatePDF; 
	private Integer changedAfterAppointmentFlag;
	private Integer transferTypeFlag;
	private Integer furtherServiceFlag;
	private Integer medicalCertificateFlag;
	private Integer characterVerifiedFlag;
	
	private LocalDate joiningData;
	private String appointmentQualificationExamName;
	private LocalDate dateOfPass;
	private String appointmentQualificationPDF;
	private String characterVerifiedOrderNumber;
	private LocalDate characterVerifiedOrderDate;
	private String characterVerifiedPDF;
	private String medicalCertificateOrderNumber;
	private LocalDate medicalCertificateOrderDate;
	private String medicalCertificatePDF;
	private String furtherServiceOrderNumber;
	private LocalDate furtherServiceOrderDate;
	private String furtherServicePDF;
	
	private String typingFlag;
	private String marathiHindiFlag;
	private String marathiTypingSpeed;
	private String marathiTypingSpeedPassoutDate;
	private String marathiTypingSpeedDiscountDate;
	private String marathiTypingSpeedDiscountOrderDate;
	private String marathiTypingSpeedPDF;
	private String rbtnEnglishTypingFlag;
	private String englishTypingSpeed;
	private String englishTypingSpeedPassoutDate;
	private String englishTypingSpeedDiscountDate;
	private String englishTypingSpeedDiscountOrderDate;
	private String englishTypingSpeedPDF;
	
	private String type;
	private Long stateId;
	private Long divisionId;
	private Long zpId;
	private Long subDivisionId;
	private Long departmentId;
	private Long designationId;
	private Long taluka;
	private Long subDivision;
	private Long subDepartment;
}
