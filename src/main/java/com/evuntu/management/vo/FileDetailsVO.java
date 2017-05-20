package com.evuntu.management.vo;

import java.io.Serializable;
import java.sql.Timestamp;



public class FileDetailsVO implements Serializable{

	private static final long serialVersionUID = 98756779L;

	private Long fileId;
	
	private String fileName;
	
	private String filePath;
	
	private String fileType;
	
	private String fileDesc;
	
	private Timestamp fileUploadedTime;
	
	private String userId;
	
	private Long fileSize;
	
	private char status;
	
	private Long eventServicesId;	
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
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 17;
	    result = prime * result + ((fileDesc == null) ? 0 : fileDesc.hashCode());
	    result = prime * result + ((fileId == null) ? 0 : fileId.hashCode());
	    result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
	    result = prime * result + ((filePath == null) ? 0 : filePath.hashCode());
	    result = prime * result + ((fileSize == null) ? 0 : fileSize.hashCode());
	    result = prime * result + ((fileType == null) ? 0 : fileType.hashCode());
	    result = prime * result + ((fileUploadedTime == null) ? 0 : fileUploadedTime.hashCode());
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
	    if (getClass() != obj.getClass())
	        return false;
	    FileDetailsVO other = (FileDetailsVO) obj;
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
	    if (userId == null) {
	        if (other.userId != null)
	            return false;
	    } else if (!userId.equals(other.userId))
	        return false;
	    return true;
	}
	public Long getEventServicesId() {
		return eventServicesId;
	}
	public void setEventServicesId(Long eventServicesId) {
		this.eventServicesId = eventServicesId;
	}
	

}
