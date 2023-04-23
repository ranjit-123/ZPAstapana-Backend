package com.zpasthapana.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReportStayitvaReponse {
	public String designation;
	public Integer totalWorkingEmpC;
	public Integer totalWorkingEmpD;
	public Integer totalWorkingEmpTotal;
	public Integer stayitvaEligibleEmpC;
	public Integer stayitvaEligibleEmpD;
	public Integer stayitvaEligibleEmpTotal;
	public Integer stayitvaReceivedEmpC;
	public Integer stayitvaReceivedEmpD;
	public Integer stayitvaReceivedEmpTotal;
	public Integer stayitvaNotReceivedEmpC;
	public Integer stayitvaNotReceivedEmpD;
	public Integer stayitvaNotReceivedEmpTotal;
	public String comment;
}
