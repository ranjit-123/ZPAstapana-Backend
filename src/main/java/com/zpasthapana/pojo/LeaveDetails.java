package com.zpasthapana.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LeaveDetails {
	private String leaveDetails;
	private Integer leaveType;
	private Date startDate;
	private Date endDate;
	private Integer numberOfLeaves;
	private Integer balaceBeforeLeave;
	private Integer balaceAfterLeave;
}
