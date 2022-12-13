package com.zpasthapana.pojo;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceSegmentRequest extends BaseRequest{
	private Integer serviceSegmentsDuringServicePeriodFlag;
	private String serviceSegmentsDuringServicePeriodDateOfOrder;
	private String serviceSegmentsDuringServicePeriodstartDate;
	private String serviceSegmentsDuringServicePeriodDetails;
	private MultipartFile serviceSegmentsDuringServicePeriodOrderPDF;
	private String serviceSegmentsDuringServicePeriodOrderNumber;
	private String serviceSegmentsDuringServicePeriodendLastDate;
	private Long employeeId;
}
