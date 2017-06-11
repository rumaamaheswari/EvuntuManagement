package com.evuntu.management.controller;

import java.net.URLDecoder;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.evuntu.management.exception.EvuntuManagementException;
import com.evuntu.management.model.Status;
import com.evuntu.management.services.EvuntuService;
import com.evuntu.management.util.PassHashHelper;
import com.evuntu.management.vo.AuthenticateResponseVO;


@RestController
@RequestMapping("/evuntu")
public class EvuntuManagementRestController {

	private static final String INTERNAL_SERVER_ERROR = "Internal server error";

	@Autowired
	EvuntuService evuntuServices;

	private static final Logger LOGGER = Logger.getLogger(EvuntuManagementRestController.class);
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.GET)
	public ResponseEntity<AuthenticateResponseVO> authenticate(@RequestParam(value="userName", required=true) String userName,@RequestParam(value="password", required=true) String password) throws EvuntuManagementException {
		LOGGER.info("EvuntuManagementRestController::authenticate-start");
		AuthenticateResponseVO status =new AuthenticateResponseVO();
		if (userName == null || userName.isEmpty()) {
			throw new EvuntuManagementException("Username is required");
		}
		if (password == null || password.isEmpty()) {
			throw new EvuntuManagementException("Password is required");
		}
		try {
			status = evuntuServices.authenticate(userName,password);	
			return new ResponseEntity<>(status,HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(INTERNAL_SERVER_ERROR+e);
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@RequestMapping(value = "/getPasswordHashCode", method = RequestMethod.GET)
	public ResponseEntity<Status> getPasswordHashCode(@RequestParam(value="password", required=true) String password) throws EvuntuManagementException {
		LOGGER.info("EvuntuManagementRestController::getPasswordHashCode-start");
		Status status=new Status();
		
		if (password == null || password.isEmpty()) {
			throw new EvuntuManagementException("Password is required");
		}
		try {				
			String hashedPassword=PassHashHelper.getHash(URLDecoder.decode(password, "UTF-8"));
			status.setMessage(hashedPassword);
			return new ResponseEntity<>(status,HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(INTERNAL_SERVER_ERROR+e);
			status=  new Status(0, e.toString());
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
}