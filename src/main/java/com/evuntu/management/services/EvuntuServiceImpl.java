package com.evuntu.management.services;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.evuntu.management.dao.EvuntuDAO;
import com.evuntu.management.exception.EvuntuManagementException;
import com.evuntu.management.helper.EvuntuManagementHelper;
import com.evuntu.management.model.Company;
import com.evuntu.management.model.CompanyEventBidding;
import com.evuntu.management.model.Customer;
import com.evuntu.management.model.CustomerEventRequest;
import com.evuntu.management.model.EventFacilityDetailsVO;
import com.evuntu.management.model.EventMaster;
import com.evuntu.management.model.EventServices;
import com.evuntu.management.model.FileDetails;
import com.evuntu.management.model.User;
import com.evuntu.management.util.FileUploadUtil;
import com.evuntu.management.vo.CompanyEventBiddingVO;
import com.evuntu.management.vo.CompanyRequestVO;
import com.evuntu.management.vo.CompanyResponseVO;
import com.evuntu.management.vo.CustomerEventRequestVO;
import com.evuntu.management.vo.CustomerRequestVO;
import com.evuntu.management.vo.CustomerResponseVO;
import com.evuntu.management.vo.EventMasterVO;
import com.evuntu.management.vo.EventServicesResponseVO;
import com.evuntu.management.vo.EventServicesVO;
import com.evuntu.management.vo.FacilityVO;



@Service
public class EvuntuServiceImpl implements EvuntuService {
	private static final String ERROR_WHILE_ACCESSING_DB = "Error while accessing DB";

	@Autowired
	private EvuntuDAO evuntuDAO;
	
	private static final Logger LOGGER = Logger.getLogger(EvuntuManagementHelper.class); 
		
	@Override
	public boolean addCustomer(CustomerRequestVO customerVO) throws EvuntuManagementException {
		LOGGER.info("Service::addCustomer-start");
		try{
			EvuntuManagementHelper helper=new EvuntuManagementHelper();
			/*Long id=evuntuDAO.addUser(helper.convertCustomerVOToUserDO(customerVO));
			customerVO.setUserId(id);*/
			evuntuDAO.addCustomer(helper.convertCustomerVOToDO(customerVO));
		}
		catch(HibernateException he){
			throw new EvuntuManagementException(ERROR_WHILE_ACCESSING_DB+he);
		}
		return true;	
	}

	@Override
	public boolean updateCustomer(CustomerRequestVO customerVO) throws EvuntuManagementException{
		LOGGER.info("Service::updateCustomer-start");
		try{
			EvuntuManagementHelper helper=new EvuntuManagementHelper();
			return evuntuDAO.updateCustomer(helper.convertCustomerVOToDO(customerVO));
		}
		catch(HibernateException he){
			throw new EvuntuManagementException(ERROR_WHILE_ACCESSING_DB+he);
		}		
	}

	@Override
	public List<CustomerResponseVO> listCustomer() throws EvuntuManagementException{
		LOGGER.info("Service::listCustomer-start");
		EvuntuManagementHelper helper=new EvuntuManagementHelper();
		List<CustomerResponseVO> customerList=new ArrayList<>();
		for(Customer customer:evuntuDAO.listCustomer()){			
			customerList.add(helper.convertCustomerDOToVO(customer));
		}
		return customerList;
	}

	@Override
	public CustomerResponseVO getCustomerById(Long id) throws EvuntuManagementException { 
		LOGGER.info("Service::getCustomerById-start");
		EvuntuManagementHelper helper=new EvuntuManagementHelper();
		List<Customer> list=evuntuDAO.getCustomerById(id);
		CustomerResponseVO customer=new CustomerResponseVO();
		if(list.isEmpty()){			
			return new CustomerResponseVO();
		}else{
			customer=helper.convertCustomerDOToVO(list.get(0));
		}
		return customer;
	}

	@Override
	public boolean removeCustomer(Long id)throws EvuntuManagementException {
		LOGGER.info("Service::removeCustomer-start");
		return evuntuDAO.removeCustomer(id);		
	}
	
	@Override
	public boolean addCompany(CompanyRequestVO companyVO) throws EvuntuManagementException {
		LOGGER.info("Service::addCompany-start");
		/*EvuntuManagementHelper helper=new EvuntuManagementHelper();
		return evuntuDAO.addCompany(helper.convertCompanyVOToDO(companyVO));*/
		try{
			EvuntuManagementHelper helper=new EvuntuManagementHelper();
			/*Long id=evuntuDAO.addUser(helper.convertCompanyVOToUserDO(companyVO));
			companyVO.setUserId(id);*/
			evuntuDAO.addCompany(helper.convertCompanyVOToDO(companyVO));
		}
		catch(HibernateException he){
			throw new EvuntuManagementException(ERROR_WHILE_ACCESSING_DB+he);
		}
		return true;
	}

	@Override
	public boolean updateCompany(CompanyRequestVO companyVO) throws EvuntuManagementException {
		LOGGER.info("Service::updateCompany-start");
		try{
			EvuntuManagementHelper helper=new EvuntuManagementHelper();
			return evuntuDAO.updateCompany(helper.convertCompanyVOToDO(companyVO));
		}
		catch(HibernateException he){
			throw new EvuntuManagementException(ERROR_WHILE_ACCESSING_DB+he);
		}	
	}

	@Override
	public CompanyResponseVO getCompanyById(long id) throws EvuntuManagementException {
		LOGGER.info("Service::getCompanyById-start");
		EvuntuManagementHelper helper=new EvuntuManagementHelper();
		List<Company> list=evuntuDAO.getCompanyById(id);
		CompanyResponseVO company=new CompanyResponseVO();
		if(list.isEmpty()){			
			return new CompanyResponseVO();
		}else{
			company=helper.convertCompanyDOToVO(list.get(0));
		}
		return company;
	}

	@Override
	public List<CompanyResponseVO> listCompany() throws EvuntuManagementException {
		LOGGER.info("Service::listCompany-start");
		EvuntuManagementHelper helper=new EvuntuManagementHelper();
		List<CompanyResponseVO> companyList=new ArrayList<>();
		for(Company company:evuntuDAO.listCompany()){			
			companyList.add(helper.convertCompanyDOToVO(company));
		}
		return companyList;
	}

	@Override
	public boolean removeCompany(long id) throws EvuntuManagementException {
		LOGGER.info("Service::removeCompany-start");
		return evuntuDAO.removeCompany(id);	
		
	}
	
  	@Override
	public boolean addEventServices(EventServicesVO eventServicesVO) throws EvuntuManagementException {
		LOGGER.info("Service::addEventServices-start");
		List<FileDetails> fileDetList= new ArrayList<>();
		EventServices eServices=new EventServices();		
		BeanUtils.copyProperties(eventServicesVO, eServices);
		Long eventId=evuntuDAO.addEventServices(eServices);
		FileUploadUtil fileUtil=new FileUploadUtil();
		for(MultipartFile file:eventServicesVO.getInputFile()){
			if (file != null && (!file.isEmpty())) {
			    fileUtil.upload(file,eventServicesVO.getCompanyId()); 
			    FileDetails fileDetails =fileUtil.prepareObjectToStore(file);
				fileDetList.add(fileDetails);
			}
		}
		evuntuDAO.fileUpload(fileDetList);		
		return true; 
	}
	
	@Override
	public boolean updateEventServices(EventServicesVO eventServices) throws EvuntuManagementException {
		LOGGER.info("Service::updateEventServices-start");
		try{
			EventServices eServices=new EventServices();
			BeanUtils.copyProperties(eventServices, eServices);
			return evuntuDAO.updateEventServices(eServices);
		}
		catch(HibernateException he){
			throw new EvuntuManagementException(ERROR_WHILE_ACCESSING_DB+he);
		}	
		
	}
	
	@Override
	public EventServicesResponseVO getEventServicesById(long eventServiceId) throws EvuntuManagementException {
		LOGGER.info("Service::getEventServicesById-start");
		EvuntuManagementHelper helper=new EvuntuManagementHelper();
		List<?> list=evuntuDAO.getEventServicesById(eventServiceId);
		EventServicesResponseVO eventServicesVO=new EventServicesResponseVO();
		if(!list.isEmpty()){
			EventServices eventServices=(EventServices) list.get(0);
			List<FileDetails> filesList=evuntuDAO.getFileDetails(eventServiceId);
			eventServices.setFileDetails(filesList);
			eventServicesVO=helper.convertEventServicesDOtoVO(eventServices);
		}		
		return eventServicesVO;	
	}

	@Override
	public List<EventServicesResponseVO> searchEventServices(String eventName, String city) throws EvuntuManagementException {
		LOGGER.info("Service::searchEventServices-start");
		EvuntuManagementHelper helper=new EvuntuManagementHelper();
		List<EventServicesResponseVO> reponseList=new ArrayList<>();
		if(eventName==null){
			eventName="";
		}
		if(city==null){
			city="";
		}
		List<EventServices> list=evuntuDAO.searchServices(eventName, city);
		for(EventServices eventServices:list){
			List<FileDetails> filesList=evuntuDAO.getFileDetails(eventServices.getEventServiceId());
			eventServices.setFileDetails(filesList);
		}	
		for(EventServices eventServices:list){
			reponseList.add(helper.convertEventServicesDOtoVO(eventServices));
		}		
		return reponseList;

	}

	@Override
	public boolean deleteEventServices(long eventServiceId) throws EvuntuManagementException {
		LOGGER.info("Service::deleteEventServices-start");
		return evuntuDAO.removeEventServices(eventServiceId);	
		
	}

	@Override
	public String authenticate(String userName, String password) throws EvuntuManagementException {
		
		User user=evuntuDAO.getUserDetails(userName);
		Long authString=0L;
		if(user==null){
			throw new EvuntuManagementException("User does not exist");
		}
		String hashedPassword;
		try {
			hashedPassword = URLDecoder.decode(password, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("UnsupportedEncodingException occured::"+e);
			throw new EvuntuManagementException("UnsupportedEncodingException"+e);
		}
		//String decoded=PassHashHelper.getHash(URLDecoder.decode(password, "UTF-8"));
		if(!(hashedPassword.equals(password))){
			LOGGER.error("Invalid password");
			throw new EvuntuManagementException("Invalid password");
		}
		if(userName.equals(user.getUserName()) && password.equals(hashedPassword)){
			authString = System.currentTimeMillis();			
		}
		return authString.toString();
	}

	@Override
	public List<EventMasterVO> getAllEvents() throws EvuntuManagementException {
		LOGGER.info("Service::getAllEvents-start");
		List<EventFacilityDetailsVO> eventDOList=evuntuDAO.listEvents();
		EvuntuManagementHelper helper=new EvuntuManagementHelper();
		return helper.convertEventMasterDOToEventMasterVO(eventDOList);
	}

	@Override
	public boolean addEvent(EventMasterVO eventVO) throws EvuntuManagementException {
		LOGGER.info("Service::addEvent-start");
		try{
			EventMaster eventMaster = new EventMaster(eventVO.getEventId(),eventVO.getEventName());	
			for(FacilityVO facilityVO:eventVO.getFacility()){				
				EvuntuManagementHelper helper=new EvuntuManagementHelper();
			    evuntuDAO.addEvent(helper.convertEventMasterVOToDO(eventMaster,facilityVO));
			}	
		}
		catch(HibernateException he){
			throw new EvuntuManagementException(ERROR_WHILE_ACCESSING_DB+he);
		}
		return true;
	}

	@Override
	public boolean newCustomerEventRequest(CustomerEventRequestVO customerEventReqVO) throws EvuntuManagementException {
		LOGGER.info("Service::newCustomerEventRequest-start");
		/*EvuntuManagementHelper helper=new EvuntuManagementHelper();
		return evuntuDAO.addCompany(helper.convertCompanyVOToDO(companyVO));*/
		try{
			EvuntuManagementHelper helper=new EvuntuManagementHelper();
			Long id=evuntuDAO.addCustomerEventRequest(helper.convertCustomerEventRequestVOToDO(customerEventReqVO));
			
		}
		catch(HibernateException he){
			throw new EvuntuManagementException(ERROR_WHILE_ACCESSING_DB+he);
		}
		return true;
	}

	@Override
	public boolean updateCustomerEventRequest(CustomerEventRequestVO customerEventReqVO)
			throws EvuntuManagementException {
		LOGGER.info("Service::updateCustomerEventRequest-start");
		try{
			EvuntuManagementHelper helper=new EvuntuManagementHelper();
			
			return evuntuDAO.updateCustomerEventRequest(helper.convertCustomerEventRequestVOToDO(customerEventReqVO));
		}
		catch(HibernateException he){
			throw new EvuntuManagementException(ERROR_WHILE_ACCESSING_DB+he);
		}	
	}

	@Override
	public CustomerEventRequestVO getCustomerEventRequestDetails(long customerEventRequestId) throws EvuntuManagementException {
		LOGGER.info("Service::getCustomerEventRequest-start");
		List list=evuntuDAO.getCustomerEventRequestDetails(customerEventRequestId);
		if(list.isEmpty()){
			return new CustomerEventRequestVO();	
		}		
		return (CustomerEventRequestVO) list.get(0);
	}

	@Override
	public List<CustomerEventRequestVO> listCustomerEventRequestByUserId(long userId) throws EvuntuManagementException {
		LOGGER.info("Service::listCustomerEventRequest-start");
		List<CustomerEventRequestVO> customerEventRequestVOList=new ArrayList<>();
		EvuntuManagementHelper helper=new EvuntuManagementHelper();
		for (CustomerEventRequest custRqr:evuntuDAO.listCustomerEventRequestByUserId(userId)){			
			customerEventRequestVOList.add(helper.convertCustomerEventRequestDOToVO(custRqr));
		}
		return customerEventRequestVOList;
		
	}

	@Override
	public boolean removeCustomerEventRequest(long CustomerEventRequestId) throws EvuntuManagementException {
		LOGGER.info("Service::removeCustomerEventRequest-start");
		return evuntuDAO.removeCustomerEventRequest(CustomerEventRequestId);	
	}

	@Override
	public boolean addCompanyEventBidding(CompanyEventBiddingVO companyEventBiddingVO) throws EvuntuManagementException {
			LOGGER.info("Service::addCompanyEventBidding-start");
		try{
			CompanyEventBidding  companyEventBidding=new CompanyEventBidding();		
			BeanUtils.copyProperties(companyEventBiddingVO, companyEventBidding);
			evuntuDAO.addCompanyEventBidding(companyEventBidding);	
		}
		catch(HibernateException he){
			throw new EvuntuManagementException(ERROR_WHILE_ACCESSING_DB+he);
		}
		return true;
		
	}

	@Override
	public boolean updateCompanyEventBidding(CompanyEventBiddingVO companyEventBiddingVO)
			throws EvuntuManagementException {
		LOGGER.info("Service::updateCompanyEventBidding-start");
		try{
			CompanyEventBidding  companyEventBidding=new CompanyEventBidding();
			BeanUtils.copyProperties(companyEventBiddingVO, companyEventBidding);
			return evuntuDAO.updateCompanyEventBidding(companyEventBidding);
		}
		catch(HibernateException he){
			throw new EvuntuManagementException(ERROR_WHILE_ACCESSING_DB+he);
		}	
	}

	@Override
	public boolean removeCompanyEventBidding(long companyEventBiddingId) throws EvuntuManagementException {
		LOGGER.info("Service::removeCompanyEventBidding-start");
		return evuntuDAO.removeCompanyEventBidding(companyEventBiddingId);	
	}

	@Override
	public CompanyEventBiddingVO getCompanyEventBiddingDetails(long companyEventBiddingId) throws EvuntuManagementException {
		LOGGER.info("Service::getCompanyEventBiddingDetails-start");
		CompanyEventBiddingVO companyEventBiddingVO=new CompanyEventBiddingVO();
		List<?> list=evuntuDAO.getCompanyEventBiddingDetails(companyEventBiddingId);
		if(list.isEmpty()){			
			return companyEventBiddingVO;
		}
		BeanUtils.copyProperties(list.get(0), companyEventBiddingVO);
		return companyEventBiddingVO;	
	}

	@Override
	public List<CompanyEventBiddingVO> listCompanyEventBiddingByCompanyId(long companyEventBiddingId)
			throws EvuntuManagementException {
		LOGGER.info("Service::listCompanyEventBiddingByUserId-start");
		List<CompanyEventBiddingVO> companyEventBiddingVOList=new ArrayList<>();
		for (CompanyEventBidding cmpyEventBidding:evuntuDAO.listCompanyEventBiddingByCompanyId(companyEventBiddingId)){
			CompanyEventBiddingVO companyEventBiddingVO=new CompanyEventBiddingVO();
			BeanUtils.copyProperties(cmpyEventBidding, companyEventBiddingVO);
			companyEventBiddingVOList.add(companyEventBiddingVO);
		}
		return companyEventBiddingVOList;
	}

	

	
}
