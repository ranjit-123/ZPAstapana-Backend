package com.zpasthapana.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdditionalServiceRequest extends BaseRequest{
	private Long employeeId;
	private Integer additionalZPServiceFlag;
	private String additionalZPServiceDateOfOrder;
	private String additionalZPServiceendLastDate;
	private String additionalZPServicestartDate;
	private String additionalZPServiceDetails;
	private Long additionalZPServiceOrderNumber;
}
