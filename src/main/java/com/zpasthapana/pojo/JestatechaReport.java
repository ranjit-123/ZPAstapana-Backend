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
	private String jeshtataNumber;
	private String name;
	private String caste;
	private String mulJatPravarg;
	private String niyuktiPravarg;
	private String pravargChangeDate;
	private Date birthDate;
	private Date jeshtataManivDate;
	private Date hallichaNiyuktDinank;
	private Date sevaPaveshottarPassDate;
	private String niyuktichaMarg;
	private String degreeName;
	private String prathamPadonnatiNiyuktiDate;
	private String dvitiyaPadonnatiNiyuktiDate;
	private String trutiyaPadonnatiNiyuktiDate;
	private String prathamPadavarilDate;
	private String remark;
}
