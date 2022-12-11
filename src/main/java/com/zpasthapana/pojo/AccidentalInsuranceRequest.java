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
public class AccidentalInsuranceRequest extends BaseRequest{
	private MultipartFile insurancePdf;
	private String premiumPaidDate;
	private double premium;
	private Integer isRegistedForInsurance;
	private Long employeeId;
}
