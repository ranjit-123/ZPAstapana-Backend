package com.zpasthapana.service;

import java.util.List;

import com.zpasthapana.pojo.AbsenceReport;
import com.zpasthapana.pojo.BinduNamavaliReport;
import com.zpasthapana.pojo.JestatechaReport;
import com.zpasthapana.pojo.Report3055Response;
import com.zpasthapana.pojo.ReportData;
import com.zpasthapana.pojo.ReportGopaniyAhvalResponse;
import com.zpasthapana.pojo.ReportLanguageResponse;
import com.zpasthapana.pojo.ReportMattaDayitvaResponse;
import com.zpasthapana.pojo.ReportSanganakAhartaResponse;
import com.zpasthapana.pojo.ReportSevaNivrutDepartmentLevelResponse;
import com.zpasthapana.pojo.ReportSevaNivrutResponse;
import com.zpasthapana.pojo.ReportStayitvaEmpListResponse;
import com.zpasthapana.pojo.ReportStayitvaReponse;
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

	List<AbsenceReport> getUnAuthorisedAbsenceReport(Long userId, Integer departmentId);

	List<ReportData> getUnAuthorisedAbsenceReport1(Long userId, Integer departmentId);

	List<ReportSevaNivrutResponse> getRetirementCases(Long userId, Integer departmentId);

	List<ReportSevaNivrutDepartmentLevelResponse> getRetirementCasesAll(Long userId, String type);

	List<ReportMattaDayitvaResponse> getMattadayitvaAll(Long userId, String year, Long departmentId);

	List<ReportGopaniyAhvalResponse> getGopaniyAhvalAll(Long userId, String year, Long departmentId);

	List<ReportStayitvaReponse> getStayitvaReportAll(Long userId, String year, Long departmentId);

	List<ReportSanganakAhartaResponse> getComputerQualificationReportAll(Long userId, String year, Long departmentId);

	List<ReportLanguageResponse> getHindiMarathiReportAll(Long userId, String year, Long departmentId);

	List<Report3055Response> getEmployee3055Report(Long userId, String year, Long departmentId);

	List<ReportStayitvaEmpListResponse> getStayitvaReportWithDesignation(Long userId, Long departmentId);
	
}
