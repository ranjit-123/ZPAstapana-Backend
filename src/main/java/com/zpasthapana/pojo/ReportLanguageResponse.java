package com.zpasthapana.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReportLanguageResponse {
	public String designation;
    public String totalWorkingEmployee;
    public String marathiPass;
    public String marathiSut;
    public String marathiNotPass;
    public String marathiTotal;
    public String hindiPass;
    public String hindiSut;
    public String hindiNotPass;
    public String hindiTotal;
}
