package com.zpasthapana.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.zpasthapana.entity.StayitvaPramanpatra;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.StayitvaPramanpatraRequest;
import com.zpasthapana.pojo.UIPageRequest;

public interface StayitvaPramanpatraService {

	void addStayitvaPramanpatra(StayitvaPramanpatraRequest request);

	ResponsePageDto<StayitvaPramanpatra> getAllStayitvaPramanpatra(UIPageRequest pageRequest, Pageable paging);

	List<StayitvaPramanpatra> getEmployeeStayitvaPramanpatra(Long employeeId);

	void updateStayitvaPramanpatra(Long employeeId, StayitvaPramanpatraRequest request);

	List<StayitvaPramanpatra> getAllStayitvaPramanpatra();

}
