package com.zpasthapana.controller;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zpasthapana.util.ZPUtility;

@RestController
@RequestMapping("resource")
public class ResourceController {

	@GetMapping("/{destination}/{fileName}")
	public ResponseEntity<Resource> serveFile(@PathVariable Long destination, @PathVariable String fileName) {
		return ZPUtility.getFile(destination, fileName);
	}

}
