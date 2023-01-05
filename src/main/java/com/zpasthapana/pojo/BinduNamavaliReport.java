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
public class BinduNamavaliReport {
	private String bharatiVarsh;
	private String kramank;
	private String arakshan;
	private String name;
	private String jat;
	private String jatichaPravarg;
	private String nemnukichaPravarg;
	private String jatPramanpatraKramank;
	private String jatPramanpatraDinak;
	private String jatPramanpatraDenareAdhikari;
	private String jatVaidhataKramank;
	private String jatVaidhataDinak;
	private String jatVaidhataSamiti;
	private String niyuktichaDinank;
	private String niyuktichaMahina;
	private String niyukticheVarsh;
	private String mulNiyuktichaDinank;
	private String mulNiyuktichaMahina;
	private String mulNiyukticheVarsh;
	private String janmDinank;
	private String janmMahina;
	private String janmVarsh;
	private String sevaNivrutDinank;
	private String sevaNivrutMahina;
	private String sevaNivrutVarsh;
	private String retirementReason;
	private Date dateOfHumanitySeniority;
	private Integer employeeDesiganationId;
	
	private Date dateOfAppointed;
	private Date retirementDate;
	private String niyuktichaMarg;
	private String degreeName;
	private Date prathamPadonnatiDinak;
	private Date dwitiyPadonnatiDinak;
	private Date tritiyPadonnatiDinak;
}
