package com.zpasthapana.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "new_transfer")
public class NewTransfer extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long employeeId;
	private Integer transferTypeFlag;
	private Integer transferReasonFlag;
	private Integer interDistrictTransferFlag;
	private Integer transferOrderNumber;
	private Date transferOrderDate;
	private String transferOrderPDF;
	private Date lastServiceDate;
	private Integer addNewPromotionTravelPeriodFlag;
	private Integer holidayPeriodFlag;
	private Date dateOfTravelPeriodStart;
	private Date dateOfTravelPeriodEnd;
	private Date holidayPerioddateOfTravelPeriodStart;
	private Date holidayPerioddateOfTravelPeriodEnd;
	private Date dateOfPromotionAppointment;
	private Integer talukaID;
	private Integer subDivisionID;
	private Integer subDepartmentId;
	
	@OneToOne
	@JoinColumn(table = "new_transfer", name ="employeeId", insertable = false, updatable = false)
	private Employee employee;
	
	@OneToOne
	@JoinColumn(table = "new_transfer", name ="employeeId", insertable = false, updatable = false)
	private EmployeeWorklocation employeeWorkLocation;
	
	@OneToOne
	@JoinColumn(table = "new_transfer", name ="employeeId", insertable = false, updatable = false)
	private EmployeeCastDetails employeeCastDetails;

}
