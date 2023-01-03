package com.zpasthapana.pojo;

import java.util.List;

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
public class ZPMajurPadereportWrapper {
	private List<ZPMajurPadereport> varg3;
	private List<ZPMajurPadereport> varg4;
	private ZPMajurPadereport total;
}
