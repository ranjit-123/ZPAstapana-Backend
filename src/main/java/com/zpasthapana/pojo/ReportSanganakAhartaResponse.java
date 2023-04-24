package com.zpasthapana.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReportSanganakAhartaResponse {
	public String designation;
	public Integer totalEmployee;
	public Integer pass;
	public Integer notApplicable;
	public Integer total;
	public Integer notQualified;
	private Integer notQualifiedNotApplicable;
}
