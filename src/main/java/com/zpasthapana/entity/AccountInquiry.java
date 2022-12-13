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
@Table(name = "account_inquiry")
public class AccountInquiry extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long employeeId;
	private Date memoDate;
	private Integer memoNumber;
	private Date memoGivenDate;
	private String accusationsHeld;
	private String currentCondition;
	private Integer presentAtWork;
	private Integer caseInCourt;
	private Integer inquiryOfficerPlacementNo;
	private Date inquiryOfficerPlacementDate;
	private Date actualReceivedDate;
	private Date lastDate;
	private String punishmentOrderNo;
	private Date punishmentOrderDate;
	private String punishmentPdf;
	private String finalPunishment;
	private Integer implementationDone;
	private String serviceBookNoteDetails;
	private String punishmentCopy;
	private Integer rbtnFirstAppealAgainstOrderFlag;
	private Date firstAppealDate;
	private Date firstAppealResultDate;
	private String firstAppealCondition;
	private Integer upperCommissionerApplication;
	private Date apperComAppDate;
	private Date apperComAppResultDate;
	private String apperComAppCondition;
	private Integer punishmentAppealedInCourt;
	private Date appealedDate;
	private Date appealedResultDate;
	private String appealedCondition;
	
	@OneToOne
	@JoinColumn(table = "account_inquiry", name ="employeeId", insertable = false, updatable = false)
	private Employee employee;
	
}
