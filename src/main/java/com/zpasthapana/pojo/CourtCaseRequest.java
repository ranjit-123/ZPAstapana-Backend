package com.zpasthapana.pojo;

import java.util.Date;

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
	private Date caseStartDate;
	private Integer caseNumber;
	private String caseDetails;
	private String districtName;
	private Integer courtName;
	private Date resultDate;
	private MultipartFile resultPdf;
	private String courtResult;
	private Integer courtResultImplemented;
	private String whichActionTaken;
	private Date actionTakenDate;
	private Long employeeId;
}
