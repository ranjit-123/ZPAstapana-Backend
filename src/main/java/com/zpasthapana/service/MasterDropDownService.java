package com.zpasthapana.service;

import java.util.List;
import java.util.Map;

import com.zpasthapana.pojo.MasterDropDownPojo;

public interface MasterDropDownService {
	List<MasterDropDownPojo> getDetails(String type, Integer id);

	List<MasterDropDownPojo> getDetails(Map<String, String> queryParam);
}
