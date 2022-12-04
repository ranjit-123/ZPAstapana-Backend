package com.zpasthapana.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class ConcessionDetails extends BaseEntity{
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
	private Integer concessionBrainCertificateNumber;
	private Date concessionBrainCertificateDate;
	private String concessionBrainTransferPeriodFlag;
	private Date concessionBrainValidityDate;
	private String concessionBrainPDF;
	private Integer concessionParalysisCertificateNumber;
	private Date concessionParalysisCertificateDate;
	private String concessionParalysisTransferPeriodFlag;
	private Date concessionParalysisValidityDate;
	private String concessionParalysisPDF;
	private Integer concessionHandicappeCertificateNumber;
	private Date concessionHandicappeCertificateDate;
	private String concessionHandicappeTransferPeriodFlag;
	private Date concessionHandicappeValidityDate;
	private String concessionHandicappePDF;
	private Integer concessionCardiacSurgeryCertificateNumber;
	private Date concessionCardiacSurgeryCertificateDate;
	private String concessionCardiacSurgeryTransferPeriodFlag;
	private Date concessionCardiacSurgeryValidityDate;
	private String concessionCardiacSurgeryPDF;
	private Integer concessionDialysisCertificateNumber;
	private Date concessionDialysisCertificateDate;
	private String concessionDialysisTransferPeriodFlag;
	private Date concessionDialysisValidityDate;
	private String concessionDialysisPDF;
	private Integer concessionCancerCertificateNumber;
	private Date concessionCancerCertificateDate;
	private String concessionCancerTransferPeriodFlag;
	private Date concessionCancerValidityDate;
	private String concessionCancerPDF;
	private Integer concessionSoldierCertificateNumber;
	private Date concessionSoldierCertificateDate;
	private String concessionSoldierTransferPeriodFlag;
	private Date concessionSoldierValidityDate;
	private String concessionSoldierPDF;
	private Integer concessionWidowCertificateNumber;
	private Date concessionWidowCertificateDate;
	private String concessionWidowTransferPeriodFlag;
	private Date concessionWidowValidityDate;
	private String concessionWidowPDF;
	private Integer concessionVestalCertificateNumber;
	private Date concessionVestalCertificateDate;
	private String concessionVestalTransferPeriodFlag;
	private Date concessionVestalValidityDate;
	private String concessionVestalPDF;
	private Integer concessionDivorceCertificateNumber;
	private Date concessionDivorceCertificateDate;
	private String concessionDivorceTransferPeriodFlag;
	private Date concessionDivorceValidityDate;
	private String concessionDivorcePDF;
	private String concession53YearCompletedSetFlag;
	private String concessionHusbandWifeAggregationAppointmentLevelID;
	private Date concessionHusbandWifeAggregationWorkingDate;
	private String concessionHusbandWifeAggregationPDF;
	private String concessionFreedomFighterName;
	private String concessionFreedomFighterRelation;
	private String concessionFreedomFighterIsLiveFlag;
	private String concessionFreedomFighterPDF;
}
