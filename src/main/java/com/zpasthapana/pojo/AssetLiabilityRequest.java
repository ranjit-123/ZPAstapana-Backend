package com.zpasthapana.pojo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AssetLiabilityRequest extends BaseRequest{
	private Long id;
	private String isAssetLiabilitySubmitted;
	private String financialYear;
	private Date submissionDate;
	private String whomToSubmitted;
	private MultipartFile depositedLetterPdf;
	private Long employeeId;
}
