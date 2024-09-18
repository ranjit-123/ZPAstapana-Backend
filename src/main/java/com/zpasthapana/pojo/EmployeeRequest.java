package com.zpasthapana.pojo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.zpasthapana.entity.EmployeeEducation;
import com.zpasthapana.entity.EmployeeEducationDTO;

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
public class EmployeeRequest extends BaseRequest{
	private Long employeeId;
	private Long employeeBasicDetailsId;
	private String loginEmail;
	private String contactNumber;
	private String alternateContactNumber;
	private String pancardNumber;
	private String aadhaarCardNumber;
	private String dateOfBirth;
	private Long religionID;
	private Integer gender;
	private Long employeeWorklocationId;
	private String retirementDate;
	private String sevaDate;
	private String salaryServiceIDNumber;
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
	private Integer castecategory;
	private Integer casteCertificateFlag;
	private Long appointmentCasteCategoryID;
	private String casteCertificateNumber;
	private String casteCertificateDate;
	private String casteCertificatedIssuedOfficerName;
	private MultipartFile casteCertificatePDF;
	private Integer casteValidityFlag;
	private String casteValidityNumber;
	private String casteValidityDate;
	private MultipartFile casteValidityPDF;
	private String casteValidityCommitteeName;
	private Integer casteCategoryChangedAfterAppointmentFlag;
	private Integer casteCategoryChangedAfterAppointmentID;
	private String casteCategoryChangedAfterAppointmentNumber;
	private String casteCategoryChangedAfterAppointmentDate;
	private MultipartFile casteValidityChangedAfterAppointmentPDF;
	
	private Integer employeeselectioncategory;
	private String payCommission;
	private Integer appointmentQualificationFlag;
	private Long qualification;
	private Long parallelReservationType;
	private String salaryRange;
	private String dateOfAppointed;
	private MultipartFile appointedDateFirstPagePDF;
	private MultipartFile appointmentOrderPDF;
	private String dateOfHumanitySeniority;
	private String appointmentOrderNumber;
	private String appointmentOrderDate;
	private MultipartFile serviceBookFirstPagePDF;
	
	private Integer disabilityFlag;
	private Integer disabilityReservation;
	private String appointmentDisability;
	private Integer disabilityID;
	private String disabilityPercentage;
	private String certificateDisabilityDate;
	private MultipartFile disabilityCertificatePDF;
 
	private Integer changedAfterAppointmentFlag;
	private Integer transferTypeFlag;
	private Integer furtherServiceFlag;
	private Integer medicalCertificateFlag;
	private Integer characterVerifiedFlag;
	
	private String joiningData;
	private String appointmentQualificationExamName;
	private String dateOfPass;
	private MultipartFile appointmentQualificationPDF;
	private String characterVerifiedOrderNumber;
	private String characterVerifiedOrderDate;
	private MultipartFile characterVerifiedPDF;
	private String medicalCertificateOrderNumber;
	private String medicalCertificateOrderDate;
	private MultipartFile medicalCertificatePDF;
	private String furtherServiceOrderNumber;
	private String furtherServiceOrderDate;
	private MultipartFile furtherServicePDF;
	
	private String typingFlag;
//	private String marathiHindiFlag;
	private String marathiTypingSpeed;
	private String marathiTypingSpeedPassoutDate;
	private String marathiTypingSpeedDiscountDate;
	private String marathiTypingSpeedDiscountOrderDate;
	private MultipartFile marathiTypingSpeedPDF;
	private String rbtnEnglishTypingFlag;
	private String englishTypingSpeed;
	private String englishTypingSpeedPassoutDate;
	private String englishTypingSpeedDiscountDate;
	private String englishTypingSpeedDiscountOrderDate;
	private MultipartFile englishTypingSpeedPDF;
	
	private Integer computerFlag;
	private String computerExamName;
	private String computerPassoutDate;
	private String computerDiscountDate;
	private String computerDiscountOrderDate;
	private MultipartFile computerPDF;
	
	private String type;
	private Long stateId;
	private Long divisionId;
	private Long zpId;
	private Long departmentId;
	private Long designationId;
	private Long taluka;
	private Long subDivision;
	private Long subDepartment;
	
	private Integer concessionBrainFlag;
	private Integer concessionParalysisFlag;
	private Integer concessionHandicappeFlag;
	private Integer concessionCardiacSurgeryFlag;
	private Integer concessionDialysisFlag;
	private Integer concessionCancerFlag;
	private Integer concessionSoldierFlag;
	private Integer concessionWidowFlag;
	private Integer concessionVestalFlag;
	private Integer concessionDivorceFlag;
	private Integer concession53YearCompletedFlag;
	private Integer concessionHusbandWifeAggregationFlag;
	private Integer concessionFreedomFighterFlag;
	private String concessionBrainCertificateNumber;
	private String concessionBrainCertificateDate;
	private Integer concessionBrainTransferPeriodFlag;
	private String concessionBrainValidityDate;
	private MultipartFile concessionBrainPDF;
	private String concessionParalysisCertificateNumber;
	private String concessionParalysisCertificateDate;
	private String concessionParalysisTransferPeriodFlag;
	private String concessionParalysisValidityDate;
	private MultipartFile concessionParalysisPDF;
	private String concessionHandicappeCertificateNumber;
	private String concessionHandicappeCertificateDate;
	private String concessionHandicappeTransferPeriodFlag;
	private String concessionHandicappeValidityDate;
	private MultipartFile concessionHandicappePDF;
	private String concessionCardiacSurgeryCertificateNumber;
	private String concessionCardiacSurgeryCertificateDate;
	private String concessionCardiacSurgeryTransferPeriodFlag;
	private String concessionCardiacSurgeryValidityDate;
	private MultipartFile concessionCardiacSurgeryPDF;
	private String concessionDialysisCertificateNumber;
	private String concessionDialysisCertificateDate;
	private String concessionDialysisTransferPeriodFlag;
	private String concessionDialysisValidityDate;
	private MultipartFile concessionDialysisPDF;
	private String concessionCancerCertificateNumber;
	private String concessionCancerCertificateDate;
	private String concessionCancerTransferPeriodFlag;
	private String concessionCancerValidityDate;
	private MultipartFile concessionCancerPDF;
	private String concessionSoldierCertificateNumber;
	private String concessionSoldierCertificateDate;
	private String concessionSoldierTransferPeriodFlag;
	private String concessionSoldierValidityDate;
	private MultipartFile concessionSoldierPDF;
	private String concessionWidowCertificateNumber;
	private String concessionWidowCertificateDate;
	private String concessionWidowTransferPeriodFlag;
	private String concessionWidowValidityDate;
	private MultipartFile concessionWidowPDF;
	private String concessionVestalCertificateNumber;
	private String concessionVestalCertificateDate;
	private String concessionVestalTransferPeriodFlag;
	private String concessionVestalValidityDate;
	private MultipartFile concessionVestalPDF;
	private String concessionDivorceCertificateNumber;
	private String concessionDivorceCertificateDate;
	private String concessionDivorceTransferPeriodFlag;
	private String concessionDivorceValidityDate;
	private MultipartFile concessionDivorcePDF;
	private String concession53YearCompletedSetFlag;
	private String concessionHusbandWifeAggregationAppointmentLevelID;
	private String concessionHusbandWifeAggregationWorkingDate;
	private MultipartFile concessionHusbandWifeAggregationPDF;
	private String concessionFreedomFighterName;
	private String concessionFreedomFighterRelation;
	private String concessionFreedomFighterIsLiveFlag;
	private MultipartFile concessionFreedomFighterPDF;
	
	
	private Integer nomineePensionFlag;
	private String nomineePensionDate;
	private MultipartFile nomineePensionPDF;
	private Integer nomineeServiceAllowanceFlag;
	private String nomineeDateOfServiceAllowance;
	private MultipartFile nomineeServiceAllowancePDF;
	private Integer nomineeProvidentFundFlag;
	private String nomineeProvidentFundAccountNumber;
	private String nomineeDateOfProvidentFund;
	private MultipartFile nomineeProvidentFundPDF;
	private Integer nomineeGroupInsurancePlanFlag;
	private String nomineeDateOfGroupInsurancePlan;
	private MultipartFile nomineeGroupInsurancePlanPDF;
	private Integer nomineeAccidentInsurancePlanFlag;
	private String nomineeDateOfAccidentInsurancePlan;
	private MultipartFile nomineeAccidentInsurancePlanPDF;
	private Integer nomineeNPSFlag;
	private String nomineeNPSAccountNumber;
	private String nomineeDateOfNPS;
	private MultipartFile nomineeNPSPDF;
	private Integer nomineeFamilyCertificateFlag;
	private String nomineeDateOfFamilyCertificate;
	private MultipartFile nomineeFamilyCertificatePDF;
	private Integer nomineePromiseFlag;
	private String nomineeDateOfPromise;
	private MultipartFile nomineePromisePDF;
	
	private Integer marathiHindiFlag;
	private String marathiOrderNumber;
	private Integer marathiFlag;
	private String marathiOrderDate;
	private MultipartFile marathiPDF;
	private Integer hindiFlag;
	private String hindiOrderNumber;
	private String hindiOrderDate;
	private MultipartFile hindiPDF;
	private Integer marathiHinidCombineFlag;
	private String marathiHinidCombineOrderNumber;
	private String marathiHinidCombineOrderDate;
	private MultipartFile marathiHinidCombinePDF;
	
	private Integer nomineemedicalAaiVadilORSasuSasare;
	private String medicalbillfordate;
	private MultipartFile medicalbillforProofPDF;
	private String concessionHusbandWifeAggregationFullName;
	private MultipartFile concessionHusbandWifeAggregationFalimlyPhotoPDF;
	private String pranNumber;
	private List<EmployeeEducationDTO> educationDetails;

}
