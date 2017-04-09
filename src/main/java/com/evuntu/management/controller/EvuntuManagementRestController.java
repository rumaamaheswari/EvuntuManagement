//package com.evuntu.management.controller;
//
//import java.util.List;
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.evuntu.management.exception.EvuntuManagementException;
//import com.evuntu.management.model.Company;
//import com.evuntu.management.model.Customer;
//import com.evuntu.management.model.Status;
//import com.evuntu.management.services.EvuntuService;
//import com.evuntu.management.vo.CompanyVO;
//import com.evuntu.management.vo.CustomerVO;
//import com.evuntu.management.vo.EventServicesVO;
//
//
//@RestController
//@RequestMapping("/evuntu")
//public class EvuntuManagementRestController {
//
//	private static final String INTERNAL_SERVER_ERROR = "Internal server error";
//
//	@Autowired
//	EvuntuService evuntuServices;
//
//	private static final Logger LOGGER = Logger.getLogger(EvuntuManagementRestController.class);
//
//	@RequestMapping(value = "/createCustomer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Status> addCustomer(@RequestBody CustomerVO customer) {
//		LOGGER.info("contoller::addCustomer-start");
//		Status status;
//		try {
//			evuntuServices.addCustomer(customer);
//			status= new Status(1, "Customers added Successfully !");
//			return new ResponseEntity<>(status,HttpStatus.OK);
//		} catch (Exception e) {
//			LOGGER.error(INTERNAL_SERVER_ERROR+e);
//			status=  new Status(0, e.toString());
//			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}
//
//	@RequestMapping(value = "/updateCustomer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Status> updateCustomer(@RequestBody CustomerVO customer) {
//		Status status;
//		LOGGER.info("contoller::updateCustomer-start");
//		if(customer.getId()==null && customer.getUserId()==null){
//			LOGGER.error("Customer id and user id should not be null");
//			status=new Status(0, "Customer id and user id should not be null");
//			return new ResponseEntity<>(status,HttpStatus.BAD_REQUEST);
//		}
//		try {
//			evuntuServices.updateCustomer(customer);
//			status= new Status(1, "Customers updated Successfully !");
//			return new ResponseEntity<>(status,HttpStatus.OK);
//		} catch (Exception e) {
//			LOGGER.error(INTERNAL_SERVER_ERROR+e);
//			status=  new Status(0, e.toString());
//			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}
//	@RequestMapping(value = "/getCustomer/{id}", method = RequestMethod.GET)
//	public ResponseEntity<Customer>  getCustomer(@PathVariable("id") long id) throws EvuntuManagementException {
//		LOGGER.info("contoller::getCustomer-start");
//		Customer customer = null;
//		try {
//			customer = evuntuServices.getCustomerById(id);
//
//		} catch (Exception e) {
//			LOGGER.error(INTERNAL_SERVER_ERROR+e);
//			throw new EvuntuManagementException("Exception occured::"+e);
//		}
//		return new ResponseEntity<>(customer,HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/listCustomer", method = RequestMethod.GET, produces="application/json")
//	public ResponseEntity<List<Customer>> getCustomerList() throws EvuntuManagementException {
//		LOGGER.info("contoller::getCustomerList-start");
//		List<Customer> customerList = null;
//		try {
//			customerList = evuntuServices.listCustomer();
//		} catch (Exception e) {
//			LOGGER.error(INTERNAL_SERVER_ERROR+e);
//			throw new EvuntuManagementException("Exception occured::"+e);
//		}
//		return new ResponseEntity<>(customerList,HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "deleteCustomer/{id}", method = RequestMethod.GET)
//	public ResponseEntity<Status> deleteCustomer(@PathVariable("id") long id) {
//		LOGGER.info("contoller::deleteCustomer-start");
//		Status status;
//		try {
//			evuntuServices.removeCustomer(id);
//			status= new Status(1, "Customer deleted Successfully !");
//			return new ResponseEntity<>(status,HttpStatus.OK);
//		} catch (Exception e) {
//			LOGGER.error(INTERNAL_SERVER_ERROR+e);
//			status=  new Status(0, e.toString());
//			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}
//	/*@RequestMapping(value = "/authenticate", method = RequestMethod.GET)
//	public @ResponseBody Customer getCustomer(@RequestParam("userName") String userName,@RequestParam("password") String password) {
//		LOGGER.info("contoller::getCustomer-start");
//		Customer customer = null;
//		try {
//			customer = evuntuServices.authenticate(userName,password);
//
//		} catch (Exception e) {
//			LOGGER.error("Internal server error"+e);
//		}
//		return customer;
//	}*/
//	
//	@RequestMapping(value = "/createCompany", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Status> addCompany(@RequestBody CompanyVO company) {
//		LOGGER.info("contoller::addCompany-start");
//		Status status;
//		try {
//			evuntuServices.addCompany(company);
//			status= new Status(1, "Company added Successfully !");
//			return new ResponseEntity<>(status,HttpStatus.OK);
//		} catch (Exception e) {
//			LOGGER.error(INTERNAL_SERVER_ERROR+e);
//			status=  new Status(0, e.toString());
//			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}
//
//	@RequestMapping(value = "/updateCompany", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Status> updateCompany(@RequestBody CompanyVO company) {
//		LOGGER.info("contoller::updateCompany-start");
//		Status status;
//		if(company.getId()==null && company.getUserId()==null){
//			LOGGER.error("company id and user id should not be null");
//			status= new Status(0, "company id and user id should not be null");
//			return new ResponseEntity<>(status,HttpStatus.OK);
//		}
//		try {
//			evuntuServices.updateCompany(company);
//			status= new Status(1, "Company updated Successfully !");
//			return new ResponseEntity<>(status,HttpStatus.OK);
//		} catch (Exception e) {
//			LOGGER.error(INTERNAL_SERVER_ERROR+e);
//			status=  new Status(0, e.toString());
//			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}
//	@RequestMapping(value = "/getCompany/{id}", method = RequestMethod.GET)
//	public ResponseEntity<Company> getCompany(@PathVariable("id") long id) {
//		LOGGER.info("contoller::getCompany-start");
//		Company company = null;
//		try {
//			company = evuntuServices.getCompanyById(id);
//
//		} catch (Exception e) {
//			LOGGER.error(INTERNAL_SERVER_ERROR+e);
//			return new ResponseEntity<>(company,HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		return new ResponseEntity<>(company,HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/listCompany", method = RequestMethod.GET, produces="application/json")
//	public ResponseEntity<List<Company>> getCompanyList() {
//		LOGGER.info("contoller::getCompanyList-start");
//		List<Company> companyList = null;
//		try {
//			companyList = evuntuServices.listCompany();
//		} catch (Exception e) {
//			LOGGER.error(INTERNAL_SERVER_ERROR+e);
//			return new ResponseEntity<>(companyList,HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		return  new ResponseEntity<>(companyList,HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "deleteCompany/{id}", method = RequestMethod.GET)
//	public ResponseEntity<Status> deleteCompany(@PathVariable("id") long id) {
//		LOGGER.info("contoller::deleteCompany-start");
//		Status status;
//		try {
//			evuntuServices.removeCompany(id);
//			status= new Status(1, "Company deleted Successfully !");
//			return new ResponseEntity<>(status,HttpStatus.OK);
//		} catch (Exception e) {
//			LOGGER.error(INTERNAL_SERVER_ERROR+e);
//			status=  new Status(0, e.toString());
//			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}
//	
//	@RequestMapping(value = "/createEvent", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Status> addEventServices(@RequestBody EventServicesVO eventServices) {
//		LOGGER.info("contoller::addEvent-start");
//		Status status;
//		try {
//			evuntuServices.addEventServices(eventServices);
//			status= new Status(1, "EventServices added Successfully !");
//			return new ResponseEntity<>(status,HttpStatus.OK);
//		} catch (Exception e) {
//			LOGGER.error(INTERNAL_SERVER_ERROR+e);
//			status=  new Status(0, e.toString());
//			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}
//	
//	
//	
//	
//	
//	
//	
//}