package com.zpasthapana.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ZPMajurPadereport implements Comparable<ZPMajurPadereport>{
	private Integer pad;
	private String padName;
	@Default
	private Integer item[] = new Integer[]{0,0,0,0,0,0,0,0,0,0,0,0};
	@Override
	public int compareTo(ZPMajurPadereport o) {
		return this.getPad() - o.getPad();
	}
}
