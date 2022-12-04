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
public class DeputationRequest extends BaseRequest{
	private String deputationOrderNumber;
	private String deputationDate;
	private String deputationOfficeDate;
	private MultipartFile deputationPdf;
	private String deputationReason;
	private Integer commissionerPermission;
	private Integer commissionerOrderNumber;
	private String commissionerOrderDate;
	private MultipartFile commissionerOrderPdf;
	private Integer deputationSection;
	private Integer cmbSubDivisionID;
	private Integer cmbProperOfficeID;
	private Integer deputationEndOrderNumbe;
	private String deputationEndOrderDate;
	private MultipartFile deputationEndPdf;
	private String deputationServiceEndDate;
	private String dtpDateOfRegularOfficeRejoining;
	private Long employeeId;
}
