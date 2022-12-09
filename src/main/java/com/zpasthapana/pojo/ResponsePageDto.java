package com.zpasthapana.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePageDto<T> {
	private List<T> data;
	private int draw;
	private long recordsFiltered;
	private long recordsTotal;
}