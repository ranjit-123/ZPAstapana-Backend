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
public class ZPDesAndCategoryBean {
	private Integer designationId;
	private Integer categoryId;
	@Override
	public int hashCode() {
		return Objects.hash(categoryId, designationId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZPDesAndCategoryBean other = (ZPDesAndCategoryBean) obj;
		return Objects.equals(categoryId, other.categoryId) && Objects.equals(designationId, other.designationId);
	}
}
