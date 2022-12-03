package com.zpasthapana.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee_typing_details")
public class EmployeeTypingDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeTypingDetailsId;
	private Long employeeId;
	private String typingFlag;
	private String marathiHindiFlag;
	private String marathiTypingSpeed;
	private String marathiTypingSpeedPassoutDate;
	private String marathiTypingSpeedDiscountDate;
	private String marathiTypingSpeedDiscountOrderDate;
	private String marathiTypingSpeedPDF;
	private String rbtnEnglishTypingFlag;
	private String englishTypingSpeed;
	private String englishTypingSpeedPassoutDate;
	private String englishTypingSpeedDiscountDate;
	private String englishTypingSpeedDiscountOrderDate;
	private String englishTypingSpeedPDF;
	
	private Long createdBy;
	private Long modifiedBy;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;
}
