package com.zpasthapana.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReportAgeCompleteResponse {
	public String designation;
	public String age30Completed;
	public String age55Completed;
	public String total30Plus55;
	public String reviewedEmployees;
	public String notReviewedEmployees;
}
