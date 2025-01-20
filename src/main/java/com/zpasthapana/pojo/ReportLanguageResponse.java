package com.zpasthapana.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReportLanguageResponse {
	public String designation;
    public Integer totalWorkingEmployee;
    public Integer marathiPass;
    public Integer marathiSut;
    public Integer marathiNotPass;
    public Integer marathiTotal;
    public Integer hindiPass;
    public Integer hindiSut;
    public Integer hindiNotPass;
    public Integer hindiTotal;
    private Long designationId;
}
