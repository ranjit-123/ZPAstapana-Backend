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
public class NewTransferRequest extends BaseRequest {
	private Long id;
	private Long employeeId;
	private Integer transferTypeFlag;
	private Integer transferReasonFlag;
	private Integer interDistrictTransferFlag;
	private Integer transferOrderNumber;
	private Date transferOrderDate;
	private MultipartFile transferOrderPDF;
	private Date lastServiceDate;
	private Integer addNewPromotionTravelPeriodFlag;
	private Integer holidayPeriodFlag;
	private Date dateOfTravelPeriodStart;
	private Date dateOfTravelPeriodEnd;
	private Date holidayPerioddateOfTravelPeriodStart;
	private Date holidayPerioddateOfTravelPeriodEnd;
	private Date dateOfPromotionAppointment;
	private Long talukaID;
	private Long subDivisionID;
	private Long subDepartmentId;
}
