package com.evuntu.management.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.evuntu.management.exception.EvuntuManagementException;
import com.evuntu.management.vo.FileInfo;


@RestController
@RequestMapping("/evuntu")
public class FileUploadController {
 
	 private static final String INTERNAL_SERVER_ERROR = "Internal server error";
	 
	 @Autowired
	 ServletContext context;
	 
     private static final Logger LOGGER = Logger.getLogger(FileUploadController.class);
     
	 @RequestMapping(value = "/fileupload", headers=("content-type=multipart/*"), method = RequestMethod.POST)
	 public ResponseEntity<List<FileInfo>> fileupload(@RequestParam("test") MultipartFile[] inputFile) throws EvuntuManagementException{
		  LOGGER.info("FileUploadController::fileupload-start");
		 
		  List<FileInfo> fileList=new ArrayList<>();
		  HttpHeaders headers = new HttpHeaders();
		  for(int i=0;i<inputFile.length;i++){
			  
			 if (!inputFile[i].isEmpty()) {
			   try {
				    FileInfo fileInfo = new FileInfo();
				    File destinationFile = upload(inputFile[i]);	    
				    
				    fileInfo.setFileName(destinationFile.getPath());
				    fileInfo.setFileSize(inputFile[i].getSize());
				    fileList.add(fileInfo);
				    headers.add("File Uploaded Successfully - ", inputFile[i].getOriginalFilename());
				    
			   } catch (Exception e) {
				   LOGGER.error(INTERNAL_SERVER_ERROR+e);
				   return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			   }
			  }else{
			   return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			  }
		  } 
		  return new ResponseEntity<>(fileList, headers, HttpStatus.OK);
		 // return new ResponseEntity<>(HttpStatus.OK);
	 }
	 
	 /*@RequestMapping(value = "/fileupload1", headers=("content-type=multipart/*"), method = RequestMethod.POST)
	 public ResponseEntity<FileInfo> fileupload1(MultipartHttpServletRequest request) throws EvuntuManagementException{
		  LOGGER.info("FileUploadController::fileupload1-start");
		  
		  String userId = request.getParameter("userId");
		  String fileDesc = request.getParameter("fileDesc");
		  Iterator<String> itr = request.getFileNames();
		  
		  while (itr.hasNext()) {
				String uploadedFile = itr.next();
				file = request.getFile(uploadedFile);
				if (file != null) {
					FileDetails fileDetails = prepareObjectToStore(
							file, loggedInUserId, fileDesc,
							authString, strDetails, otp);
					fileDetList.add(fileDetails);
				}
				else {
					return new ResponseEntity<>(
							"Please upload file .",
							HttpStatus.BAD_REQUEST);
				}
			}
		  List<FileDetails> fileDetailsList = fileTransferManager
					.fileUpload(fileDetList);
		  
		  
		  
		  FileInfo fileInfo = new FileInfo();
		  HttpHeaders headers = new HttpHeaders();
		  if (!inputFile.isEmpty()) {
			   try {
				    File destinationFile = upload(inputFile);	    
				    
				    fileInfo.setFileName(destinationFile.getPath());
				    fileInfo.setFileSize(inputFile.getSize());
				    
				    headers.add("File Uploaded Successfully - ", inputFile.getOriginalFilename());
				    return new ResponseEntity<>(fileInfo, headers, HttpStatus.OK);
			   } catch (Exception e) {
				   LOGGER.error(INTERNAL_SERVER_ERROR+e);
				   return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			   }
		  }else{
		   return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		  }
	 }
*/
	/**
	 * @param inputFile
	 * @return
	 * @throws EvuntuManagementException 
	 * @throws IOException
	 */
	private File upload(MultipartFile inputFile) throws EvuntuManagementException  {
		LOGGER.info("FileUploadController::upload-start");
		String filePath="D:\\evuntuLog\\uploaded";
		String originalFilename = inputFile.getOriginalFilename();
		createFolderIfNotExists(filePath);
		File destinationFile = new File(filePath+  File.separator + originalFilename);
		try{
			inputFile.transferTo(destinationFile);
		}  catch (IOException e) {
			LOGGER.error(INTERNAL_SERVER_ERROR+e);
			throw new EvuntuManagementException("IO Exception occured::"+e);
		}
		LOGGER.info("FileUploadController::upload-end");
		return destinationFile;
	}

	private void createFolderIfNotExists(String dirName) throws SecurityException {
    	File theDir = new File(dirName);
    	if (!theDir.exists()) {
    		LOGGER.info("Folder created: "+dirName);
    		theDir.mkdir();
    	}
    }
	 
}