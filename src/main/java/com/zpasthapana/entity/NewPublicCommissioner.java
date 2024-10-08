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
@Table(name = "new_public_commissioner")
public class NewPublicCommissioner extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long stateId;
	private Long divisionId;
	private Long zpId;
	private Long departmentId;
	private Long designationId;
	private String complainantName;
	private String referenceNo;
	private Date referenceDate;
	private Date receivedDate;
	private String complaint;
	private Integer isMidReportSubmitted;
	private Date midReportSubmittedDate;
	private String midReportDescription;
	private Integer isFinalReportSubmitted;
	private Date finalReportDate;
	private String finalReportDescription;
	private Integer isFinalised;
	private Date finalisedDate;
	
}
