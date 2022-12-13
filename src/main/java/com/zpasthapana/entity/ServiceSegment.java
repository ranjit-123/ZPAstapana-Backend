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
@Table(name = "service_segment")
public class ServiceSegment extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer serviceSegmentsDuringServicePeriodFlag;
	private Date serviceSegmentsDuringServicePeriodDateOfOrder;
	private Date serviceSegmentsDuringServicePeriodstartDate;
	private String serviceSegmentsDuringServicePeriodDetails;
	private String serviceSegmentsDuringServicePeriodOrderPDF;
	private String serviceSegmentsDuringServicePeriodOrderNumber;
	private Date serviceSegmentsDuringServicePeriodendLastDate;
	private Long employeeId;
	
	@OneToOne
	@JoinColumn(table = "service_segment", name ="employeeId", insertable = false, updatable = false)
	private Employee employee;
}
