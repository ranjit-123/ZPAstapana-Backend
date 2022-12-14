package com.zpasthapana.pojo;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UIPageRequest {
	private List<SortField> sortFields = new ArrayList<SortField>();
	private int pageNumber;
	private int pageSize;
	private Long talukaId;
	private Long devisionId;
	private Long departmentId;
	private Long zpId;
	private Long properOfficeID;
}