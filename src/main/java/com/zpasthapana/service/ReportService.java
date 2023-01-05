package com.zpasthapana.service;

import java.util.List;

import com.zpasthapana.pojo.BinduNamavaliReport;
import com.zpasthapana.pojo.JestatechaReport;
import com.zpasthapana.pojo.ZPMajurPadereport;
import com.zpasthapana.pojo.ZPMajurPadereportWrapper;

public interface ReportService {

	ZPMajurPadereportWrapper getMajurPadeReport(Long userId);

	List<ZPMajurPadereport> getMajurPadeDepartMentWiseReport(Long userId);

	ZPMajurPadereportWrapper getMajurPadeReportByDepartMentId(Long userId, Long departmentId);

	ZPMajurPadereportWrapper getMajurPadeReportHandicap(Long userId);

	ZPMajurPadereportWrapper getMajurPadeReportByDepartMentIdHandicap(Long userId, Long departmentId);

	List<ZPMajurPadereport> getMajurPadeDepartMentWiseReportHandicap(Long userId);

	List<JestatechaReport> getJestatechaReport(Long userId, String type, Integer designationId);

	List<BinduNamavaliReport> getBindunamavaliReport(Long userId, String type, Integer designationId);
	
}
