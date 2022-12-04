package com.zpasthapana.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccidentalInsuranceRequest extends BaseRequest{
	private String insurancePdf;
	private String premiumPaidDate;
	private double premium;
	private Integer isRegistedForInsurance;
	private Long employeeId;
}
