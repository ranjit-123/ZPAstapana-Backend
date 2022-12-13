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
public class CriminalOffenceRequest extends BaseRequest {
	private Long employeeId;
	private String firDate;
	private String firNumber;
	private String districtName;
	private String policeStationName;
	private String crimeDetails;
	private Integer isSuspended;
	private Integer suspendCase;
	private String caseResult;
	private String resultDate;
	private MultipartFile resultPdf;
	private Integer courtResultImplemented;
	private String whichActionTaken;
	private String actionTakenDate;
}
