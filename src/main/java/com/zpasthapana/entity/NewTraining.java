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
@Table(name = "new_training")
public class NewTraining extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long employeeId;
	private Integer newTrainingeFlag;
	private String newTrainingeName;
	private Date newTrainingFromDate;
	private Date newTrainingToDate;
	private String newTrainingDetails;
	
	@OneToOne
	@JoinColumn(table = "new_training", name ="employeeId", insertable = false, updatable = false)
	private Employee employee;
}
