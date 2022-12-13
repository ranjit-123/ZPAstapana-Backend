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
@Table(name = "apprentice_notice")
public class ApprenticeNotice extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long employeeId;
	private Integer apprenticePeriodFlag;
	private String apprenticePeriodOrderNumber;
	private Date apprenticePeriodOrderDate;
	private String apprenticePeriodOrderPDF;
	private Date apprenticePeriodApplyDate;
	
	@OneToOne
	@JoinColumn(table = "apprentice_notice", name ="employeeId", insertable = false, updatable = false)
	private Employee employee;
}
