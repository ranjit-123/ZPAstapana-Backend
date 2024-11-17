package com.zpasthapana.pojo;

import java.util.Date;
import java.util.List;

import com.zpasthapana.entity.AccidentalInsurance;
import com.zpasthapana.entity.AccountInquiry;
import com.zpasthapana.entity.AdditionalService;
import com.zpasthapana.entity.ApprenticeNotice;
import com.zpasthapana.entity.AssetLiability;
import com.zpasthapana.entity.Confidential;
import com.zpasthapana.entity.CourtCase;
import com.zpasthapana.entity.Crime;
import com.zpasthapana.entity.Deputation;
import com.zpasthapana.entity.EmployeeEducationDTO;
import com.zpasthapana.entity.EmployeeNomineeDetails;
import com.zpasthapana.entity.ExtraOrdinaryLeaves;
import com.zpasthapana.entity.NewTraining;
import com.zpasthapana.entity.NewTransfer;
import com.zpasthapana.entity.PrizePrides;
import com.zpasthapana.entity.PurchasePermission;
import com.zpasthapana.entity.RejectedPromotion;
import com.zpasthapana.entity.Retierment;
import com.zpasthapana.entity.ServiceSegment;
import com.zpasthapana.entity.StayitvaPramanpatra;
import com.zpasthapana.entity.Suspention;
import com.zpasthapana.entity.UnathorizedAbsencePeriod;

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
public class EmployeeResponse extends BaseRequest {
	private Long employeeId;
	private Long employeeBasicDetailsId;
	private String loginEmail;
	private String contactNumber;
	private String alternateContactNumber;
	private String pancardNumber;
	private String aadhaarCardNumber;
	private Date dateOfBirth;
	private Long religionID;
	private Integer gender;
	private Long employeeWorklocationId;
	private Date retirementDate;
	private Date sevaDate;
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
	private String castecategory;
	private Integer casteCertificateFlag;
	private Long appointmentCasteCategoryID;
	private String casteCertificateNumber;
	private Date casteCertificateDate;
	private String casteCertificatedIssuedOfficerName;
	private String casteCertificatePDF;
	private Integer casteValidityFlag;
	private String casteValidityNumber;
	private Date casteValidityDate;
	private String casteValidityPDF;
	private String casteValidityCommitteeName;
	private Integer casteCategoryChangedAfterAppointmentFlag;
	private Integer casteCategoryChangedAfterAppointmentID;
	private String casteCategoryChangedAfterAppointmentNumber;
	private Date casteCategoryChangedAfterAppointmentDate;
	private String casteValidityChangedAfterAppointmentPDF;

	private String employeeselectioncategory;
	private String payCommission;
	private Integer appointmentQualificationFlag;
	private Long qualification;
	private Long parallelReservationType;
	private String salaryRange;
	private Date dateOfAppointed;
	private String appointedDateFirstPagePDF;
	private String appointmentOrderPDF;
	private Date dateOfHumanitySeniority;
	private String appointmentOrderNumber;
	private Date appointmentOrderDate;
	private String serviceBookFirstPagePDF;

	private Integer disabilityFlag;
	private Integer disabilityReservation;
	private String appointmentDisability;
	private Integer disabilityID;
	private String disabilityPercentage;
	private Date certificateDisabilityDate;
	private String disabilityCertificatePDF;

	private String universityName;
	private String degreeName;
	private String passoutDate;
	private String certificatePDF;
	private Integer changedAfterAppointmentFlag;
	private Integer transferTypeFlag;
	private Integer furtherServiceFlag;
	private Integer medicalCertificateFlag;
	private Integer characterVerifiedFlag;

	private Date joiningData;
	private String appointmentQualificationExamName;
	private Date dateOfPass;
	private String appointmentQualificationPDF;
	private String characterVerifiedOrderNumber;
	private Date characterVerifiedOrderDate;
	private String characterVerifiedPDF;
	private String medicalCertificateOrderNumber;
	private Date medicalCertificateOrderDate;
	private String medicalCertificatePDF;
	private String furtherServiceOrderNumber;
	private Date furtherServiceOrderDate;
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

	private Integer computerFlag;
	private String computerExamName;
	private String computerPassoutDate;
	private String computerDiscountDate;
	private String computerDiscountOrderDate;
	private String computerPDF;

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
	private String concessionBrainPDF;
	private String concessionParalysisCertificateNumber;
	private String concessionParalysisCertificateDate;
	private Integer concessionParalysisTransferPeriodFlag;
	private String concessionParalysisValidityDate;
	private String concessionParalysisPDF;
	private String concessionHandicappeCertificateNumber;
	private String concessionHandicappeCertificateDate;
	private Integer concessionHandicappeTransferPeriodFlag;
	private String concessionHandicappeValidityDate;
	private String concessionHandicappePDF;
	private String concessionCardiacSurgeryCertificateNumber;
	private String concessionCardiacSurgeryCertificateDate;
	private Integer concessionCardiacSurgeryTransferPeriodFlag;
	private String concessionCardiacSurgeryValidityDate;
	private String concessionCardiacSurgeryPDF;
	private String concessionDialysisCertificateNumber;
	private String concessionDialysisCertificateDate;
	private Integer concessionDialysisTransferPeriodFlag;
	private String concessionDialysisValidityDate;
	private String concessionDialysisPDF;
	private String concessionCancerCertificateNumber;
	private String concessionCancerCertificateDate;
	private Integer concessionCancerTransferPeriodFlag;
	private String concessionCancerValidityDate;
	private String concessionCancerPDF;
	private String concessionSoldierCertificateNumber;
	private String concessionSoldierCertificateDate;
	private Integer concessionSoldierTransferPeriodFlag;
	private String concessionSoldierValidityDate;
	private String concessionSoldierPDF;
	private String concessionWidowCertificateNumber;
	private String concessionWidowCertificateDate;
	private Integer concessionWidowTransferPeriodFlag;
	private String concessionWidowValidityDate;
	private String concessionWidowPDF;
	private String concessionVestalCertificateNumber;
	private String concessionVestalCertificateDate;
	private Integer concessionVestalTransferPeriodFlag;
	private String concessionVestalValidityDate;
	private String concessionVestalPDF;
	private String concessionDivorceCertificateNumber;
	private String concessionDivorceCertificateDate;
	private Integer concessionDivorceTransferPeriodFlag;
	private String concessionDivorceValidityDate;
	private String concessionDivorcePDF;
	private Integer concession53YearCompletedSetFlag;
	private String concessionHusbandWifeAggregationAppointmentLevelID;
	private String concessionHusbandWifeAggregationWorkingDate;
	private String concessionHusbandWifeAggregationPDF;
	private String concessionFreedomFighterName;
	private String concessionFreedomFighterRelation;
	private Integer concessionFreedomFighterIsLiveFlag;
	private String concessionFreedomFighterPDF;

	private Integer addKalbadhaPromotionRegularPromotionsFlag;
	private Integer addKalbadhaPromotioneEployeeSelectionCategoryIDFlag;
	private String addKalbadhaPromotionGrade;
	private Date kalbadhaPromotionApplyDate;
	private Integer addKalbadhaPromotionDisignation;
	private Integer addKalbadhaPromotionPayCommission;
	private String addKalbadhaPromotionOrderNumber;
	private Date addKalbadhaPromotionOrderDate;
	private String addKalbadhaPromotionPDF;

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
	private String certificateNumber;
	private String pranNumber;

	private List<EmployeeEducationDTO> educationDetails;
	private List<StayitvaPramanpatra> sthaetvPramanpatraDetails;
	private List<NewTransfer> transferDetails;
	private Deputation deputationDetails;
	private List<Crime> crimeDetails;
	private List<AccountInquiry> accountInquaryDetails;
	private List<ExtraOrdinaryLeaves> extraOrdinaryLeaveDetails;
	private AdditionalService additionalServiceDetails;
	private List<PrizePrides> PrizePrideDetails;
	private List<PurchasePermission> purchasePermissionDetails;
	private List<AssetLiability> assetLiabilityDetails;
	private List<Confidential> confidentialDetails;
	private List<AccidentalInsurance> accidentalInsuranceDetails;
	private ServiceSegment serviceSegmentDetails;
	private List<CourtCase> courtCaseDetails;
	private List<UnathorizedAbsencePeriod> unathorizedAbsencePeriodDetails;
	private List<Suspention> suspentionDetails;
	private Retierment retiermentDetails;
	private RejectedPromotion rejectedPromotionDetails;
	private EmployeeNomineeDetails employeeNomineeDetails;
	private List<ApprenticeNotice> apprenticeNoticeDetails;
	public List<NewTraining> trainingDetails;

	public void setEducationDetails(List<EmployeeEducationDTO> educationDetails) {
		this.educationDetails = educationDetails;
	}

	public void setSthaetvPramanpatraDetails(List<StayitvaPramanpatra> stayitvaPramanpatraDetails) {
		this.sthaetvPramanpatraDetails = stayitvaPramanpatraDetails;
	}

	public void setApprenticeNoticeDetails(List<ApprenticeNotice> apprenticeNoticeDetails) {
		this.apprenticeNoticeDetails = apprenticeNoticeDetails;
	}

	public void setTrainingDetails(List<NewTraining> trainingDetails) {
		this.trainingDetails = trainingDetails;
	}

	public void setTransferDetails(List<NewTransfer> transferDetails) {
		this.transferDetails = transferDetails;
	}

}
