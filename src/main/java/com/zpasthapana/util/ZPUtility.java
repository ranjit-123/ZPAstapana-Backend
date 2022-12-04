package com.zpasthapana.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.multipart.MultipartFile;

import com.zpasthapana.entity.BaseEntity;
import com.zpasthapana.pojo.BaseRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ZPUtility {
	
//	private static String homeDirectory = "D:\\files\\";
	
	private static String homeDirectory = "/home/";
	
	public static void uploadFile(MultipartFile file, Long destination) {
		try {
			String directory = homeDirectory + destination + "/";
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
	  
}
