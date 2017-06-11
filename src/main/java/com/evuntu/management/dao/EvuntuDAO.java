package com.evuntu.management.dao;

import java.util.List;

import com.evuntu.management.exception.EvuntuManagementException;
import com.evuntu.management.model.Company;
import com.evuntu.management.model.CompanyEventBidding;
import com.evuntu.management.model.Customer;
import com.evuntu.management.model.CustomerEventRequest;
import com.evuntu.management.model.EventFacility;
import com.evuntu.management.model.EventServices;
import com.evuntu.management.model.FileDetails;
import com.evuntu.management.model.User;
import com.evuntu.management.vo.CustomerEventResponseVO;
import com.evuntu.management.vo.EventFacilityDetailsVO;

public interface EvuntuDAO {

	public Long addCustomer(Customer customer) throws EvuntuManagementException;
	public boolean updateCustomer(Customer customer) throws EvuntuManagementException;
	public List<Customer> listCustomer() throws EvuntuManagementException;
	public List getCustomerById(Long id) throws EvuntuManagementException;
	public boolean removeCustomer(Long id) throws EvuntuManagementException;
	
	public boolean addCompany(Company company)throws EvuntuManagementException;
	public boolean updateCompany(Company company)throws EvuntuManagementException;
	public List<Company> listCompany()throws EvuntuManagementException ;
	public List getCompanyById(Long id)throws EvuntuManagementException ;
	public boolean removeCompany(Long id) throws EvuntuManagementException;
	
	public Long addUser(User user) throws EvuntuManagementException; //not required
	public boolean updateUser(User user) throws EvuntuManagementException; //can be used for password update
	boolean removeUser(Long id) throws EvuntuManagementException;
	
	//public List<FileDetails> fileUpload(List<FileDetails> filedetails)throws EvuntuManagementException;
	
	public boolean addEventServices(EventServices eServices)throws EvuntuManagementException;
	public boolean updateEventServices(EventServices eServices) throws EvuntuManagementException;
	public List<EventServices> searchServices(String eventName,String city)throws EvuntuManagementException ;
	public List<FileDetails> getFileDetails(Long eventServicesId) throws EvuntuManagementException;
	public List getEventServicesById(Long eventServiceId)throws EvuntuManagementException ;
	public boolean removeEventServices(Long eventServiceId) throws EvuntuManagementException;
	public User getUserDetails(String username) throws EvuntuManagementException;
	
	public List<EventFacilityDetailsVO> listEvents()throws EvuntuManagementException; //for listing event and it's facilities
	public void addEvent(EventFacility eventFacility)throws EvuntuManagementException;//For adding events and it's related facilities
	
	public Long addCustomerEventRequest(CustomerEventRequest customerEventRequest) throws EvuntuManagementException;
	public boolean updateCustomerEventRequest(CustomerEventRequest customerEventRequest)throws EvuntuManagementException;
	public List getCustomerEventRequestDetails(long customerEventRequestId)throws EvuntuManagementException;
	public List<CustomerEventRequest> listCustomerEventRequestByUserId(long userId)throws EvuntuManagementException;
	public boolean removeCustomerEventRequest(long customerEventRequestId)throws EvuntuManagementException;
	
	public Long addCompanyEventBidding(CompanyEventBidding companyEventBidding) throws EvuntuManagementException;
	public boolean updateCompanyEventBidding(CompanyEventBidding companyEventBidding) throws EvuntuManagementException;
	public boolean removeCompanyEventBidding(long companyEventBiddingId) throws EvuntuManagementException;
	public List getCompanyEventBiddingDetails(long companyEventBiddingId) throws EvuntuManagementException;
	List<CompanyEventBidding> listCompanyEventBiddingByCompanyId(long companyId) throws EvuntuManagementException;
	
}
