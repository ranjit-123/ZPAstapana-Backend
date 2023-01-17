package com.zpasthapana.pojo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExtraOrdinaryLeaveRequest extends BaseRequest{
	private Long id;
	private Integer leaveOrderNumber;
	private Date leaveDate;
	private MultipartFile leavePdf;
	private Long employeeId;
	private String leaves;
}
