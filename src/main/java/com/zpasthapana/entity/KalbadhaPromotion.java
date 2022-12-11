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
@Table(name = "kalbadha_promotion")
public class KalbadhaPromotion extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer addKalbadhaPromotionRegularPromotionsFlag;
	private Integer addKalbadhaPromotioneEployeeSelectionCategoryIDFlag;
	private String addKalbadhaPromotionGrade;
	private Date kalbadhaPromotionApplyDate;
	private Integer addKalbadhaPromotionDisignation;
	private Integer addKalbadhaPromotionPayCommission;
	private String addKalbadhaPromotionOrderNumber;
	private Date addKalbadhaPromotionOrderDate;
	private String addKalbadhaPromotionPDF;
	private Long employeeId;
	
	@OneToOne
	@JoinColumn(table = "kalbadha_promotion", name ="employeeId", insertable = false, updatable = false)
	private Employee employee;
	
	@OneToOne
	@JoinColumn(table = "kalbadha_promotion", name ="employeeId", insertable = false, updatable = false)
	private EmployeeWorklocation employeeWorkLocation;
	
	@OneToOne
	@JoinColumn(table = "kalbadha_promotion", name ="employeeId", insertable = false, updatable = false)
	private EmployeeCastDetails employeeCastDetails;
}
