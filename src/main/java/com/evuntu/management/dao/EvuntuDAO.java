package com.evuntu.management.dao;

import java.util.List;

import com.evuntu.management.exception.EvuntuManagementException;
import com.evuntu.management.model.Company;
import com.evuntu.management.model.Customer;
import com.evuntu.management.model.EventServices;
import com.evuntu.management.model.FileDetails;
import com.evuntu.management.model.User;
import com.evuntu.management.vo.EventServicesVO;

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
	
	public Long addUser(User user) throws EvuntuManagementException;
	public boolean updateUser(User user) throws EvuntuManagementException;
	boolean removeUser(Long id) throws EvuntuManagementException;
	
	public List<FileDetails> fileUpload(List<FileDetails> filedetails)throws EvuntuManagementException;
	
	public Long addEventServices(EventServices eServices)throws EvuntuManagementException;
	public boolean updateEventServices(EventServices eServices) throws EvuntuManagementException;
	public List<EventServicesVO> searchServices(String eventName,String city)throws EvuntuManagementException ;
	public List getEventServicesById(Long eventServiceId)throws EvuntuManagementException ;
	public boolean removeEventServices(Long eventServiceId) throws EvuntuManagementException;
}
