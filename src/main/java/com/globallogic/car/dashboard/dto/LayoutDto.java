package com.globallogic.car.dashboard.dto;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class LayoutDto {

	private Long layoutId;
	private String layoutName;
	private Long carId;
	
	@JsonIgnore
	private byte[] templatePreview;
	@JsonIgnore
	private String templateName;
	
	public void readFile(final MultipartFile file) throws IOException {
		if (file != null) {
			this.templatePreview = file.getBytes();
			this.templateName = file.getOriginalFilename();
		}
	}
}
