package com.evuntu.management.util;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import com.evuntu.management.exception.EvuntuManagementException;
import com.evuntu.management.model.FileDetails;

public class FileUploadUtil {
	
	 private static final String INTERNAL_SERVER_ERROR = "Internal server error";
	
	 private static final Logger LOGGER = Logger.getLogger(FileUploadUtil.class);

	/**
	 * @param inputFile
	 * @return
	 * @throws EvuntuManagementException 
	 * @throws IOException
	 */
	public boolean upload(MultipartFile inputFile,Long companyId) throws EvuntuManagementException  {
		LOGGER.info("FileUploadController::upload-start");
		String filePath="D:\\evuntuLog\\uploaded\\"+companyId;
		String originalFilename = inputFile.getOriginalFilename();
		createFolderIfNotExists(filePath);
		File destinationFile = new File(filePath+  File.separator + originalFilename);
		try{
			inputFile.transferTo(destinationFile);
			return true;
		}  catch (IOException e) {
			LOGGER.error(INTERNAL_SERVER_ERROR+e);
			throw new EvuntuManagementException("IO Exception occured::"+e);			
		}		
	}

	private void createFolderIfNotExists(String dirName) throws EvuntuManagementException {
    	File theDir = new File(dirName);
    	if (!theDir.exists()) {
    		LOGGER.info("Folder created: "+dirName);
    		theDir.mkdir();
    	}
    }
	
	public FileDetails prepareObjectToStore(MultipartFile file,Long eventServicesId) {
		FileDetails fileDetails = new FileDetails();
		fileDetails.setEventServicesId(eventServicesId);
		fileDetails.setFileName(file
				.getOriginalFilename());
		fileDetails.setStatus('A');
		fileDetails.setFileType(file.getContentType());
		Date currentDate = new Date();
		fileDetails.setFileUploadedTime(new Timestamp(
				currentDate.getTime()));
		fileDetails.setFileSize(file.getSize());
		return fileDetails;
	}
	
}
