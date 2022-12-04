package com.zpasthapana.service;

import java.util.List;

import com.zpasthapana.entity.AccidentalInsurance;
import com.zpasthapana.pojo.AccidentalInsuranceRequest;

public interface AccidentalInsuranceService {
	public void addAccidentalInsurance(AccidentalInsuranceRequest request);
	public List<AccidentalInsurance> getAllAccidentalInsurance();
	public List<AccidentalInsurance> getEmployeeAccidentalInsurance(Long employeeId);
	public void updateAccidentalInsurance(Long employeeId, AccidentalInsuranceRequest request);
}
