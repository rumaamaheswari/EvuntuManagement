/**
 * 
 */
package com.evuntu.management.helper;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.evuntu.management.exception.EvuntuManagementException;
import com.evuntu.management.model.Company;
import com.evuntu.management.model.Customer;
import com.evuntu.management.model.CustomerEventRequest;
import com.evuntu.management.model.EventMaster;
import com.evuntu.management.model.EventServices;
import com.evuntu.management.model.Facility;
import com.evuntu.management.model.User;
import com.evuntu.management.util.PassHashHelper;
import com.evuntu.management.vo.CompanyVO;
import com.evuntu.management.vo.CustomerEventRequestVO;
import com.evuntu.management.vo.CustomerVO;
import com.evuntu.management.vo.EventMasterVO;
import com.evuntu.management.vo.EventServicesVO;
import com.evuntu.management.vo.FacilityVO;


/**
 * @author umaa maheswari
 *
 */
public class EvuntuManagementHelper {
	
		private static final Logger LOGGER = Logger.getLogger(EvuntuManagementHelper.class);  
		
		public User convertCustomerVOToUserDO(CustomerVO customerVO) throws EvuntuManagementException {
			LOGGER.info("Helper::convertCustomerVOToUserDO-start");
			User user=new User();
			try{		
				user.setId(customerVO.getUserId());
				user.setUserName(customerVO.getUserName());
				user.setPassword(PassHashHelper.getHash(customerVO.getUserPassword()));
				user.setUserType(customerVO.getUserType());
			}
			catch(Exception e){
				throw new EvuntuManagementException("Excption while converting VO to DO"+e);
			}
			LOGGER.info("Helper::convertCustomerVOToUserDO-end");
			return user;
		}
		

		public Customer convertCustomerVOToDO(CustomerVO customerVO) throws EvuntuManagementException {
			LOGGER.info("Helper::convertCustomerVOToDO-start");
			Customer customer = new Customer();
			try{				
				customer.setId(customerVO.getId());
				customer.setFirstName(customerVO.getFirstName());
				customer.setLastName(customerVO.getLastName());
				customer.setMobileNumber(customerVO.getMobileNumber());
				customer.setAllowToContact(customerVO.getAllowToContact());
				customer.setPurpose(customerVO.getPurpose());
				customer.setEmailAddress(customerVO.getEmailAddress());
				customer.setUserId(customerVO.getUserId());
				
			}
			catch(Exception e){
				throw new EvuntuManagementException("Excption while converting VO to DO"+e);
			}
			LOGGER.info("Helper::convertCustomerVOToDO-end");
			return customer;
		}
		
		public List<CustomerVO> convertCustomerDOToVO(List<Customer> customerList) throws EvuntuManagementException {
			LOGGER.info("Helper::convertCustomerDOToVO-start");
			List<CustomerVO> customerVOList=new ArrayList<>();
			for(Customer customer:customerList){
				CustomerVO customerVO = new CustomerVO();
				try{
					customer.setId(customer.getId());
					customer.setFirstName(customer.getFirstName());
					customer.setLastName(customer.getLastName());
					customer.setMobileNumber(customer.getMobileNumber());
					customer.setAllowToContact(customer.getAllowToContact());
					customer.setMobileNumber(customer.getMobileNumber());
					customer.setEmailAddress(customer.getEmailAddress());
					customerVOList.add(customerVO);
				}
				catch(Exception e){ 
					throw new EvuntuManagementException("Exception while converting VO to DO"+e);
				}
			}
			LOGGER.info("Helper::convertCustomerDOToVO-end");
			return customerVOList;
		}
		
		public User convertCompanyVOToUserDO(CompanyVO companyVO) throws EvuntuManagementException {
			LOGGER.info("Helper::convertCompanyrVOToUserDO-start");
			User user=new User();
			try{		
				user.setId(companyVO.getUserId());
				user.setUserName(companyVO.getUserName());
				user.setPassword(PassHashHelper.getHash(companyVO.getUserPassword()));
				//String pwd=PassHashHelper.getHash(companyVO.getUserPassword());
				user.setUserType(companyVO.getUserType());
			}
			catch(Exception e){
				throw new EvuntuManagementException("Excption while converting VO to DO"+e);
			}
			LOGGER.info("Helper::convertCompanyrVOToUserDO-end");
			return user;
		}

		
		public Company convertCompanyVOToDO(CompanyVO companyVO) throws EvuntuManagementException {
			LOGGER.info("Helper::convertCompanyVOToDO-start");
			Company company = new Company();
			try{				
				company.setId(companyVO.getId());
				company.setCompanyName(companyVO.getCompanyName());
				company.setAddress(companyVO.getAddress());
				company.setMobileNumber(companyVO.getMobileNumber());
				company.setContactPerson(companyVO.getContactPerson());
				company.setFaceBookLink(companyVO.getFaceBookLink());
				company.setWebsite(companyVO.getWebsite());
				company.setYouTubeLink(companyVO.getYouTubeLink());
				company.setBranchName(companyVO.getBranchName());
				company.setCity(companyVO.getCity());
				company.setOfficeNumber(companyVO.getOfficeNumber());
				company.setState(companyVO.getState());
				company.setCountry(companyVO.getCountry());
			}
			catch(Exception e){
				throw new EvuntuManagementException("Excption while converting VO to DO"+e);
			}
			LOGGER.info("Helper::convertCompanyVOToDO-end");
			return company;
		}
		public List<CompanyVO> convertCompanyDOToVO(List<Company> companylist) throws EvuntuManagementException {
			LOGGER.info("Helper::convertCustomerDOToVO-start");
			List<CompanyVO> companyVOList=new ArrayList<>();
			for(Company company:companylist){
				CompanyVO companyVO = new CompanyVO();
				try{
					companyVO.setId(company.getId());
					companyVO.setCompanyName(company.getCompanyName());
					companyVO.setAddress(company.getAddress());
					companyVO.setMobileNumber(company.getMobileNumber());
					companyVO.setContactPerson(company.getContactPerson());
					companyVO.setFaceBookLink(company.getMobileNumber());
					companyVO.setWebsite(company.getWebsite());
					companyVO.setYouTubeLink(company.getYouTubeLink());
					companyVO.setBranchName(company.getBranchName());
					companyVO.setCity(company.getCity());
					companyVO.setOfficeNumber(company.getOfficeNumber());
					companyVO.setState(company.getState());
					companyVO.setCountry(company.getCountry());
					companyVOList.add(companyVO);
				}
				catch(Exception e){ 
					throw new EvuntuManagementException("Excption while converting VO to DO"+e);
				}
			}
			LOGGER.info("Helper::convertCompanyDOToVO-end");
			return companyVOList;
		}


		public EventMaster convertEventMasterVOToEventMasterDO(EventMasterVO eventVO) throws EvuntuManagementException {
			LOGGER.info("Helper::convertEventMasterVOToUserDO-start");
			EventMaster eventMaster = new EventMaster();
			try{
				for(FacilityVO facilityVO:eventVO.getFacility()){
					Facility facility=new Facility();
					facility.setFacilityId(facilityVO.getFacilityId());
					facility.setFacilityName(facilityVO.getFacilityName());
					eventMaster.getFacility().add(facility);
				}
				eventMaster.setEventId(eventVO.getEventId());
				eventMaster.setEventName(eventVO.getEventName());
				
			}
			catch(Exception e){ 
				throw new EvuntuManagementException("Excption while converting VO to DO"+e);
			}
			LOGGER.info("Helper::convertCompanyDOToVO-end");
			return eventMaster;
		}


		public List<EventMasterVO> convertEventMasterDOToEventMasterVO(List<EventMaster> eventDOList) throws EvuntuManagementException {
			LOGGER.info("Helper::convertEventMasterDOToEventMasterVO-start");
			List<EventMasterVO> eventVOList=new ArrayList<>();
			
			try{
				for(EventMaster eventVO:eventDOList){
					
					EventMasterVO eventMasterVO = new EventMasterVO();
					
					for(Facility facility:eventVO.getFacility()){
						FacilityVO facilityVO=new FacilityVO();
						facilityVO.setFacilityId(facility.getFacilityId());
						facilityVO.setFacilityName(facility.getFacilityName());	
						eventMasterVO.getFacility().add(facilityVO);
					}	
					//eventMasterVO.getFacility().add(facilityVO);
					eventMasterVO.setEventId(eventVO.getEventId());
					eventMasterVO.setEventName(eventVO.getEventName());
					eventVOList.add(eventMasterVO);
				}
				
			}
			catch(Exception e){ 
				throw new EvuntuManagementException("Excption while converting VO to DO"+e);
			}
			LOGGER.info("Helper::convertEventMasterDOToEventMasterVO-end");
			return eventVOList;
		}


		public CustomerEventRequest convertCustomerEventRequestVOToDO(CustomerEventRequestVO customerEventReqVO) throws EvuntuManagementException {
			LOGGER.info("Helper::convertCustomerEventRequestToDO-start");
			CustomerEventRequest customerEventRequest = new CustomerEventRequest();
			try{				
				customerEventRequest.setCustomerEventRequestId(customerEventReqVO.getCustomerEventRequestId());
				customerEventRequest.setUserId(customerEventReqVO.getUserId());
				customerEventRequest.setEventId(customerEventReqVO.getEventId());
				customerEventRequest.setFacilityId(customerEventReqVO.getFacilityId());
				customerEventRequest.setBudget(customerEventReqVO.getBudget());
				customerEventRequest.setExpectations(customerEventReqVO.getExpectations());
				
			}
			catch(Exception e){
				throw new EvuntuManagementException("Excption while converting VO to DO"+e);
			}
			LOGGER.info("Helper::convertCustomerEventRequestVOToDO-end");
			return customerEventRequest;
		}
		public CustomerEventRequestVO convertCustomerEventRequestDOToVO(CustomerEventRequest customerEventReq) throws EvuntuManagementException {
			LOGGER.info("Helper::convertCustomerEventRequestDOToVO-start");
			CustomerEventRequestVO customerEventRequestVO = new CustomerEventRequestVO();
			try{				
				customerEventRequestVO.setCustomerEventRequestId(customerEventReq.getCustomerEventRequestId());
				customerEventRequestVO.setUserId(customerEventReq.getUserId());
				customerEventRequestVO.setEventId(customerEventReq.getEventId());
				customerEventRequestVO.setFacilityId(customerEventReq.getFacilityId());
				customerEventRequestVO.setBudget(customerEventReq.getBudget());
				customerEventRequestVO.setExpectations(customerEventReq.getExpectations());
				
			}
			catch(Exception e){
				throw new EvuntuManagementException("Excption while converting VO to DO"+e);
			}
			LOGGER.info("Helper::convertCustomerEventRequestVOToDO-end");
			return customerEventRequestVO;
		}


		public List<EventServicesVO> convertEventServicesDOtoVO(List<EventServices> EventServicesList) throws EvuntuManagementException {
			LOGGER.info("Helper::convertEventServicesDOtoVO-start");
			List<EventServicesVO> eventServicesVOList=new ArrayList<>();
			for(EventServices eventServices:EventServicesList){
				try{				
					EventServicesVO eventServicesVO = new EventServicesVO();
					eventServicesVO.setCompanyId(eventServices.getCompanyId());
					eventServicesVO.setCity(eventServices.getCity());
					eventServicesVO.setContactNumber(eventServices.getContactNumber());
					eventServicesVO.setContactPerson(eventServices.getContactPerson());
					eventServicesVO.setEventName(eventServices.getEventName());
					eventServicesVO.setEventServiceId(eventServices.getId());
					eventServicesVO.setFaceBookLink(eventServices.getFaceBookLink());
					eventServicesVO.setFileId(eventServices.getFileId());
					eventServicesVO.setYouTubeLink(eventServices.getFaceBookLink());
					eventServicesVOList.add(eventServicesVO);
				}
				catch(Exception e){
					throw new EvuntuManagementException("Excption while converting VO to DO"+e);
				}
			}
			return eventServicesVOList;
		}

}
	
