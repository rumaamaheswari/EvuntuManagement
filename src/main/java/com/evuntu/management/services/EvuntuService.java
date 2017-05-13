package com.evuntu.management.services;

import java.util.List;

import com.evuntu.management.exception.EvuntuManagementException;
import com.evuntu.management.model.Company;
import com.evuntu.management.model.CompanyEventBidding;
import com.evuntu.management.model.Customer;
import com.evuntu.management.vo.CompanyEventBiddingVO;
import com.evuntu.management.vo.CompanyVO;
import com.evuntu.management.vo.CustomerEventRequestVO;
import com.evuntu.management.vo.CustomerVO;
import com.evuntu.management.vo.EventMasterVO;
import com.evuntu.management.vo.EventServicesVO;


public interface EvuntuService {

	public boolean addCustomer(CustomerVO c) throws EvuntuManagementException;
	public boolean updateCustomer(CustomerVO c) throws EvuntuManagementException;
	public List<CustomerVO> listCustomer()throws EvuntuManagementException;
	public CustomerVO getCustomerById(Long id)throws EvuntuManagementException;
	public boolean removeCustomer(Long id)throws EvuntuManagementException;
	//public Customer authenticate(String userName, String password);
	
	public boolean addCompany(CompanyVO company) throws EvuntuManagementException;
	public boolean updateCompany(CompanyVO company)throws EvuntuManagementException;
	public List<CompanyVO> listCompany()throws EvuntuManagementException;
	public CompanyVO getCompanyById(long id)throws EvuntuManagementException;	
	public boolean removeCompany(long id)throws EvuntuManagementException;
	
	public boolean addEventServices(EventServicesVO eventServices)throws EvuntuManagementException;
	public boolean updateEventServices(EventServicesVO eventServices)throws EvuntuManagementException;
	public List<EventServicesVO> searchEventServices(String name, String city)throws EvuntuManagementException;
	public EventServicesVO getEventServicesById(long id)throws EvuntuManagementException;
	public boolean deleteEventServices(long id)throws EvuntuManagementException;
	
	public String authenticate(String userName, String password)throws EvuntuManagementException;
	
	public List<EventMasterVO> getAllEvents()throws EvuntuManagementException;
	public boolean addEvent(EventMasterVO event)throws EvuntuManagementException;
	
	
	public boolean newCustomerEventRequest(CustomerEventRequestVO customerEventReqVO) throws EvuntuManagementException;
	public boolean updateCustomerEventRequest(CustomerEventRequestVO customerEventReqVO)throws EvuntuManagementException;
	public CustomerEventRequestVO getCustomerEventRequestDetails(long CustomerEventRequestId)throws EvuntuManagementException;
	public List<CustomerEventRequestVO> listCustomerEventRequestByUserId(long userId)throws EvuntuManagementException;
	public boolean removeCustomerEventRequest(long CustomerEventRequestId)throws EvuntuManagementException;
	
	public boolean addCompanyEventBidding(CompanyEventBiddingVO companyEventBiddingVO) throws EvuntuManagementException;
	public boolean updateCompanyEventBidding(CompanyEventBiddingVO companyEventBiddingVO) throws EvuntuManagementException;
	public boolean removeCompanyEventBidding(long companyEventBiddingId) throws EvuntuManagementException;
	public CompanyEventBiddingVO getCompanyEventBiddingDetails(long companyEventBiddingId) throws EvuntuManagementException;
	public List<CompanyEventBiddingVO> listCompanyEventBiddingByCompanyId(long companyEventBiddingId) throws EvuntuManagementException;
	
}
