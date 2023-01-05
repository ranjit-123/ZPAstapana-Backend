package com.zpasthapana.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JestatechaReport {
	private String kramank;
	private String name;
	private String jat;
	private String jatichaPravarg;
	private String nemnukichaPravarg;
	private String badalachaDinank;
	private Date dateOfBirth;
	private Date dateOfHumanitySeniority;
	private Date dateOfAppointed;
	private Date retirementDate;
	private String niyuktichaMarg;
	private String degreeName;
	private String prathamPadonnatiDinak;
	private String dwitiyPadonnatiDinak;
	private String tritiyPadonnatiDinak;
}
