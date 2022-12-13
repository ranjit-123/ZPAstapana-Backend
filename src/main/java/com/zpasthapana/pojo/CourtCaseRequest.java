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
public class CourtCaseRequest extends BaseRequest{
	private Long id;
	private String caseStartDate;
	private Integer caseNumber;
	private String caseDetails;
	private String districtName;
	private Integer courtName;
	private String resultDate;
	private MultipartFile resultPdf;
	private String courtResult;
	private Integer courtResultImplemented;
	private String whichActionTaken;
	private String actionTakenDate;
	private Long employeeId;
}
