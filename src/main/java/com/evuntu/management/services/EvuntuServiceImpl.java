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
import com.evuntu.management.model.Customer;
import com.evuntu.management.model.EventServices;
import com.evuntu.management.model.FileDetails;
import com.evuntu.management.model.User;
import com.evuntu.management.util.FileUploadUtil;
import com.evuntu.management.util.PassHashHelper;
import com.evuntu.management.vo.CompanyVO;
import com.evuntu.management.vo.CustomerVO;
import com.evuntu.management.vo.EventServicesVO;



@Service
public class EvuntuServiceImpl implements EvuntuService {
	@Autowired
	private EvuntuDAO evuntuDAO;
	
	private static final Logger LOGGER = Logger.getLogger(EvuntuManagementHelper.class); 
		
	@Override
	public boolean addCustomer(CustomerVO customerVO) throws EvuntuManagementException {
		LOGGER.info("Service::addCustomer-start");
		try{
			EvuntuManagementHelper helper=new EvuntuManagementHelper();
			Long id=evuntuDAO.addUser(helper.convertCustomerVOToUserDO(customerVO));
			customerVO.setUserId(id);
			evuntuDAO.addCustomer(helper.convertCustomerVOToDO(customerVO));
		}
		catch(HibernateException he){
			throw new EvuntuManagementException("Error while accessing DB"+he);
		}
		return true;	
	}

	@Override
	public boolean updateCustomer(CustomerVO customerVO) throws EvuntuManagementException{
		LOGGER.info("Service::updateCustomer-start");
		try{
			EvuntuManagementHelper helper=new EvuntuManagementHelper();
			return evuntuDAO.updateCustomer(helper.convertCustomerVOToDO(customerVO));
		}
		catch(HibernateException he){
			throw new EvuntuManagementException("Error while accessing DB"+he);
		}		
	}

	@Override
	public List<Customer> listCustomer() throws EvuntuManagementException{
		LOGGER.info("Service::listCustomer-start");
		List<Customer> t=evuntuDAO.listCustomer();
		return t;
	}

	@Override
	public Customer getCustomerById(Long id) throws EvuntuManagementException { 
		LOGGER.info("Service::getCustomerById-start");
		List list=evuntuDAO.getCustomerById(id);
		if(list.size()>0){
			return (Customer) list.get(0);
		}
		return new Customer();		
	}

	@Override
	public boolean removeCustomer(Long id)throws EvuntuManagementException {
		LOGGER.info("Service::removeCustomer-start");
		return evuntuDAO.removeCustomer(id);		
	}
	
	/*@Override
	public Customer authenticate(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public boolean addCompany(CompanyVO companyVO) throws EvuntuManagementException {
		LOGGER.info("Service::addCompany-start");
		/*EvuntuManagementHelper helper=new EvuntuManagementHelper();
		return evuntuDAO.addCompany(helper.convertCompanyVOToDO(companyVO));*/
		try{
			EvuntuManagementHelper helper=new EvuntuManagementHelper();
			Long id=evuntuDAO.addUser(helper.convertCompanyVOToUserDO(companyVO));
			companyVO.setUserId(id);
			evuntuDAO.addCompany(helper.convertCompanyVOToDO(companyVO));
		}
		catch(HibernateException he){
			throw new EvuntuManagementException("Error while accessing DB"+he);
		}
		return true;
	}

	@Override
	public boolean updateCompany(CompanyVO companyVO) throws EvuntuManagementException {
		LOGGER.info("Service::updateCompany-start");
		try{
			EvuntuManagementHelper helper=new EvuntuManagementHelper();
			return evuntuDAO.updateCompany(helper.convertCompanyVOToDO(companyVO));
		}
		catch(HibernateException he){
			throw new EvuntuManagementException("Error while accessing DB"+he);
		}	
	}

	@Override
	public Company getCompanyById(long id) throws EvuntuManagementException {
		LOGGER.info("Service::getCompanyById-start");
		List list=evuntuDAO.getCompanyById(id);
		if(list.size()>0){
			return (Company) list.get(0);
		}
		return new Company();	
	}

	@Override
	public List<Company> listCompany() throws EvuntuManagementException {
		LOGGER.info("Service::listCompany-start");
		List<Company> t=evuntuDAO.listCompany();
		return t;
	}

	@Override
	public boolean removeCompany(long id) throws EvuntuManagementException {
		LOGGER.info("Service::removeCompany-start");
		return evuntuDAO.removeCompany(id);	
		
	}
	
  	@Override
	public boolean addEventServices(EventServicesVO eventServicesVO,List<MultipartFile> fileList) throws EvuntuManagementException {
		LOGGER.info("Service::addEventServices-start");
		List<FileDetails> fileDetList= new ArrayList<>();
		EventServices eServices=new EventServices();		
		BeanUtils.copyProperties(eventServicesVO, eServices);
		Long eventId=evuntuDAO.addEventServices(eServices);
		FileUploadUtil fileUtil=new FileUploadUtil();
		for(MultipartFile file:fileList){
			if (file != null && (!file.isEmpty())) {
			    fileUtil.upload(file);
			    FileDetails fileDetails =fileUtil.prepareObjectToStore(file,eventId);
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
			throw new EvuntuManagementException("Error while accessing DB"+he);
		}	
		
	}
	
	@Override
	public EventServicesVO getEventServicesById(long eventServiceId) throws EvuntuManagementException {
		LOGGER.info("Service::getEventServicesById-start");
		List list=evuntuDAO.getEventServicesById(eventServiceId);
		if(list.size()>0){
			return (EventServicesVO) list.get(0);
		}
		return new EventServicesVO();	
	}

	@Override
	public List<EventServicesVO> searchEventServices(String eventName, String city) throws EvuntuManagementException {
		LOGGER.info("Service::searchEventServices-start");
		List<EventServicesVO> eventServicesVO=evuntuDAO.searchServices(eventName, city);
		return eventServicesVO;
	}

	@Override
	public boolean deleteEventServices(long eventServiceId) throws EvuntuManagementException {
		LOGGER.info("Service::deleteEventServices-start");
		return evuntuDAO.removeEventServices(eventServiceId);	
		
	}

	@Override
	public String authenticate(String userName, String password) throws EvuntuManagementException, UnsupportedEncodingException {
		
		User user=evuntuDAO.getUserDetails(userName);
		Long authString=0L;
		if(user==null){
			throw new EvuntuManagementException("User does not exist");
		}
		String hashedPassword=URLDecoder.decode(password, "UTF-8");
		//String decoded=PassHashHelper.getHash(URLDecoder.decode(password, "UTF-8"));
		if(!(hashedPassword.equals(password))){
			throw new EvuntuManagementException("Invalid password");
		}
		if(userName.equals(user.getUserName()) && password.equals(hashedPassword)){
			authString = System.currentTimeMillis();			
		}
		return authString.toString();
	}

	

	
}
