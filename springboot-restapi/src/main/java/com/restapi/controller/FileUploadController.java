package com.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restapi.helper.FileUploadHelper;

@RestController
public class FileUploadController {

	@Autowired
	private FileUploadHelper fileUploadHelper;
	
	@PostMapping("/upload-file")
	public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file){
		
		if(file.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please upload a file.");
		if(!file.getContentType().equals("image/jpeg"))
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only image/JPEG files are allowed.");
		
		boolean uploaded = fileUploadHelper.uploadFile(file);
		
		if(uploaded)
			return ResponseEntity.ok().body("File has been uploaded successfully. View at: "+ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!");
	}
}
