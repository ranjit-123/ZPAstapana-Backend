package com.zpasthapana.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zpasthapana.entity.AccidentalInsurance;
import com.zpasthapana.entity.AccountInquiry;
import com.zpasthapana.entity.AdditionalService;
import com.zpasthapana.entity.ApprenticeNotice;
import com.zpasthapana.entity.AssetLiability;
import com.zpasthapana.entity.ConcessionDetails;
import com.zpasthapana.entity.Confidential;
import com.zpasthapana.entity.CourtCase;
import com.zpasthapana.entity.Crime;
import com.zpasthapana.entity.Deputation;
import com.zpasthapana.entity.Employee;
import com.zpasthapana.entity.EmployeeCastDetails;
import com.zpasthapana.entity.EmployeeComputerExamDetails;
import com.zpasthapana.entity.EmployeeDesiganation;
import com.zpasthapana.entity.EmployeeDisability;
import com.zpasthapana.entity.EmployeeEducation;
import com.zpasthapana.entity.EmployeeEducationDTO;
import com.zpasthapana.entity.EmployeeFlag;
import com.zpasthapana.entity.EmployeeJoinDetails;
import com.zpasthapana.entity.EmployeeLanguageExam;
import com.zpasthapana.entity.EmployeeNomineeDetails;
import com.zpasthapana.entity.EmployeeTypingDetails;
import com.zpasthapana.entity.EmployeeWorklocation;
import com.zpasthapana.entity.ExtraOrdinaryLeaves;
import com.zpasthapana.entity.KalbadhaPromotion;
import com.zpasthapana.entity.NewPromotion;
import com.zpasthapana.entity.NewTraining;
import com.zpasthapana.entity.NewTransfer;
import com.zpasthapana.entity.PrizePrides;
import com.zpasthapana.entity.PurchasePermission;
import com.zpasthapana.entity.RejectedPromotion;
import com.zpasthapana.entity.Retierment;
import com.zpasthapana.entity.ServiceSegment;
import com.zpasthapana.entity.StayitvaPramanpatra;
import com.zpasthapana.entity.Suspention;
import com.zpasthapana.entity.UnathorizedAbsencePeriod;
import com.zpasthapana.pojo.EmployeeRequest;
import com.zpasthapana.pojo.EmployeeResponse;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UIPageRequest;
import com.zpasthapana.repo.AccidentalInsuranceRepo;
import com.zpasthapana.repo.AccountInquiryRepo;
import com.zpasthapana.repo.AdditionalServiceRepo;
import com.zpasthapana.repo.ApprenticeNoticeRepo;
import com.zpasthapana.repo.AssetLiabilityRepo;
import com.zpasthapana.repo.ConcessionDetailsRepo;
import com.zpasthapana.repo.ConfidentialRepo;
import com.zpasthapana.repo.CourtCaseRepo;
import com.zpasthapana.repo.CrimeRepo;
import com.zpasthapana.repo.DeputationRepo;
import com.zpasthapana.repo.EmployeeCastDetailsRepo;
import com.zpasthapana.repo.EmployeeComputerExamDetailsRepo;
import com.zpasthapana.repo.EmployeeDesiganationRepo;
import com.zpasthapana.repo.EmployeeDisabilityRepo;
import com.zpasthapana.repo.EmployeeEducationRepo;
import com.zpasthapana.repo.EmployeeFlagRepo;
import com.zpasthapana.repo.EmployeeJoinDetailsRepo;
import com.zpasthapana.repo.EmployeeLanguageExamRepo;
import com.zpasthapana.repo.EmployeeNomineeDetailsRepo;
import com.zpasthapana.repo.EmployeeRepo;
import com.zpasthapana.repo.EmployeeTypingDetailsRepo;
import com.zpasthapana.repo.EmployeeWorklocationRepo;
import com.zpasthapana.repo.ExtraOrdinaryLeavesRepo;
import com.zpasthapana.repo.KalbadhaPromotionRepo;
import com.zpasthapana.repo.NewPromotionRepo;
import com.zpasthapana.repo.NewTrainingRepo;
import com.zpasthapana.repo.NewTransferRepo;
import com.zpasthapana.repo.PrizePridesRepo;
import com.zpasthapana.repo.PurchasePermissionRepo;
import com.zpasthapana.repo.RejectedPromotionRepo;
import com.zpasthapana.repo.RetiermentRepo;
import com.zpasthapana.repo.ServiceSegmentRepo;
import com.zpasthapana.repo.StayitvaPramanpatraRepo;
import com.zpasthapana.repo.SuspentionRepo;
import com.zpasthapana.repo.UnathorizedAbsencePeriodRepo;
import com.zpasthapana.service.EmployeeService;
import com.zpasthapana.util.ZPUtility;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;

	@Autowired
	EmployeeCastDetailsRepo employeeCastDetailsRepo;

	@Autowired
	EmployeeDesiganationRepo employeeDesiganationRepo;

	@Autowired
	EmployeeDisabilityRepo employeeDisabilityRepo;

	@Autowired
	EmployeeEducationRepo employeeEducationRepo;

	@Autowired
	EmployeeFlagRepo employeeFlagRepo;

	@Autowired
	EmployeeJoinDetailsRepo employeeJoinDetailsRepo;

	@Autowired
	EmployeeTypingDetailsRepo employeeTypingDetailsRepo;

	@Autowired
	EmployeeComputerExamDetailsRepo employeeComputerExamDetailsRepo;

	@Autowired
	EmployeeWorklocationRepo employeeWorklocationRepo;

	@Autowired
	ConcessionDetailsRepo concessionDetailsRepo;

	@Autowired
	EmployeeLanguageExamRepo employeeLanguageExamRepo;

	@Autowired
	EmployeeNomineeDetailsRepo employeeNomineeDetailsRepo;

	@Autowired
	ApprenticeNoticeRepo apprenticeNoticeRepo;

	@Autowired
	StayitvaPramanpatraRepo stayitvaPramanpatraRepo;

	@Autowired
	KalbadhaPromotionRepo kalbadhaPromotionRepo;

	@Autowired
	NewPromotionRepo newPromotionRepo;

	@Autowired
	CrimeRepo crimeRepo;

	@Autowired
	AccountInquiryRepo accountInquiryRepo;

	@Autowired
	ExtraOrdinaryLeavesRepo extraOrdinaryLeavesRepo;

	@Autowired
	AdditionalServiceRepo additionalServiceRepo;

	@Autowired
	NewTrainingRepo newTrainingRepo;

	@Autowired
	PrizePridesRepo prizePridesRepo;

	@Autowired
	AssetLiabilityRepo assetLiabilityRepo;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	NewTransferRepo newTransferRepo;

	@Autowired
	RejectedPromotionRepo rejectedPromotionRepo;

	@Autowired
	DeputationRepo deputationRepo;

	@Autowired
	PurchasePermissionRepo purchasePermissionRepo;

	@Autowired
	ConfidentialRepo confidentialRepo;

	@Autowired
	AccidentalInsuranceRepo accidentalInsuranceRepo;

	@Autowired
	ServiceSegmentRepo serviceSegmentRepo;

	@Autowired
	CourtCaseRepo courtCaseRepo;

	@Autowired
	UnathorizedAbsencePeriodRepo unathorizedAbsencePeriodRepo;

	@Autowired
	SuspentionRepo suspentionRepo;

	@Autowired
	RetiermentRepo retiermentRepo;

	@Override
	public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
		try {
			log.info("Insert employee");

			EmployeeResponse response = EmployeeResponse.builder().build();

			Employee employee = modelMapper.map(employeeRequest, Employee.class);
			employee.setIsActive(true);
			employee = employeeRepo.save(employee);
			employeeRequest.setEmployeeId(employee.getEmployeeId());
			ZPUtility.uploadFiles(employeeRequest, null, employeeRequest.getEmployeeId());

			response = modelMapper.map(employee, EmployeeResponse.class);

			EmployeeCastDetails employeeCastDetails = modelMapper.map(employeeRequest, EmployeeCastDetails.class);

			List<Field> fields = List.of(employeeRequest.getClass().getDeclaredFields()).stream()
					.filter(f -> f.getType() == MultipartFile.class).collect(Collectors.toList());

			ZPUtility.updateFileNames(employeeRequest, employeeCastDetails, fields);

			employeeCastDetails = employeeCastDetailsRepo.save(employeeCastDetails);
			response = modelMapper.map(employeeCastDetails, EmployeeResponse.class);

			employee.setEmployeeCastDetailsId(employeeCastDetails.getEmployeeCastDetailsId());

			EmployeeDesiganation employeeDesiganation = modelMapper.map(employeeRequest, EmployeeDesiganation.class);
			employeeDesiganation.setEmployeeDesiganationId(employeeRequest.getDesignationId());
			ZPUtility.updateFileNames(employeeRequest, employeeDesiganation, fields);
			employeeDesiganation = employeeDesiganationRepo.save(employeeDesiganation);
			response = modelMapper.map(employeeDesiganation, EmployeeResponse.class);

			employee.setEmployeeDesiganationDetailsId(employeeDesiganation.getEmployeeDesiganationDetailsId());

			EmployeeDisability employeeDisability = modelMapper.map(employeeRequest, EmployeeDisability.class);
			ZPUtility.updateFileNames(employeeRequest, employeeDisability, fields);
			employeeDisability = employeeDisabilityRepo.save(employeeDisability);
			response = modelMapper.map(employeeDisability, EmployeeResponse.class);

			List<EmployeeEducation> educationList = new ArrayList<>();
			for (EmployeeEducationDTO detail : employeeRequest.getEducationDetails()) {
				EmployeeEducation employeeEducation = modelMapper.map(detail, EmployeeEducation.class);
				employeeEducation.setEmployeeId(employeeRequest.getEmployeeId());
				ZPUtility.updateFileNames(employeeRequest, employeeEducation, fields);
				educationList.add(employeeEducation);
			}
			educationList = employeeEducationRepo.saveAll(educationList);

			EmployeeFlag employeeFlag = modelMapper.map(employeeRequest, EmployeeFlag.class);
			employeeFlag = employeeFlagRepo.save(employeeFlag);
			response = modelMapper.map(employeeFlag, EmployeeResponse.class);

			EmployeeJoinDetails employeeJoinDetails = modelMapper.map(employeeRequest, EmployeeJoinDetails.class);
			ZPUtility.updateFileNames(employeeRequest, employeeJoinDetails, fields);
			employeeJoinDetails = employeeJoinDetailsRepo.save(employeeJoinDetails);
			response = modelMapper.map(employeeJoinDetails, EmployeeResponse.class);

			EmployeeTypingDetails employeeTypingDetails = modelMapper.map(employeeRequest, EmployeeTypingDetails.class);
			ZPUtility.updateFileNames(employeeRequest, employeeTypingDetails, fields);
			employeeTypingDetails = employeeTypingDetailsRepo.save(employeeTypingDetails);
			response = modelMapper.map(employeeTypingDetails, EmployeeResponse.class);

			EmployeeComputerExamDetails employeeComputerExamDetails = modelMapper.map(employeeRequest,
					EmployeeComputerExamDetails.class);
			ZPUtility.updateFileNames(employeeRequest, employeeComputerExamDetails, fields);
			employeeComputerExamDetails = employeeComputerExamDetailsRepo.save(employeeComputerExamDetails);
			response = modelMapper.map(employeeComputerExamDetails, EmployeeResponse.class);

			EmployeeWorklocation employeeWorklocation = modelMapper.map(employeeRequest, EmployeeWorklocation.class);
			employeeWorklocation = employeeWorklocationRepo.save(employeeWorklocation);
			response = modelMapper.map(employeeWorklocation, EmployeeResponse.class);

			employee.setEmployeeWorklocationId(employeeWorklocation.getEmployeeWorklocationId());

			ConcessionDetails concessionDetails = modelMapper.map(employeeRequest, ConcessionDetails.class);
			ZPUtility.updateFileNames(employeeRequest, concessionDetails, fields);
			concessionDetails = concessionDetailsRepo.save(concessionDetails);
			response = modelMapper.map(concessionDetails, EmployeeResponse.class);

			EmployeeNomineeDetails employeeNomineeDetails = modelMapper.map(employeeRequest,
					EmployeeNomineeDetails.class);
			ZPUtility.updateFileNames(employeeRequest, employeeNomineeDetails, fields);
			employeeNomineeDetails = employeeNomineeDetailsRepo.save(employeeNomineeDetails);
			response = modelMapper.map(employeeNomineeDetails, EmployeeResponse.class);

			EmployeeLanguageExam employeeLanguageExam = modelMapper.map(employeeRequest, EmployeeLanguageExam.class);
			ZPUtility.updateFileNames(employeeRequest, employeeLanguageExam, fields);
			employeeLanguageExam = employeeLanguageExamRepo.save(employeeLanguageExam);
			response = modelMapper.map(concessionDetails, EmployeeResponse.class);
			employee = employeeRepo.save(employee);
			response = modelMapper.map(employee, EmployeeResponse.class);

			return response;
		} catch (Exception e) {
			log.error("Exception: ", e);
			throw e;
		}
	}

	@Override
	public EmployeeResponse updateEmployee(Long employeeId, EmployeeRequest employeeRequest) {
		log.info("Insert employee");

		EmployeeResponse response = EmployeeResponse.builder().build();

		Optional<Employee> employeeEntity = employeeRepo.findById(employeeId);

		if (employeeEntity.isEmpty()) {
			throw new EntityNotFoundException("Employee not found");
		}

		Employee employee = modelMapper.map(employeeRequest, Employee.class);
		employee.setEmployeeId(employeeId);
		employee = employeeRepo.save(employee);

		employeeRequest.setEmployeeId(employeeId);
		response = modelMapper.map(employee, EmployeeResponse.class);

		EmployeeCastDetails employeeCastDetails = modelMapper.map(employeeRequest, EmployeeCastDetails.class);
		employeeCastDetails = employeeCastDetailsRepo.save(employeeCastDetails);
		response = modelMapper.map(employeeCastDetails, EmployeeResponse.class);

		EmployeeDesiganation employeeDesiganation = modelMapper.map(employeeRequest, EmployeeDesiganation.class);
		employeeDesiganation = employeeDesiganationRepo.save(employeeDesiganation);
		response = modelMapper.map(employeeDesiganation, EmployeeResponse.class);

		EmployeeDisability employeeDisability = modelMapper.map(employeeRequest, EmployeeDisability.class);
		employeeDisability = employeeDisabilityRepo.save(employeeDisability);
		response = modelMapper.map(employeeDisability, EmployeeResponse.class);

		EmployeeEducation employeeEducation = modelMapper.map(employeeRequest, EmployeeEducation.class);
		employeeEducation = employeeEducationRepo.save(employeeEducation);
		response = modelMapper.map(employeeEducation, EmployeeResponse.class);

		EmployeeFlag employeeFlag = modelMapper.map(employeeRequest, EmployeeFlag.class);
		employeeFlag = employeeFlagRepo.save(employeeFlag);
		response = modelMapper.map(employeeFlag, EmployeeResponse.class);

		EmployeeJoinDetails employeeJoinDetails = modelMapper.map(employeeRequest, EmployeeJoinDetails.class);
		employeeJoinDetails = employeeJoinDetailsRepo.save(employeeJoinDetails);
		response = modelMapper.map(employeeJoinDetails, EmployeeResponse.class);

		EmployeeTypingDetails employeeTypingDetails = modelMapper.map(employeeRequest, EmployeeTypingDetails.class);
		employeeTypingDetails = employeeTypingDetailsRepo.save(employeeTypingDetails);
		response = modelMapper.map(employeeTypingDetails, EmployeeResponse.class);

		EmployeeWorklocation employeeWorklocation = modelMapper.map(employeeRequest, EmployeeWorklocation.class);
		employeeWorklocation = employeeWorklocationRepo.save(employeeWorklocation);
		response = modelMapper.map(employeeWorklocation, EmployeeResponse.class);

		return response;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepo.findAll();
	}

	@Override
	public ResponsePageDto<Employee> getAllAssetLiability(UIPageRequest pageRequest, Pageable paging) {
		return ZPUtility.getPage(paging, employeeRepo.findAllByPermission(pageRequest.getDevisionId(),
				pageRequest.getZpId(), pageRequest.getDepartmentId(), pageRequest.getTalukaId(), paging));
	}

	@Override
	public Optional<Employee> getEmployeeById(Long employeeId) {
		return employeeRepo.findById(employeeId);
	}

	@Override
	public ResponsePageDto<Employee> getAllRetieredEmployees(UIPageRequest pageRequest, Pageable paging) {
		return ZPUtility.getPage(paging, employeeRepo.findAllRetieredEmployee(pageRequest.getDevisionId(),
				pageRequest.getZpId(), pageRequest.getDepartmentId(), pageRequest.getTalukaId(), new Date(), paging));
	}

	@Override
	public ResponsePageDto<Employee> getAllWorkingEmployees(UIPageRequest pageRequest, Pageable paging) {
		return ZPUtility.getPage(paging, employeeRepo.findAllWorkingEmployee(pageRequest.getDevisionId(),
				pageRequest.getZpId(), pageRequest.getDepartmentId(), pageRequest.getTalukaId(), new Date(), paging));
	}

	@Override
	public void deactivateEmployee(Long employeeId) {
		Employee employee = employeeRepo.findById(employeeId).orElseThrow();
		employee.setIsActive(Boolean.FALSE);
		employeeRepo.save(employee);
	}

	@Override
	public EmployeeResponse getEmployeeProfile(Long employeeId) {
		log.info("Fetching employee profile for employeeId: {}", employeeId);

		Optional<Employee> employeeEntity = employeeRepo.findById(employeeId);
		if (employeeEntity.isEmpty()) {
			throw new EntityNotFoundException("Employee not found");
		}
		Employee employee = employeeEntity.get();

		EmployeeResponse response = modelMapper.map(employee, EmployeeResponse.class);

		Optional<EmployeeCastDetails> employeeCastDetails = employeeCastDetailsRepo
				.findById(employee.getEmployeeCastDetailsId());
		employeeCastDetails.ifPresent(castDetails -> modelMapper.map(castDetails, response));

		Optional<EmployeeDesiganation> employeeDesiganation = employeeDesiganationRepo
				.findById(employee.getEmployeeDesiganationDetailsId());
		employeeDesiganation.ifPresent(designation -> modelMapper.map(designation, response));

		Optional<EmployeeNomineeDetails> employeeNomineeDetails = Optional
				.ofNullable(employeeNomineeDetailsRepo.findByEmployeeId(employeeId));
		employeeNomineeDetails.ifPresent(nomineeDetails -> modelMapper.map(nomineeDetails, response));

		employeeNomineeDetails.ifPresent(response::setEmployeeNomineeDetails);
		Optional<EmployeeDisability> employeeDisability = Optional
				.ofNullable(employeeDisabilityRepo.findByEmployeeId(employeeId));
		employeeDisability.ifPresent(disability -> modelMapper.map(disability, response));

		Optional<List<EmployeeEducation>> employeeEducationList = Optional
				.ofNullable(employeeEducationRepo.findByEmployeeId(employeeId));
		if (employeeEducationList.isPresent() && !employeeEducationList.get().isEmpty()) {

			List<EmployeeEducationDTO> educationDetails = employeeEducationList.get().stream()
					.map(education -> modelMapper.map(education, EmployeeEducationDTO.class))
					.collect(Collectors.toList());

			response.setEducationDetails(educationDetails);
		} else {
			response.setEducationDetails(List.of());
		}

		Optional<EmployeeFlag> employeeFlag = Optional.ofNullable(employeeFlagRepo.findByEmployeeId(employeeId));
		employeeFlag.ifPresent(flag -> modelMapper.map(flag, response));

		Optional<EmployeeJoinDetails> employeeJoinDetails = Optional
				.ofNullable(employeeJoinDetailsRepo.findByEmployeeId(employeeId));
		employeeJoinDetails.ifPresent(joinDetails -> modelMapper.map(joinDetails, response));

		Optional<EmployeeTypingDetails> employeeTypingDetails = Optional
				.ofNullable(employeeTypingDetailsRepo.findByEmployeeId(employeeId));
		employeeTypingDetails.ifPresent(typingDetails -> modelMapper.map(typingDetails, response));

		Optional<List<EmployeeWorklocation>> employeeWorklocation = Optional
				.ofNullable(employeeWorklocationRepo.findByEmployeeId(employeeId));
		if (employeeWorklocation.isPresent() && !employeeWorklocation.get().isEmpty()) {
			employeeWorklocation.ifPresent(worklocation -> modelMapper.map(worklocation, response));
		}
		Optional<Optional<ConcessionDetails>> concessionDetails = Optional
				.ofNullable(concessionDetailsRepo.findById(employeeId));
		concessionDetails.ifPresent(employeeConcessionDetails -> modelMapper.map(employeeConcessionDetails, response));

		Optional<List<ApprenticeNotice>> apprenticeNoticeDetails = Optional
				.ofNullable(apprenticeNoticeRepo.findAllByEmployeeId(employeeId));
		if (apprenticeNoticeDetails.isPresent() && !apprenticeNoticeDetails.get().isEmpty()) {
			List<ApprenticeNotice> stayitvaPramanpatraDetail = apprenticeNoticeDetails.get().stream()
					.map(pramanpatra -> modelMapper.map(pramanpatra, ApprenticeNotice.class))
					.collect(Collectors.toList());
			response.setApprenticeNoticeDetails(stayitvaPramanpatraDetail);
		}

		Optional<List<StayitvaPramanpatra>> stayitvaPramanpatraDetails = Optional
				.ofNullable(stayitvaPramanpatraRepo.findAllByEmployeeId(employeeId));
		if (stayitvaPramanpatraDetails.isPresent() && !stayitvaPramanpatraDetails.get().isEmpty()) {
			List<StayitvaPramanpatra> stayitvaPramanpatraDetail = stayitvaPramanpatraDetails.get().stream()
					.map(pramanpatra -> modelMapper.map(pramanpatra, StayitvaPramanpatra.class))
					.collect(Collectors.toList());
			response.setSthaetvPramanpatraDetails(stayitvaPramanpatraDetail);
		}

		Optional<KalbadhaPromotion> kalbadhPromotion = Optional
				.ofNullable(kalbadhaPromotionRepo.findByEmployeeId(employeeId));
		kalbadhPromotion.ifPresent(kalbadhPromotionDetails -> modelMapper.map(kalbadhPromotionDetails, response));

		Optional<List<NewPromotion>> newPromotionDetails = Optional
				.ofNullable(newPromotionRepo.findByEmployeeId(employeeId));
		newPromotionDetails.ifPresent(newPromotion -> modelMapper.map(newPromotion, response));

		Optional<RejectedPromotion> rejectedPromotionDetails = Optional
				.ofNullable(rejectedPromotionRepo.findByEmployeeId(employeeId));
		if (rejectedPromotionDetails.isPresent()) {
			response.setRejectedPromotionDetails(rejectedPromotionDetails.get());
		}

		Optional<List<NewTransfer>> newTransfterDetails = Optional
				.ofNullable(newTransferRepo.findByEmployeeId(employeeId));
		if (newTransfterDetails.isPresent() && !newTransfterDetails.get().isEmpty()) {
			List<NewTransfer> transferDetails = (List<NewTransfer>) newTransfterDetails.get().stream()
					.map(transfer -> modelMapper.map(transfer, NewTransfer.class)).collect(Collectors.toList());
			response.setTransferDetails(transferDetails);
		}

		Optional<List<Deputation>> deputationDetails = Optional
				.ofNullable(deputationRepo.findAllByEmployeeId(employeeId));
		if (deputationDetails.isPresent() && !deputationDetails.get().isEmpty()) {
			List<Deputation> deputations = deputationDetails.get();
			Deputation latestDeputation = deputations.get(0);
			response.setDeputationDetails(latestDeputation);
		}

		Optional<List<Crime>> crimeDetails = Optional.ofNullable(crimeRepo.findAllByEmployeeId(employeeId));
		if (crimeDetails.isPresent() && !crimeDetails.get().isEmpty()) {
			List<Crime> crimeList = (List<Crime>) crimeDetails.get().stream()
					.map(crime -> modelMapper.map(crime, Crime.class)).collect(Collectors.toList());
			response.setCrimeDetails(crimeList);
		}

		Optional<List<AccountInquiry>> accountInquiries = Optional
				.ofNullable(accountInquiryRepo.findAllByEmployeeId(employeeId));
		if (accountInquiries.isPresent() && !accountInquiries.get().isEmpty()) {
			List<AccountInquiry> accountInquaryList = (List<AccountInquiry>) accountInquiries.get().stream()
					.map(inqury -> modelMapper.map(inqury, AccountInquiry.class)).collect(Collectors.toList());
			response.setAccountInquaryDetails(accountInquaryList);
		}

		Optional<List<ExtraOrdinaryLeaves>> extraOrdinaryLeaves = Optional
				.ofNullable(extraOrdinaryLeavesRepo.findAllByEmployeeId(employeeId));
		if (extraOrdinaryLeaves.isPresent() && !extraOrdinaryLeaves.isEmpty()) {
			List<ExtraOrdinaryLeaves> extraOrdinaryLeaveList = (List<ExtraOrdinaryLeaves>) extraOrdinaryLeaves.get()
					.stream().map(leave -> modelMapper.map(leave, ExtraOrdinaryLeaves.class))
					.collect(Collectors.toList());
			response.setExtraOrdinaryLeaveDetails(extraOrdinaryLeaveList);
		}

		Optional<AdditionalService> additionalService = Optional
				.ofNullable(additionalServiceRepo.findByEmployeeId(employeeId));
		if (additionalService.isPresent()) {
			response.setAdditionalServiceDetails(additionalService.get());
		}

		Optional<List<NewTraining>> newTrainingDetails = Optional
				.ofNullable(newTrainingRepo.findAllByEmployeeId(employeeId));
		if (newTrainingDetails.isPresent() && !newTrainingDetails.get().isEmpty()) {
			List<NewTraining> newTrainingDetailsList = (List<NewTraining>) newTrainingDetails.get().stream()
					.map(price -> modelMapper.map(price, NewTraining.class)).collect(Collectors.toList());
			response.setTrainingDetails(newTrainingDetailsList);
		}

		Optional<List<PrizePrides>> prizePridesDetails = Optional
				.ofNullable(prizePridesRepo.findAllByEmployeeId(employeeId));
		if (prizePridesDetails.isPresent() && !prizePridesDetails.get().isEmpty()) {
			List<PrizePrides> prizePridesDetailsList = (List<PrizePrides>) prizePridesDetails.get().stream()
					.map(price -> modelMapper.map(price, PrizePrides.class)).collect(Collectors.toList());
			response.setPrizePrideDetails(prizePridesDetailsList);
		}

		Optional<List<PurchasePermission>> purchasePermissionDetails = Optional
				.ofNullable(purchasePermissionRepo.findAllByEmployeeId(employeeId));
		if (purchasePermissionDetails.isPresent() && !purchasePermissionDetails.get().isEmpty()) {
			List<PurchasePermission> prizePridesDetailsList = (List<PurchasePermission>) purchasePermissionDetails.get()
					.stream().map(permission -> modelMapper.map(permission, PurchasePermission.class))
					.collect(Collectors.toList());
			response.setPurchasePermissionDetails(prizePridesDetailsList);
		}

		Optional<List<AssetLiability>> assetLiabilityDetails = Optional
				.ofNullable(assetLiabilityRepo.findAllByEmployeeId(employeeId));
		if (assetLiabilityDetails.isPresent() && !assetLiabilityDetails.get().isEmpty()) {
			List<AssetLiability> prizePridesDetailsList = (List<AssetLiability>) assetLiabilityDetails.get().stream()
					.map(liability -> modelMapper.map(liability, AssetLiability.class)).collect(Collectors.toList());
			response.setAssetLiabilityDetails(prizePridesDetailsList);
		}

		Optional<List<Confidential>> confidentialDetails = Optional
				.ofNullable(confidentialRepo.findAllByEmployeeId(employeeId));
		if (confidentialDetails.isPresent() && !confidentialDetails.isEmpty()) {
			List<Confidential> confidentialDetailsList = (List<Confidential>) confidentialDetails.get().stream()
					.map(details -> modelMapper.map(details, Confidential.class)).collect(Collectors.toList());
			response.setConfidentialDetails(confidentialDetailsList);
		}

		Optional<List<AccidentalInsurance>> accidentalInsuranceDetails = Optional
				.ofNullable(accidentalInsuranceRepo.findAllByEmployeeId(employeeId));
		if (accidentalInsuranceDetails.isPresent() && !accidentalInsuranceDetails.isEmpty()) {
			List<AccidentalInsurance> accidentalInsuranceList = (List<AccidentalInsurance>) accidentalInsuranceDetails
					.get().stream()
					.map(accidentalInsurance -> modelMapper.map(accidentalInsurance, AccidentalInsurance.class))
					.collect(Collectors.toList());
			response.setAccidentalInsuranceDetails(accidentalInsuranceList);
		}

		Optional<ServiceSegment> serviceSegmentDetails = Optional
				.ofNullable(serviceSegmentRepo.findByEmployeeId(employeeId));
		if (serviceSegmentDetails.isPresent()) {
			response.setServiceSegmentDetails(serviceSegmentDetails.get());
		}

		Optional<List<CourtCase>> courtCaseDetails = Optional.ofNullable(courtCaseRepo.findAllByEmployeeId(employeeId));
		if (courtCaseDetails.isPresent() && !courtCaseDetails.get().isEmpty()) {
			List<CourtCase> courtCaseDetailsList = (List<CourtCase>) courtCaseDetails.get().stream()
					.map(details -> modelMapper.map(details, CourtCase.class)).collect(Collectors.toList());
			response.setCourtCaseDetails(courtCaseDetailsList);
		}

		Optional<List<UnathorizedAbsencePeriod>> unathorizedAbsencePeriodDetails = Optional
				.ofNullable(unathorizedAbsencePeriodRepo.findAllByEmployeeId(employeeId));
		if (unathorizedAbsencePeriodDetails.isPresent() && !unathorizedAbsencePeriodDetails.isEmpty()) {
			List<UnathorizedAbsencePeriod> unathorizedAbsencePeriodList = (List<UnathorizedAbsencePeriod>) unathorizedAbsencePeriodDetails
					.get().stream().map(details -> modelMapper.map(details, UnathorizedAbsencePeriod.class))
					.collect(Collectors.toList());
			response.setUnathorizedAbsencePeriodDetails(unathorizedAbsencePeriodList);
		}

		Optional<List<Suspention>> suspentionDetails = Optional
				.ofNullable(suspentionRepo.findAllByEmployeeId(employeeId));
		if (suspentionDetails.isPresent() && !suspentionDetails.isEmpty()) {
			List<Suspention> suspentionDetailsList = (List<Suspention>) suspentionDetails.get().stream()
					.map(details -> modelMapper.map(details, Suspention.class)).collect(Collectors.toList());
			response.setSuspentionDetails(suspentionDetailsList);
		}

		Optional<List<Retierment>> retiermentDetails = Optional
				.ofNullable(retiermentRepo.findAllByEmployeeId(employeeId));
		if (retiermentDetails.isPresent() && !retiermentDetails.get().isEmpty()) {
			List<Retierment> retierment = retiermentDetails.get();
			Retierment retiermentDetail = retierment.get(0);
			response.setRetiermentDetails(retiermentDetail);
		}

		return response;
	}

}
