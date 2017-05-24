package com.evuntu.management.services;

import java.util.List;

import com.evuntu.management.exception.EvuntuManagementException;
import com.evuntu.management.vo.CompanyEventBiddingVO;
import com.evuntu.management.vo.CompanyRequestVO;
import com.evuntu.management.vo.CompanyResponseVO;
import com.evuntu.management.vo.CustomerEventRequestVO;
import com.evuntu.management.vo.CustomerEventResponseVO;
import com.evuntu.management.vo.CustomerRequestVO;
import com.evuntu.management.vo.CustomerResponseVO;
import com.evuntu.management.vo.EventMasterVO;
import com.evuntu.management.vo.EventServicesResponseVO;
import com.evuntu.management.vo.EventServicesVO;


public interface EvuntuService {

	public boolean addCustomer(CustomerRequestVO c) throws EvuntuManagementException;
	public boolean updateCustomer(CustomerRequestVO c) throws EvuntuManagementException;
	public List<CustomerResponseVO> listCustomer()throws EvuntuManagementException;
	public CustomerResponseVO getCustomerById(Long id)throws EvuntuManagementException;
	public boolean removeCustomer(Long id)throws EvuntuManagementException;
	
	public boolean addCompany(CompanyRequestVO company) throws EvuntuManagementException;
	public boolean updateCompany(CompanyRequestVO company)throws EvuntuManagementException;
	public List<CompanyResponseVO> listCompany()throws EvuntuManagementException;
	public CompanyResponseVO getCompanyById(long id)throws EvuntuManagementException;	
	public boolean removeCompany(long id)throws EvuntuManagementException;
	
	public boolean addEventServices(EventServicesVO eventServices)throws EvuntuManagementException;
	public boolean updateEventServices(EventServicesVO eventServices)throws EvuntuManagementException;
	public List<EventServicesResponseVO> searchEventServices(String name, String city)throws EvuntuManagementException;
	public EventServicesResponseVO getEventServicesById(long id)throws EvuntuManagementException;
	public boolean deleteEventServices(long id)throws EvuntuManagementException;
	
	public String authenticate(String userName, String password)throws EvuntuManagementException;
	
	public List<EventMasterVO> getAllEvents()throws EvuntuManagementException;
	public boolean addEvent(EventMasterVO event)throws EvuntuManagementException;
	
	
	public boolean newCustomerEventRequest(CustomerEventRequestVO customerEventReqVO) throws EvuntuManagementException;
	public boolean updateCustomerEventRequest(CustomerEventRequestVO customerEventReqVO)throws EvuntuManagementException;
	public CustomerEventResponseVO getCustomerEventRequestDetails(long CustomerEventRequestId)throws EvuntuManagementException;
	public List<CustomerEventResponseVO> listCustomerEventRequestByUserId(long userId)throws EvuntuManagementException;
	public boolean removeCustomerEventRequest(long CustomerEventRequestId)throws EvuntuManagementException;
	
	public boolean addCompanyEventBidding(CompanyEventBiddingVO companyEventBiddingVO) throws EvuntuManagementException;
	public boolean updateCompanyEventBidding(CompanyEventBiddingVO companyEventBiddingVO) throws EvuntuManagementException;
	public boolean removeCompanyEventBidding(long companyEventBiddingId) throws EvuntuManagementException;
	public CompanyEventBiddingVO getCompanyEventBiddingDetails(long companyEventBiddingId) throws EvuntuManagementException;
	public List<CompanyEventBiddingVO> listCompanyEventBiddingByCompanyId(long companyEventBiddingId) throws EvuntuManagementException;
	
}
