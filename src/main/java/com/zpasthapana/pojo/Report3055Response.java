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
public class Report3055Response {
	public String designation;
	public Integer age30Completed;
	public Integer age55Completed;
	public Integer total30Plus55;
	public Integer reviewedEmployees;
	public Integer notReviewedEmployees;
	private Long designationId;
}
