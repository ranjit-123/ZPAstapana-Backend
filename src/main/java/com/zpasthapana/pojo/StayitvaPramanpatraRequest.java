package com.zpasthapana.pojo;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StayitvaPramanpatraRequest extends BaseRequest{
	private Integer isAppealed;
	private String sthaetvanumber;
	private String sthaetvOrderDate;
	private String sthaetvOrderactualpassDate;
	private MultipartFile sthaetvapramanpatraPDF;
	private Long employeeId;
}

