/**
 * 
 */
package com.evuntu.management.helper;

import org.apache.log4j.Logger;

import com.evuntu.management.exception.EvuntuManagementException;
import com.evuntu.management.model.Company;
import com.evuntu.management.model.Customer;
import com.evuntu.management.model.User;
import com.evuntu.management.util.PassHashHelper;
import com.evuntu.management.vo.CompanyVO;
import com.evuntu.management.vo.CustomerVO;


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
		
		public CustomerVO convertCustomerDOToVO(Customer customer) throws EvuntuManagementException {
			LOGGER.info("Helper::convertCustomerDOToVO-start");
			CustomerVO customerVO = new CustomerVO();
			try{
				customer.setId(customer.getId());
				customer.setFirstName(customer.getFirstName());
				customer.setLastName(customer.getLastName());
				customer.setMobileNumber(customer.getMobileNumber());
				customer.setAllowToContact(customer.getAllowToContact());
				customer.setMobileNumber(customer.getMobileNumber());
				customer.setEmailAddress(customer.getEmailAddress());
			}
			catch(Exception e){ 
				throw new EvuntuManagementException("Excption while converting VO to DO"+e);
			}
			LOGGER.info("Helper::convertCustomerDOToVO-end");
			return customerVO;
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
		public CompanyVO convertCompanyDOToVO(Company company) throws EvuntuManagementException {
			LOGGER.info("Helper::convertCustomerDOToVO-start");
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
			}
			catch(Exception e){ 
				throw new EvuntuManagementException("Excption while converting VO to DO"+e);
			}
			LOGGER.info("Helper::convertCompanyDOToVO-end");
			return companyVO;
		}

}
	
