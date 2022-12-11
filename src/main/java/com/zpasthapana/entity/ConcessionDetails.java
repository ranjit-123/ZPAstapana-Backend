package com.zpasthapana.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Table(name = "concession_details")
public class ConcessionDetails extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Calcutta")
	private Date concessionBrainCertificateDate;
	private Integer concessionBrainTransferPeriodFlag;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Calcutta")
	private Date concessionBrainValidityDate;
	private String concessionBrainPDF;
	private String concessionParalysisCertificateNumber;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Calcutta")
	private Date concessionParalysisCertificateDate;
	private Integer concessionParalysisTransferPeriodFlag;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Calcutta")
	private Date concessionParalysisValidityDate;
	private String concessionParalysisPDF;
	private String concessionHandicappeCertificateNumber;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Calcutta")
	private Date concessionHandicappeCertificateDate;
	private Integer concessionHandicappeTransferPeriodFlag;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Calcutta")
	private Date concessionHandicappeValidityDate;
	private String concessionHandicappePDF;
	private String concessionCardiacSurgeryCertificateNumber;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Calcutta")
	private Date concessionCardiacSurgeryCertificateDate;
	private Integer concessionCardiacSurgeryTransferPeriodFlag;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Calcutta")
	private Date concessionCardiacSurgeryValidityDate;
	private String concessionCardiacSurgeryPDF;
	private String concessionDialysisCertificateNumber;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Calcutta")
	private Date concessionDialysisCertificateDate;
	private Integer concessionDialysisTransferPeriodFlag;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Calcutta")
	private Date concessionDialysisValidityDate;
	private String concessionDialysisPDF;
	private String concessionCancerCertificateNumber;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Calcutta")
	private Date concessionCancerCertificateDate;
	private Integer concessionCancerTransferPeriodFlag;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Calcutta")
	private Date concessionCancerValidityDate;
	private String concessionCancerPDF;
	private String concessionSoldierCertificateNumber;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Calcutta")
	private Date concessionSoldierCertificateDate;
	private Integer concessionSoldierTransferPeriodFlag;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Calcutta")
	private Date concessionSoldierValidityDate;
	private String concessionSoldierPDF;
	private String concessionWidowCertificateNumber;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Calcutta")
	private Date concessionWidowCertificateDate;
	private Integer concessionWidowTransferPeriodFlag;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Calcutta")
	private Date concessionWidowValidityDate;
	private String concessionWidowPDF;
	private String concessionVestalCertificateNumber;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Calcutta")
	private Date concessionVestalCertificateDate;
	private Integer concessionVestalTransferPeriodFlag;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Calcutta")
	private Date concessionVestalValidityDate;
	private String concessionVestalPDF;
	private String concessionDivorceCertificateNumber;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Calcutta")
	private Date concessionDivorceCertificateDate;
	private Integer concessionDivorceTransferPeriodFlag;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Calcutta")
	private Date concessionDivorceValidityDate;
	private String concessionDivorcePDF;
	private Integer concession53YearCompletedSetFlag;
	private String concessionHusbandWifeAggregationAppointmentLevelID;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Calcutta")
	private Date concessionHusbandWifeAggregationWorkingDate;
	private String concessionHusbandWifeAggregationPDF;
	private String concessionFreedomFighterName;
	private String concessionFreedomFighterRelation;
	private Integer concessionFreedomFighterIsLiveFlag;
	private String concessionFreedomFighterPDF;
	
	@OneToOne
	@JoinColumn(table = "concession_details", name ="employeeId", insertable = false, updatable = false)
	private Employee employee;
	
	@OneToOne
	@JoinColumn(table = "concession_details", name ="employeeId", insertable = false, updatable = false)
	private EmployeeWorklocation employeeWorkLocation;
	
	@OneToOne
	@JoinColumn(table = "concession_details", name ="employeeId", insertable = false, updatable = false)
	private EmployeeCastDetails employeeCastDetails;
}
