package com.zpasthapana.pojo;

import org.springframework.web.multipart.MultipartFile;

public class MultiPartBodyRequest {
	
	private MultipartFile file;
	private String type;
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
