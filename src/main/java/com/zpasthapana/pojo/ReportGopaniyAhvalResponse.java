package com.zpasthapana.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReportGopaniyAhvalResponse {
	public String designation;
	public Integer allEmployeeA;
	public Integer allEmployeeB;
	public Integer allEmployeeC;
	public Integer allEmployeeTotal;
	public Integer confidentialDataSubmittedA;
	public Integer confidentialDataSubmittedB;
	public Integer confidentialDataSubmittedC;
	public Integer confidentialDataSubmittedTotal;
	public Integer confidentialNotSubmittedA;
	public Integer confidentialNotSubmittedB;
	public Integer confidentialNotSubmittedC;
	public Integer confidentialNotSubmittedTotal;
	public Integer confidentialUpdatedA;
	public Integer confidentialUpdatedB;
	public Integer confidentialUpdatedC;
	public Integer confidentialUpdatedTotal;
	public Integer confidentialNotUpdatedA;
	public Integer confidentialNotUpdatedB;
	public Integer confidentialNotUpdatedC;
	public Integer confidentialNotUpdatedTotal;
}
