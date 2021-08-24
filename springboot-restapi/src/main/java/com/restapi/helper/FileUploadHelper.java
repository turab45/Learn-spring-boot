package com.restapi.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	private static final String UPLOAD_DIR = "F:\\Tuition\\WEB\\Spring Boot Workspace\\springboot-restapi\\src\\main\\resources\\static\\images";
	
	public boolean uploadFile(MultipartFile file) {
		boolean uploaded = false;
		
		try {
			Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			uploaded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return uploaded;
		
	}
}
