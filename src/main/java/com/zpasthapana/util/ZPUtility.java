package com.zpasthapana.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.multipart.MultipartFile;

import com.zpasthapana.entity.BaseEntity;
import com.zpasthapana.entity.Employee;
import com.zpasthapana.entity.EmployeeCastDetails;
import com.zpasthapana.entity.EmployeeWorklocation;
import com.zpasthapana.pojo.BaseRequest;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.SortField;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ZPUtility {
	
//	private static String homeDirectory = "D:\\files\\";
	
	private static String homeDirectory = "/home/";
	
	public static void uploadFile(MultipartFile file, Long destination) {
		try {
			String directory = homeDirectory + destination + File.pathSeparator;
			String fileName = file.getOriginalFilename();
			Files.createDirectories(Paths.get(directory));
			Path path = Paths.get(directory + fileName);
			Files.write(path, file.getBytes());
		} catch (IOException e) {
			log.error("Error ", e);
		}
	}
	
	public static void uploadFiles(BaseRequest request, BaseEntity entity, Long employeeId) {
		List<Field> fields = List.of(request.getClass().getDeclaredFields()).stream()
				.filter(f -> f.getType() == MultipartFile.class).collect(Collectors.toList());
		fields.forEach(field -> {
			field.setAccessible(true);
			Object fileData = ReflectionUtils.getField(field, request);
			if (ObjectUtils.isNotEmpty(fileData)) {
				MultipartFile file = (MultipartFile) fileData;
				uploadFile(file, employeeId);
				if(ObjectUtils.isNotEmpty(entity)) {
					Field setField = ReflectionUtils.findField(entity.getClass(), field.getName());
					setField.setAccessible(true);
					ReflectionUtils.setField(setField, entity, file.getOriginalFilename());
				}
			}
		});
	}

	public static void updateFileNames(BaseRequest request, BaseEntity entity, List<Field> fields) {
		fields.forEach(field -> {
			field.setAccessible(true);
			Field setField = ReflectionUtils.findField(entity.getClass(), field.getName());
			if (ObjectUtils.isNotEmpty(setField)) {
				Object fileData = ReflectionUtils.getField(field, request);
				if (ObjectUtils.isNotEmpty(fileData)) {
					MultipartFile file = (MultipartFile) fileData;
					if (ObjectUtils.isNotEmpty(setField)) {
						setField.setAccessible(true);
						ReflectionUtils.setField(setField, entity, file.getOriginalFilename());
					}
				}
			}
		});
	}
	 
	public static Sort getSort(List<SortField> sortFields) {
		if(ObjectUtils.isNotEmpty(sortFields)) {
			List<Order> orders = new ArrayList<Order>();
			sortFields.forEach(sortField->{
				Order StartTimeOrder = new Order(Sort.Direction.fromString(sortField.getOrder()), sortField.getFieldName());
		        orders.add(StartTimeOrder);
			});
			return Sort.by(orders);
		} else {
			return Sort.unsorted();
		}
	}
	
	public static <T> ResponsePageDto<T> getPage(Pageable paging, Page<T> page) {
		ResponsePageDto<T> pageData = new ResponsePageDto<T>(page.getContent(), 0,
				page.getTotalElements(), page.getTotalElements());
		
		pageData.getData().forEach(e->{
			try {
				try {
					Field field = ReflectionUtils.findField(e.getClass(), "employee");
					if (ObjectUtils.isNotEmpty(field)) {
						field.setAccessible(true);
						Employee em = (Employee) ReflectionUtils.getField(field, e);
						if (ObjectUtils.isNotEmpty(em)) {
							setField(e, em, "employeeFullName");
						}
						
						EmployeeWorklocation employeeWork = em.getEmployeeWorkLocation();
						if (ObjectUtils.isNotEmpty(employeeWork)) {
							setWorkField(e, employeeWork);
						}
						
						EmployeeCastDetails ecastDetails = em.getEmployeeCastDetails();
						if (ObjectUtils.isNotEmpty(ecastDetails)) {
							setCastField(e, ecastDetails);
						}
						
					}
				} catch (Exception ex) {
					log.error("Error", ex);
				}
			} catch (Exception ex) {
				log.error("Error", ex);
			}
		});
		
		return pageData;
	}

	private static <T> void setCastField(T e, EmployeeCastDetails ecastDetails) {
		Field fieldSet = ReflectionUtils.findField(e.getClass(), "castCategoryName");
		if(ObjectUtils.isNotEmpty(fieldSet)) {
			fieldSet.setAccessible(true);
			ReflectionUtils.setField(fieldSet, e, MasterDataUtil.getKeyDate("castecategory_", ecastDetails.getCastecategory()));
		}
	}

	private static <T> void setField(T e, Employee em, String fieldName) {
		Field fieldSet = ReflectionUtils.findField(e.getClass(), fieldName);
		if(ObjectUtils.isNotEmpty(fieldSet)) {
			fieldSet.setAccessible(true);
			if(StringUtils.equalsIgnoreCase(fieldName, fieldName)) {
				ReflectionUtils.setField(fieldSet, e, em.getFirstName() + " " + em.getMiddleName() + " " + em.getLastName());
			}
		}
	}
	
	private static <T> void setWorkField(T e, EmployeeWorklocation em) {
		Field fieldSet = ReflectionUtils.findField(e.getClass(), "talukaName");
		if(ObjectUtils.isNotEmpty(fieldSet)) {
			fieldSet.setAccessible(true);
			ReflectionUtils.setField(fieldSet, e, MasterDataUtil.getKeyDate("taluka_", em.getTaluka()));
		}
		fieldSet = ReflectionUtils.findField(e.getClass(), "subDivisionName");
		if(ObjectUtils.isNotEmpty(fieldSet)) {
			fieldSet.setAccessible(true);
			ReflectionUtils.setField(fieldSet, e, MasterDataUtil.getKeyDate("subdivision_", em.getSubDivision()));
		}
		fieldSet = ReflectionUtils.findField(e.getClass(), "designationName");
		if(ObjectUtils.isNotEmpty(fieldSet)) {
			fieldSet.setAccessible(true);
			ReflectionUtils.setField(fieldSet, e, MasterDataUtil.getKeyDate("designation_", em.getDesignationId()));
		}
		fieldSet = ReflectionUtils.findField(e.getClass(), "subDepartmentName");
		if(ObjectUtils.isNotEmpty(fieldSet)) {
			fieldSet.setAccessible(true);
			ReflectionUtils.setField(fieldSet, e, MasterDataUtil.getKeyDate("subdepartment_", em.getSubDepartment()));
		}
	}
}
