package com.zpasthapana.pojo;

import java.util.Objects;

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
public class ZPBean {
	private Integer zpId;
	private Integer designationId;
	@Override
	public int hashCode() {
		return Objects.hash(designationId, zpId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZPBean other = (ZPBean) obj;
		return Objects.equals(designationId, other.designationId) && Objects.equals(zpId, other.zpId);
	}
}
