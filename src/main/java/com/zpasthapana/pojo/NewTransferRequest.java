package com.zpasthapana.pojo;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewTransferRequest extends BaseRequest {
	private Long id;
	private Long employeeId;
	private Integer transferTypeFlag;
	private Integer transferReasonFlag;
	private Integer interDistrictTransferFlag;
	private Integer transferOrderNumber;
	private String transferOrderDate;
	private MultipartFile transferOrderPDF;
	private String lastServiceDate;
	private Integer addNewPromotionTravelPeriodFlag;
	private Integer holidayPeriodFlag;
	private String dateOfTravelPeriodStart;
	private String dateOfTravelPeriodEnd;
	private String holidayPerioddateOfTravelPeriodStart;
	private String holidayPerioddateOfTravelPeriodEnd;
	private String dateOfPromotionAppointment;
	private Long talukaID;
	private Long subDivisionID;
	private Long subDepartmentId;
}
