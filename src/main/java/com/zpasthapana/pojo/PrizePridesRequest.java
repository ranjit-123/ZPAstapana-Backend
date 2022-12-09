package com.zpasthapana.pojo;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrizePridesRequest extends BaseRequest{
	private Long id;
	private String prizeDate;
	private MultipartFile prizePdf;
	private String prizeDetails;
	private Long employeeId;
}
