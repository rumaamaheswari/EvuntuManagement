/**
 * 
 */
package com.evuntu.management.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import com.evuntu.management.exception.EvuntuManagementException;
import com.evuntu.management.model.Company;
import com.evuntu.management.model.Customer;
import com.evuntu.management.model.CustomerEventRequest;
import com.evuntu.management.model.EventFacility;
import com.evuntu.management.model.EventFacilityDetailsVO;
import com.evuntu.management.model.EventMaster;
import com.evuntu.management.model.EventServices;
import com.evuntu.management.model.Facility;
import com.evuntu.management.model.FileDetails;
import com.evuntu.management.model.User;
import com.evuntu.management.util.PassHashHelper;
import com.evuntu.management.vo.CompanyRequestVO;
import com.evuntu.management.vo.CompanyResponseVO;
import com.evuntu.management.vo.CustomerEventRequestVO;
import com.evuntu.management.vo.CustomerRequestVO;
import com.evuntu.management.vo.CustomerResponseVO;
import com.evuntu.management.vo.EventMasterVO;
import com.evuntu.management.vo.EventServicesResponseVO;
import com.evuntu.management.vo.FacilityVO;
import com.evuntu.management.vo.FileDetailsVO;


/**
 * @author umaa maheswari
 *
 */
public class EvuntuManagementHelper {
	
		private static final String EXCEPTION_WHILE_CONVERTING_VO_TO_DO = "Exception while converting VO to DO";
		private static final Logger LOGGER = Logger.getLogger(EvuntuManagementHelper.class);  
		
		public User convertCustomerVOToUserDO(CustomerRequestVO customerVO) throws EvuntuManagementException {
			LOGGER.info("Helper::convertCustomerVOToUserDO-start");
			User user=new User();
			try{		
				user.setId(customerVO.getUserId());
				user.setUserName(customerVO.getUserName());
				user.setPassword(PassHashHelper.getHash(customerVO.getUserPassword()));
				user.setUserType("CUSTOMER");
			}
			catch(Exception e){
				throw new EvuntuManagementException(EXCEPTION_WHILE_CONVERTING_VO_TO_DO+e);
			}
			LOGGER.info("Helper::convertCustomerVOToUserDO-end");
			return user;
		}
		

		public Customer convertCustomerVOToDO(CustomerRequestVO customerVO) throws EvuntuManagementException {
			LOGGER.info("Helper::convertCustomerVOToDO-start");
			Customer customer = new Customer();
			try{		
				customer.setUser(convertCustomerVOToUserDO(customerVO));
				customer.setId(customerVO.getId());
				customer.setFirstName(customerVO.getFirstName());
				customer.setLastName(customerVO.getLastName());
				customer.setMobileNumber(customerVO.getMobileNumber());
				customer.setAllowToContact(customerVO.getAllowToContact());
				customer.setPurpose(customerVO.getPurpose());
				customer.setEmailAddress(customerVO.getEmailAddress());				
			}
			catch(Exception e){
				throw new EvuntuManagementException(EXCEPTION_WHILE_CONVERTING_VO_TO_DO+e);
			}
			LOGGER.info("Helper::convertCustomerVOToDO-end");
			return customer;
		}
		
		public CustomerResponseVO convertCustomerDOToVO(Customer customer) throws EvuntuManagementException {
			LOGGER.info("Helper::convertCustomerDOToVO-start");
			CustomerResponseVO customerVO = new CustomerResponseVO();
				try{
					customerVO.setId(customer.getId());
					customerVO.setFirstName(customer.getFirstName());
					customerVO.setLastName(customer.getLastName());
					customerVO.setMobileNumber(customer.getMobileNumber());
					customerVO.setEmailAddress(customer.getEmailAddress());
					customerVO.setPurpose(customer.getPurpose());
					customerVO.setUserId(customer.getUser().getId());
					customerVO.setUserName(customer.getUser().getUserName());
					customerVO.setUserType(customer.getUser().getUserType());
				}
				catch(Exception e){ 
					throw new EvuntuManagementException(EXCEPTION_WHILE_CONVERTING_VO_TO_DO+e);
				}
			   return customerVO;			
		}
		
		public User convertCompanyVOToUserDO(CompanyRequestVO companyVO) throws EvuntuManagementException {
			LOGGER.info("Helper::convertCompanyrVOToUserDO-start");
			User user=new User();
			try{		
				user.setId(companyVO.getUserId());
				user.setUserName(companyVO.getUserName());
				user.setPassword(PassHashHelper.getHash(companyVO.getUserPassword()));
				//String pwd=PassHashHelper.getHash(companyVO.getUserPassword());
				user.setUserType("COMPANY");
			}
			catch(Exception e){
				throw new EvuntuManagementException(EXCEPTION_WHILE_CONVERTING_VO_TO_DO+e);
			}
			LOGGER.info("Helper::convertCompanyrVOToUserDO-end");
			return user;
		}

		
		public Company convertCompanyVOToDO(CompanyRequestVO companyVO) throws EvuntuManagementException {
			LOGGER.info("Helper::convertCompanyVOToDO-start");
			Company company = new Company();
			try{		
				company.setUser(convertCompanyVOToUserDO(companyVO));
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
				throw new EvuntuManagementException(EXCEPTION_WHILE_CONVERTING_VO_TO_DO+e);
			}
			LOGGER.info("Helper::convertCompanyVOToDO-end");
			return company;
		}
		public CompanyResponseVO convertCompanyDOToVO(Company company) throws EvuntuManagementException {
			LOGGER.info("Helper::convertCustomerDOToVO-start");
			CompanyResponseVO companyVO = new CompanyResponseVO();
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
				companyVO.setUserId(company.getUser().getId());
				companyVO.setUserName(company.getUser().getUserName());
				companyVO.setUserType(company.getUser().getUserType());
			}
			catch(Exception e){ 
				throw new EvuntuManagementException(EXCEPTION_WHILE_CONVERTING_VO_TO_DO+e);
			}
			LOGGER.info("Helper::convertCompanyDOToVO-end");
			return companyVO;
		}


		public EventFacility convertEventMasterVOToDO(EventMaster eventMaster,FacilityVO facilityVO) throws EvuntuManagementException {
			LOGGER.info("Helper::convertEventMasterVOToUserDO-start");
			EventFacility eventFacility=new EventFacility();
			try{			
								
				Facility facility=new Facility(facilityVO.getFacilityId(),facilityVO.getFacilityName());
				eventFacility.setEvent(eventMaster);
				eventFacility.setFacility(facility);
				
			}
			catch(Exception e){ 
				throw new EvuntuManagementException(EXCEPTION_WHILE_CONVERTING_VO_TO_DO+e);
			}
			LOGGER.info("Helper::convertCompanyDOToVO-end");
			return eventFacility;
		}


		public List<EventMasterVO> convertEventMasterDOToEventMasterVO(List<EventFacilityDetailsVO> eventDOList) throws EvuntuManagementException {
			LOGGER.info("Helper::convertEventMasterDOToEventMasterVO-start");
			List<EventMasterVO> eventVOList=new ArrayList<>();
			SortedSet<EventMasterVO> uniqueEventList=new TreeSet<>();

			try{
				for(EventFacilityDetailsVO eventVO:eventDOList){
					EventMasterVO eventMasterVO=new EventMasterVO();
					eventMasterVO.setEventId(eventVO.getEventId());
					eventMasterVO.setEventName(eventVO.getEventName());
					uniqueEventList.add(eventMasterVO);
				}
				for(EventMasterVO event:uniqueEventList){	
					generateFacilityListForeEachUniqueEvent(eventDOList, event);
					eventVOList.add(event);	
				}
				
			}
			catch(Exception e){ 
				throw new EvuntuManagementException("Excption while converting VO to DO"+e);
			}
			LOGGER.info("Helper::convertEventMasterDOToEventMasterVO-end");
			return eventVOList;
		}


		/**
		 * @param eventDOList
		 * @param event
		 */
		private void generateFacilityListForeEachUniqueEvent(List<EventFacilityDetailsVO> eventDOList,
				EventMasterVO event) {
			LOGGER.info("Helper::generateFacilityListForeEachUniqueEvent-start");
			List<FacilityVO> fList=new ArrayList<>();
			for(EventFacilityDetailsVO eventVO:eventDOList){								
				if(event.getEventId()==eventVO.getEventId()){
					FacilityVO facilityVO=new FacilityVO();
					facilityVO.setFacilityId(eventVO.getFacilityId());
					facilityVO.setFacilityName(eventVO.getFacilityName());	
					fList.add(facilityVO);							
					event.setFacility(fList);
				}										
			}
			LOGGER.info("Helper::generateFacilityListForeEachUniqueEvent-end");
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
				throw new EvuntuManagementException(EXCEPTION_WHILE_CONVERTING_VO_TO_DO+e);
			}
			LOGGER.info("Helper::convertCustomerEventRequestVOToDO-end");
			return customerEventRequestVO;
		}


		public EventServicesResponseVO convertEventServicesDOtoVO(EventServices eventServices) throws EvuntuManagementException {
			LOGGER.info("Helper::convertEventServicesDOtoVO-start");
				EventServicesResponseVO eventServicesVO = new EventServicesResponseVO();
				List<FileDetailsVO> fileDetailsVOList=new ArrayList<>();
				try{				
					eventServicesVO.setCompanyId(eventServices.getCompanyId());
					eventServicesVO.setCity(eventServices.getCity());
					eventServicesVO.setContactNumber(eventServices.getContactNumber());
					eventServicesVO.setContactPerson(eventServices.getContactPerson());
					//eventServicesVO.setEventName(eventServices.getEventName());
					eventServicesVO.setEventServiceId(eventServices.getEventServiceId());
					eventServicesVO.setFaceBookLink(eventServices.getFacebookLink());
					eventServicesVO.setYouTubeLink(eventServices.getYoutubeLink());
					for(FileDetails fileDetails:eventServices.getFileDetails()){
						FileDetailsVO fileDetailsVO=new FileDetailsVO();
						fileDetailsVO.setFileId(fileDetails.getFileId());
						fileDetailsVO.setFileName(fileDetails.getFileName());
						fileDetailsVO.setFilePath(fileDetails.getFilePath());
						fileDetailsVO.setFileType(fileDetails.getFileType());
						fileDetailsVOList.add(fileDetailsVO);
					}
					eventServicesVO.setFileDetails(fileDetailsVOList);					
				}
				catch(Exception e){
					throw new EvuntuManagementException(EXCEPTION_WHILE_CONVERTING_VO_TO_DO+e);
				}
		
			return eventServicesVO;
		}

}
	
