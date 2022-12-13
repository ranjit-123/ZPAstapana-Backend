package com.zpasthapana.pojo;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountInquiryRequest extends BaseRequest{
	private Long id;
	private Long employeeId;
	private String memoDate;
	private Integer memoNumber;
	private String memoGivenDate;
	private String accusationsHeld;
	private String currentCondition;
	private Integer presentAtWork;
	private Integer caseInCourt;
	private Integer inquiryOfficerPlacementNo;
	private String inquiryOfficerPlacementDate;
	private String actualReceivedDate;
	private String lastDate;
	private String punishmentOrderNo;
	private String punishmentOrderDate;
	private MultipartFile punishmentPdf;
	private String finalPunishment;
	private Integer implementationDone;
	private String serviceBookNoteDetails;
	private MultipartFile punishmentCopy;
	private Integer rbtnFirstAppealAgainstOrderFlag;
	private String firstAppealDate;
	private String firstAppealResultDate;
	private String firstAppealCondition;
	private Integer upperCommissionerApplication;
	private String apperComAppDate;
	private String apperComAppResultDate;
	private String apperComAppCondition;
	private Integer punishmentAppealedInCourt;
	private String appealedDate;
	private String appealedResultDate;
	private String appealedCondition;
}
