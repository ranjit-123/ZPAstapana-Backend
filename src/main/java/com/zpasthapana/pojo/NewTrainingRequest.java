package com.zpasthapana.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewTrainingRequest extends BaseRequest {
	private Long employeeId;
	private Integer newTrainingeFlag;
	private String newTrainingeName;
	private String newTrainingFromDate;
	private String newTrainingToDate;
	private String newTrainingDetails;
}
