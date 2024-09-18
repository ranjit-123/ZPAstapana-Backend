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
@Table(name = "concession_details")
public class ConcessionDetails extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long employeeId;
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
	private Date concessionBrainCertificateDate;
	private Integer concessionBrainTransferPeriodFlag;
	private Date concessionBrainValidityDate;
	private String concessionBrainPDF;
	private String concessionParalysisCertificateNumber;
	private Date concessionParalysisCertificateDate;
	private Integer concessionParalysisTransferPeriodFlag;
	private Date concessionParalysisValidityDate;
	private String concessionParalysisPDF;
	private String concessionHandicappeCertificateNumber;
	private Date concessionHandicappeCertificateDate;
	private Integer concessionHandicappeTransferPeriodFlag;
	private Date concessionHandicappeValidityDate;
	private String concessionHandicappePDF;
	private String concessionCardiacSurgeryCertificateNumber;
	private Date concessionCardiacSurgeryCertificateDate;
	private Integer concessionCardiacSurgeryTransferPeriodFlag;
	private Date concessionCardiacSurgeryValidityDate;
	private String concessionCardiacSurgeryPDF;
	private String concessionDialysisCertificateNumber;
	private Date concessionDialysisCertificateDate;
	private Integer concessionDialysisTransferPeriodFlag;
	private Date concessionDialysisValidityDate;
	private String concessionDialysisPDF;
	private String concessionCancerCertificateNumber;
	private Date concessionCancerCertificateDate;
	private Integer concessionCancerTransferPeriodFlag;
	private Date concessionCancerValidityDate;
	private String concessionCancerPDF;
	private String concessionSoldierCertificateNumber;
	private Date concessionSoldierCertificateDate;
	private Integer concessionSoldierTransferPeriodFlag;
	private Date concessionSoldierValidityDate;
	private String concessionSoldierPDF;
	private String concessionWidowCertificateNumber;
	private Date concessionWidowCertificateDate;
	private Integer concessionWidowTransferPeriodFlag;
	private Date concessionWidowValidityDate;
	private String concessionWidowPDF;
	private String concessionVestalCertificateNumber;
	private Date concessionVestalCertificateDate;
	private Integer concessionVestalTransferPeriodFlag;
	
	private Date concessionVestalValidityDate;
	private String concessionVestalPDF;
	private String concessionDivorceCertificateNumber;
	
	private Date concessionDivorceCertificateDate;
	private Integer concessionDivorceTransferPeriodFlag;
	
	private Date concessionDivorceValidityDate;
	private String concessionDivorcePDF;
	private Integer concession53YearCompletedSetFlag;
	private String concessionHusbandWifeAggregationAppointmentLevelID;
	
	private Date concessionHusbandWifeAggregationWorkingDate;
	private String concessionHusbandWifeAggregationPDF;
	private String concessionFreedomFighterName;
	private String concessionFreedomFighterRelation;
	private Integer concessionFreedomFighterIsLiveFlag;
	private String concessionFreedomFighterPDF;
	private String concessionHusbandWifeAggregationFullName;
	private String concessionHusbandWifeAggregationFalimlyPhotoPDF;
	
	@OneToOne
	@JoinColumn(table = "concession_details", name ="employeeId", insertable = false, updatable = false)
	private Employee employee;
	
}
