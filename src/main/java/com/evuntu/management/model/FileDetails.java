package com.evuntu.management.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "FILE_DETAILS")
public class FileDetails implements Serializable{

	private static final long serialVersionUID = 98756779L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FILE_ID", unique = true, nullable = false)
	private Long fileId;
	
	@Column(name = "FILE_NAME", nullable = false)
	private String fileName;
	
	@Column(name = "FILE_PATH", nullable = false)
	private String filePath;
	
	@Column(name = "FILE_TYPE", nullable = false)
	private String fileType;
	
	@Column(name = "FILE_DESC")
	private String fileDesc;
	
	@Column(name = "TIMESTAMP")
	private Timestamp fileUploadedTime;
	
	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "FILE_SIZE", nullable = true)
	private Long fileSize;
	
	@Column(name = "STATUS", nullable = false)
	private char status;
	
	//bi-directional many-to-one association to EventService
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="EVENT_SERVICES_ID", nullable = false)
	private EventServices eventServices;

	/**
	 * @return the fileId
	 */
	public Long getFileId() {
	    return fileId;
	}
	
	/**
	 * @param fileId the fileId to set
	 */
	public void setFileId(Long fileId) {
	    this.fileId = fileId;
	}
	
	public String getFileName() {
	    return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
	    this.fileName = fileName;
	}
	/**
	 * @return the filePath
	 */
	public String getFilePath() {
	    return filePath;
	}
	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
	    this.filePath = filePath;
	}
	/**
	 * @return the fileType
	 */
	public String getFileType() {
	    return fileType;
	}
	/**
	 * @param fileType the fileType to set
	 */
	public void setFileType(String fileType) {
	    this.fileType = fileType;
	}
	/**
	 * @return the fileDesc
	 */
	public String getFileDesc() {
	    return fileDesc;
	}
	/**
	 * @param fileDesc the fileDesc to set
	 */
	public void setFileDesc(String fileDesc) {
	    this.fileDesc = fileDesc;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
	    return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
	    this.userId = userId;
	}
	
	/**
	 * @return the fileSize
	 */
	public Long getFileSize() {
	    return fileSize;
	}
	/**
	 * @param fileSize the fileSize to set
	 */
	public void setFileSize(Long fileSize) {
	    this.fileSize = fileSize;
	}
	
	/**
	 * @return the status
	 */
	public char getStatus() {
	    return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(char status) {
	    this.status = status;
	}
	
	public Timestamp getFileUploadedTime() {
		return fileUploadedTime;
	}
	public void setFileUploadedTime(Timestamp fileUploadedTime) {
		this.fileUploadedTime = fileUploadedTime;
	}
	
	
	
	/**
	 * @return the eventServices
	 */
	public EventServices getEventServices() {
		return eventServices;
	}

	/**
	 * @param eventServices the eventServices to set
	 */
	public void setEventServices(EventServices eventServices) {
		this.eventServices = eventServices;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventServices == null) ? 0 : eventServices.hashCode());
		result = prime * result + ((fileDesc == null) ? 0 : fileDesc.hashCode());
		result = prime * result + ((fileId == null) ? 0 : fileId.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((filePath == null) ? 0 : filePath.hashCode());
		result = prime * result + ((fileSize == null) ? 0 : fileSize.hashCode());
		result = prime * result + ((fileType == null) ? 0 : fileType.hashCode());
		result = prime * result + ((fileUploadedTime == null) ? 0 : fileUploadedTime.hashCode());
		result = prime * result + status;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof FileDetails))
			return false;
		FileDetails other = (FileDetails) obj;
		if (eventServices == null) {
			if (other.eventServices != null)
				return false;
		} else if (!eventServices.equals(other.eventServices))
			return false;
		if (fileDesc == null) {
			if (other.fileDesc != null)
				return false;
		} else if (!fileDesc.equals(other.fileDesc))
			return false;
		if (fileId == null) {
			if (other.fileId != null)
				return false;
		} else if (!fileId.equals(other.fileId))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (filePath == null) {
			if (other.filePath != null)
				return false;
		} else if (!filePath.equals(other.filePath))
			return false;
		if (fileSize == null) {
			if (other.fileSize != null)
				return false;
		} else if (!fileSize.equals(other.fileSize))
			return false;
		if (fileType == null) {
			if (other.fileType != null)
				return false;
		} else if (!fileType.equals(other.fileType))
			return false;
		if (fileUploadedTime == null) {
			if (other.fileUploadedTime != null)
				return false;
		} else if (!fileUploadedTime.equals(other.fileUploadedTime))
			return false;
		if (status != other.status)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	

}
