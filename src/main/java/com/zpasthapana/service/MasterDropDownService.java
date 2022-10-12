package com.zpasthapana.service;

import java.util.List;

import com.zpasthapana.pojo.MasterDropDownPojo;

public interface MasterDropDownService {


	List<MasterDropDownPojo> getDetails(String type, Integer id);
}
