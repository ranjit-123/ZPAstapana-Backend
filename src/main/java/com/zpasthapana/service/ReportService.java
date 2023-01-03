package com.zpasthapana.service;

import java.util.List;

import com.zpasthapana.pojo.ZPMajurPadereport;
import com.zpasthapana.pojo.ZPMajurPadereportWrapper;

public interface ReportService {

	ZPMajurPadereportWrapper getMajurPadeReport(Long userId);

	List<ZPMajurPadereport> getMajurPadeDepartMentWiseReport(Long userId);
	
}
