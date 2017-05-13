package com.evuntu.management.controller;

import java.util.Arrays;
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
import org.springframework.web.multipart.MultipartFile;

import com.evuntu.management.model.Company;
import com.evuntu.management.model.Status;
import com.evuntu.management.services.EvuntuService;
import com.evuntu.management.vo.CompanyEventBiddingVO;
import com.evuntu.management.vo.CompanyVO;
import com.evuntu.management.vo.EventMasterVO;
import com.evuntu.management.vo.EventServicesVO;


@RestController
@RequestMapping("/evuntu/provider")
public class EvuntuProviderRestController {

	private static final String INTERNAL_SERVER_ERROR = "Internal server error";

	@Autowired
	EvuntuService evuntuServices;

	private static final Logger LOGGER = Logger.getLogger(EvuntuProviderRestController.class);

	
	@RequestMapping(value = "/createCompany", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> addCompany(@RequestBody CompanyVO company) {
		LOGGER.info("contoller::addCompany-start");
		Status status;
		try {
			evuntuServices.addCompany(company);
			status= new Status(1, "Company added Successfully !");
			return new ResponseEntity<>(status,HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(INTERNAL_SERVER_ERROR+e);
			status=  new Status(0, e.toString());
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/updateCompany", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> updateCompany(@RequestBody CompanyVO company) {
		LOGGER.info("contoller::updateCompany-start");
		Status status;
		if(company.getId()==null && company.getUserId()==null){
			LOGGER.error("company id and user id should not be null");
			status= new Status(0, "company id and user id should not be null");
			return new ResponseEntity<>(status,HttpStatus.BAD_REQUEST);
		}
		try {
			evuntuServices.updateCompany(company);
			status= new Status(1, "Company updated Successfully !");
			return new ResponseEntity<>(status,HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(INTERNAL_SERVER_ERROR+e);
			status=  new Status(0, e.toString());
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@RequestMapping(value = "/getCompany", method = RequestMethod.GET)
	public ResponseEntity<Company> getCompany(@RequestParam(value="id", required=true) long id) {
		LOGGER.info("contoller::getCompany-start");
		Company company = null;
		try {
			company = evuntuServices.getCompanyById(id);

		} catch (Exception e) {
			LOGGER.error(INTERNAL_SERVER_ERROR+e);
			return new ResponseEntity<>(company,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(company,HttpStatus.OK);
	}

	@RequestMapping(value = "/listCompany", method = RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<Company>> getCompanyList() {
		LOGGER.info("contoller::getCompanyList-start");
		List<Company> companyList = null;
		try {
			companyList = evuntuServices.listCompany();
		} catch (Exception e) {
			LOGGER.error(INTERNAL_SERVER_ERROR+e);
			return new ResponseEntity<>(companyList,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return  new ResponseEntity<>(companyList,HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteCompany", method = RequestMethod.GET)
	public ResponseEntity<Status> deleteCompany(@RequestParam(value="id", required=true) long id) {
		LOGGER.info("contoller::deleteCompany-start");
		Status status;
		try {
			evuntuServices.removeCompany(id);
			status= new Status(1, "Company deleted Successfully !");
			return new ResponseEntity<>(status,HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(INTERNAL_SERVER_ERROR+e);
			status=  new Status(0, e.toString());
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@RequestMapping(value = "/addEventServices", method = RequestMethod.POST, consumes = {"multipart/form-data"})
	public ResponseEntity<String> addEventServices(@RequestBody EventServicesVO eventServicesVO,@RequestParam("file") MultipartFile[] inputFile) {
		LOGGER.info("contoller::addEvent-start");
		Status status;
		Long companyId=eventServicesVO.getCompanyId();
		if(companyId==null || "".equals(companyId)){
			LOGGER.error("company id should not be null");
			status= new Status(0, "company id should not be null");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
		}		
		try{
			eventServicesVO.setInputFile(Arrays.asList(inputFile));
			evuntuServices.addEventServices(eventServicesVO);
			status= new Status(1, "EventServices added Successfully !");
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(INTERNAL_SERVER_ERROR+e);
			status=  new Status(0, e.toString());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@RequestMapping(value = "/updateEventServices", method = RequestMethod.POST)
	public ResponseEntity<Status> updateEventServices(@RequestBody EventServicesVO eventServices) {
		LOGGER.info("contoller::updateEvent-start");
		Status status;
		if(eventServices.getEventServiceId()==null){
			LOGGER.error("Event service id should not be null");
			status= new Status(0, "Event service id should not be null");
			return new ResponseEntity<>(status,HttpStatus.BAD_REQUEST);
		}
		try {
			evuntuServices.updateEventServices(eventServices);
			status= new Status(1, "Event service  updated Successfully !");
			return new ResponseEntity<>(status,HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(INTERNAL_SERVER_ERROR+e);
			status=  new Status(0, e.toString());
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@RequestMapping(value = "/getEventServices", method = RequestMethod.GET)
	public ResponseEntity<EventServicesVO> getEventServices(@RequestParam(value="id", required=true) long id) {
		LOGGER.info("contoller::getEventServices-start");
		EventServicesVO eventServices = null;
		try {
			eventServices = evuntuServices.getEventServicesById(id);

		} catch (Exception e) {
			LOGGER.error(INTERNAL_SERVER_ERROR+e);
			return new ResponseEntity<>(eventServices,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(eventServices,HttpStatus.OK);
	}

	@RequestMapping(value = "/searchEventServices", method = RequestMethod.GET)
	public ResponseEntity<List<EventServicesVO>> searchEventServices(@RequestParam(value="name") String name,@RequestParam(value="city") String city) {
		LOGGER.info("contoller::searchEventServices-start");
		List<EventServicesVO> eventServicesList = null;
		try {
			eventServicesList = evuntuServices.searchEventServices(name,city);
		} catch (Exception e) {
			LOGGER.error(INTERNAL_SERVER_ERROR+e);
			return new ResponseEntity<>(eventServicesList,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return  new ResponseEntity<>(eventServicesList,HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteEventServices", method = RequestMethod.GET)
	public ResponseEntity<Status> deleteEventServices(@RequestParam(value="id", required=true) long id) {
		LOGGER.info("contoller::deleteEvent-start");
		Status status;
		try {
			evuntuServices.deleteEventServices(id);
			status= new Status(1, "Event Services deleted Successfully !");
			return new ResponseEntity<>(status,HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(INTERNAL_SERVER_ERROR+e);
			status=  new Status(0, e.toString());
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@RequestMapping(value = "/getAllEvents", method = RequestMethod.GET)
	public ResponseEntity<List<EventMasterVO>> getAllEvents() {
		LOGGER.info("contoller::getAllEvents-start");
		List<EventMasterVO> eventList = null;
		try {
			eventList = evuntuServices.getAllEvents();

		} catch (Exception e) {
			LOGGER.error(INTERNAL_SERVER_ERROR+e);
			return new ResponseEntity<>(eventList,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(eventList,HttpStatus.OK);
	}
	@RequestMapping(value = "/addEvent", method = RequestMethod.POST)
	public ResponseEntity<Status> addEvent(@RequestBody EventMasterVO event) {
		LOGGER.info("contoller::addEvent-start");
		Status status;
		try {
			evuntuServices.addEvent(event);
			status= new Status(1, "Event added Successfully !");
			return new ResponseEntity<>(status,HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(INTERNAL_SERVER_ERROR+e);
			status=  new Status(0, e.toString());
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/addCompanyEventBidding", method = RequestMethod.POST)
	public ResponseEntity<Status> addCompanyEventBidding(@RequestBody CompanyEventBiddingVO companyEventBiddingVO) {
		LOGGER.info("contoller::addCompanyEventBidding-start");
		Status status;
		try {
			evuntuServices.addCompanyEventBidding(companyEventBiddingVO);
			status= new Status(1, "Bidding added Successfully !");
			return new ResponseEntity<>(status,HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(INTERNAL_SERVER_ERROR+e);
			status=  new Status(0, e.toString());
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/updateCompanyEventBidding", method = RequestMethod.POST)
	public ResponseEntity<Status> updateCompanyEventBidding(@RequestBody CompanyEventBiddingVO companyEventBiddingVO) {
		LOGGER.info("contoller::updateCompanyEventBidding-start");
		Status status;
		try {
			evuntuServices.updateCompanyEventBidding(companyEventBiddingVO);
			status= new Status(1, "Bidding updated Successfully !");
			return new ResponseEntity<>(status,HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(INTERNAL_SERVER_ERROR+e);
			status=  new Status(0, e.toString());
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/deleteCompanyEventBidding", method = RequestMethod.POST)
	public ResponseEntity<Status> deleteCompanyEventBidding(@RequestParam(value="id", required=true)long companyEventBiddingId) {
		LOGGER.info("contoller::deleteCompanyEventBidding-start");
		Status status;
		try {
			evuntuServices.removeCompanyEventBidding(companyEventBiddingId);
			status= new Status(1, "Bidding deleted Successfully !");
			return new ResponseEntity<>(status,HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(INTERNAL_SERVER_ERROR+e);
			status=  new Status(0, e.toString());
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/listCompanyEventBiddingByCompanyId", method = RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<CompanyEventBiddingVO>> listCompanyEventBiddingByCompanyId(long companyEventBiddingId) {
		LOGGER.info("contoller::listCompanyEventBiddingByCompanyId-start");
		List<CompanyEventBiddingVO> biddingList = null;
		try {
			biddingList = evuntuServices.listCompanyEventBiddingByCompanyId(companyEventBiddingId);
		} catch (Exception e) {
			LOGGER.error(INTERNAL_SERVER_ERROR+e);
			return new ResponseEntity<>(biddingList,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return  new ResponseEntity<>(biddingList,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getCompanyEventBiddingDetails", method = RequestMethod.GET, produces="application/json")
	public ResponseEntity<CompanyEventBiddingVO> getCompanyEventBiddingDetails(long companyEventBiddingId) {
		LOGGER.info("contoller::listCompanyEventBiddingByCompanyId-start");
		CompanyEventBiddingVO biddingDetails = null;
		try {
			biddingDetails = evuntuServices.getCompanyEventBiddingDetails(companyEventBiddingId);
		} catch (Exception e) {
			LOGGER.error(INTERNAL_SERVER_ERROR+e);
			return new ResponseEntity<>(biddingDetails,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return  new ResponseEntity<>(biddingDetails,HttpStatus.OK);
	}
	
	
}