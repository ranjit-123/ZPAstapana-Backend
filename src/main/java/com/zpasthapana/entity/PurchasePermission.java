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
@Table(name = "purchase_permission")
public class PurchasePermission extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String purchaseOrderNumber;
	private Date orderDate; 
	private String purchaseOrderPdf;
	private String purchaseDetails;
	private Long employeeId;
	
	@OneToOne
	@JoinColumn(table = "purchase_permission", name ="employeeId", insertable = false, updatable = false)
	private Employee employee;
}                                           
