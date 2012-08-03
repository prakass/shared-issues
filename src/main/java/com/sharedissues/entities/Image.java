package com.sharedissues.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.sharedissues.all.common.Common;

@Entity
public class Image {
	@Id
	@Column(name="image_uuid")
	private String imageUuid;
	
	@Column(name="external_uuid")
	private String externalUuid;
	
	@Column(name="external_flag")
	private String externalFlag;
	
	@Column(name="file_type")
	private String fileType;
	
	@Column(name="file_name")
	private String fileName;
	
	@Column(name="file_content")
	@Lob
	private byte[] fileContent;

	public Image(){this.imageUuid=Common.getUuid();}
	
	public String getImageUuid() {
		return imageUuid;
	}

	public void setImageUuid(String imageUuid) {
		this.imageUuid = imageUuid;
	}

	public String getExternalUuid() {
		return externalUuid;
	}

	public void setExternalUuid(String externalUuid) {
		this.externalUuid = externalUuid;
	}

	public String getExternalFlag() {
		return externalFlag;
	}

	public void setExternalFlag(String externalFlag) {
		this.externalFlag = externalFlag;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFileContent() {
		return fileContent;
	}

	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}
	
	
}
