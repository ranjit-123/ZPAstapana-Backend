package com.zpasthapana.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReportData {
	String field1;
	String field2;
	String field3;
	String field4;
	@JsonInclude(content = Include.NON_NULL)
	String field5;
	@JsonInclude(content = Include.NON_NULL)
	String field6;
	@JsonInclude(content = Include.NON_NULL)
	String field7;
	@JsonInclude(content = Include.NON_NULL)
	String field8;
	@JsonInclude(content = Include.NON_NULL)
	String field9;
	@JsonInclude(content = Include.NON_NULL)
	String field10;
	@JsonInclude(content = Include.NON_NULL)
	String field11;
	@JsonInclude(content = Include.NON_NULL)
	String field12;
	@JsonInclude(content = Include.NON_NULL)
	String field13;
	@JsonInclude(content = Include.NON_NULL)
	String field14;
	@JsonInclude(content = Include.NON_NULL)
	String field15;
}
