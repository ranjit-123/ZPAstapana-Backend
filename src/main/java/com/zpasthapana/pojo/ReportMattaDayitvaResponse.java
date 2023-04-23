package com.zpasthapana.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReportMattaDayitvaResponse {
	public String designation;
	public Integer workingEmployeeA;
	public Integer workingEmployeeB;
	public Integer workingEmployeeC;
	public Integer workingEmployeeTotal;
	public Integer mattaDayitvaSubmittedA;
	public Integer mattaDayitvaSubmittedB;
	public Integer mattaDayitvaSubmittedC;
	public Integer mattaDayitvaSubmittedTotal;
	public Integer mattaDayitvaNotSubmittedA;
	public Integer mattaDayitvaNotSubmittedB;
	public Integer mattaDayitvaNotSubmittedC;
	public Integer mattaDayitvaNotSubmittedTotal;
	public String comment;
}
