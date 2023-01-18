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
@Table(name = "extra_ordinary_leaves")
public class ExtraOrdinaryLeaves extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String leaveOrderNumber;
	private Date leaveDate;
	private String leavePdf;
	private Long employeeId;
	
	private String leaveDetails;
	private Integer leaveType;
	private Date startDate;
	private Date endDate;
	private Integer numberOfLeaves;
	private Integer balaceBeforeLeave;
	private Integer balaceAfterLeave;
	
	
	@OneToOne
	@JoinColumn(table = "extra_ordinary_leaves", name ="employeeId", insertable = false, updatable = false)
	private Employee employee;
	
}
