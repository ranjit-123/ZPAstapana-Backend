package com.zpasthapana.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
}
