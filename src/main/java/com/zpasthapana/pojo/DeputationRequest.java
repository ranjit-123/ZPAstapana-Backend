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
	private String commissionerOrderNumber;
	private String commissionerOrderDate;
	private MultipartFile commissionerOrderPdf;
	private Integer deputationSection;
	private Integer cmbSubDivisionID;
	private Integer cmbProperOfficeID;
	private String deputationEndOrderNumber;
	private String deputationEndOrderDate;
	private MultipartFile deputationEndPdf;
	private String deputationServiceEndDate;
	private String dtpDateOfRegularOfficeRejoining;
	private Integer deputationType;
	private String deputationEmployeeName;
	private String deputationOfficeName;
	private String usanvariOrderNumber;
	private String usanvariOrderDate;
	private String karyamuktaDate;
	private String hajarDate;
	private String paymentOffice;
	private String usanvaricheOffice;
	private Long employeeId;
}
