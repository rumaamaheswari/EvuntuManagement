package com.evuntu.management.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.evuntu.management.exception.EvuntuManagementException;
import com.evuntu.management.model.Customer;
import com.evuntu.management.model.Status;
import com.evuntu.management.services.EvuntuService;
import com.evuntu.management.vo.CustomerVO;


@RestController
@RequestMapping("/evuntu/requester")
public class EvuntuRequesterRestController {

	private static final String INTERNAL_SERVER_ERROR = "Internal server error";

	@Autowired
	EvuntuService evuntuServices;

	private static final Logger LOGGER = Logger.getLogger(EvuntuRequesterRestController.class);

	@RequestMapping(value = "/createCustomer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> addCustomer(@RequestBody CustomerVO customer) {
		LOGGER.info("contoller::addCustomer-start");
		Status status;
		try {
			evuntuServices.addCustomer(customer);
			status= new Status(1, "Customers added Successfully !");
			return new ResponseEntity<>(status,HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(INTERNAL_SERVER_ERROR+e);
			status=  new Status(0, e.toString());
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/updateCustomer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> updateCustomer(@RequestBody CustomerVO customer) {
		Status status;
		LOGGER.info("contoller::updateCustomer-start");
		if(customer.getId()==null && customer.getUserId()==null){
			LOGGER.error("Customer id and user id should not be null");
			status=new Status(0, "Customer id and user id should not be null");
			return new ResponseEntity<>(status,HttpStatus.BAD_REQUEST);
		}
		try {
			evuntuServices.updateCustomer(customer);
			status= new Status(1, "Customers updated Successfully !");
			return new ResponseEntity<>(status,HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(INTERNAL_SERVER_ERROR+e);
			status=  new Status(0, e.toString());
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@RequestMapping(value = "/getCustomer", method = RequestMethod.GET)
	public ResponseEntity<Customer>  getCustomer(@RequestParam(value="id", required=true) long id) throws EvuntuManagementException {
		LOGGER.info("contoller::getCustomer-start");
		Customer customer = null;
		try {
			customer = evuntuServices.getCustomerById(id);

		} catch (Exception e) {
			LOGGER.error(INTERNAL_SERVER_ERROR+e);
			throw new EvuntuManagementException("Exception occured::"+e);
		}
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}

	@RequestMapping(value = "/listCustomer", method = RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<Customer>> getCustomerList() throws EvuntuManagementException {
		LOGGER.info("contoller::getCustomerList-start");
		List<Customer> customerList = null;
		try {
			customerList = evuntuServices.listCustomer();
		} catch (Exception e) {
			LOGGER.error(INTERNAL_SERVER_ERROR+e);
			throw new EvuntuManagementException("Exception occured::"+e);
		}
		return new ResponseEntity<>(customerList,HttpStatus.OK);
	}

	@RequestMapping(value = "deleteCustomer", method = RequestMethod.GET)
	public ResponseEntity<Status> deleteCustomer(@RequestParam(value="id", required=true) long id) {
		LOGGER.info("contoller::deleteCustomer-start");
		Status status;
		try {
			evuntuServices.removeCustomer(id);
			status= new Status(1, "Customer deleted Successfully !");
			return new ResponseEntity<>(status,HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(INTERNAL_SERVER_ERROR+e);
			status=  new Status(0, e.toString());
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	
}