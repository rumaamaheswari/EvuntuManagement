package com.evuntu.management.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.evuntu.management.exception.EvuntuManagementException;
import com.evuntu.management.model.Company;
import com.evuntu.management.model.Customer;
import com.evuntu.management.model.FileDetails;
import com.evuntu.management.vo.CompanyVO;
import com.evuntu.management.vo.CustomerVO;
import com.evuntu.management.vo.EventServicesVO;


public interface EvuntuService {

	public boolean addCustomer(CustomerVO c) throws EvuntuManagementException;
	public boolean updateCustomer(CustomerVO c) throws EvuntuManagementException;
	public List<Customer> listCustomer()throws EvuntuManagementException;
	public Customer getCustomerById(Long id)throws EvuntuManagementException;
	public boolean removeCustomer(Long id)throws EvuntuManagementException;
	//public Customer authenticate(String userName, String password);
	
	public boolean addCompany(CompanyVO company) throws EvuntuManagementException;
	public boolean updateCompany(CompanyVO company)throws EvuntuManagementException;
	public List<Company> listCompany()throws EvuntuManagementException;
	public Company getCompanyById(long id)throws EvuntuManagementException;	
	public boolean removeCompany(long id)throws EvuntuManagementException;
	
	public boolean addEventServices(EventServicesVO eventServices,List<MultipartFile> fileList)throws EvuntuManagementException;
	public boolean updateEventServices(EventServicesVO eventServices)throws EvuntuManagementException;
	public List<EventServicesVO> searchEventServices(String name, String city)throws EvuntuManagementException;
	public EventServicesVO getEventServicesById(long id)throws EvuntuManagementException;
	public boolean deleteEventServices(long id)throws EvuntuManagementException;
	
}
