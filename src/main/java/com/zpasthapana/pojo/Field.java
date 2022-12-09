package com.zpasthapana.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Field {
	private String data;
	private String name;
	private boolean searchable;
	private boolean orderable;
}
