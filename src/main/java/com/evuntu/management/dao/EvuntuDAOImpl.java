package com.evuntu.management.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.evuntu.management.exception.EvuntuManagementException;
import com.evuntu.management.model.Company;
import com.evuntu.management.model.Customer;
import com.evuntu.management.model.EventServices;
import com.evuntu.management.model.FileDetails;
import com.evuntu.management.model.User;
import com.evuntu.management.vo.EventServicesVO;

@Repository
public class EvuntuDAOImpl implements EvuntuDAO {
	
	private static final Logger LOGGER = Logger.getLogger(EvuntuDAOImpl.class);
		
	@Autowired
	private SessionFactory sessionFactory;
	
	Session session = null;
	Transaction tx = null;


	@Override
	public Long addUser(User u) throws EvuntuManagementException {
		LOGGER.info("DAO::addUser-start");
		Long id;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			id=(Long) session.save(u);
			tx.commit();
			LOGGER.info("USer added successfully");
		}catch(HibernateException e){
			throw new EvuntuManagementException("Error while accessing db"+e);
		}finally{
			session.close();
		}
		return id;
	}
	
	@Override
	public boolean updateUser(User u) throws EvuntuManagementException {
		LOGGER.info("DAO::updateUser-start");
		try{
			session = sessionFactory.openSession();
			/*Customer o =(Customer) session.load(Customer.class, c.getId());
			tx = session.getTransaction();
			session.beginTransaction();
			session.update(o);
			tx.commit();*/		
			tx = session.beginTransaction();
			session.update(u);
			tx.commit();
		}catch(HibernateException e){
			throw new EvuntuManagementException("Error while accessing db"+e);
		}finally{
			session.close();
		}
		LOGGER.info("Customer details updated successfully for User::"+u.getId());
		return true;		
	}
	
	@Override
	public boolean removeUser(Long id) throws EvuntuManagementException {
		LOGGER.info("DAO::removeUser-start");
		try{
			session = sessionFactory.openSession();
			Object o = session.load(User.class, id);
			tx = session.getTransaction();
			session.beginTransaction();
			session.delete(o);
			tx.commit();
			LOGGER.info("User removed successfully"+id);
		}catch(HibernateException e){
			throw new EvuntuManagementException("Error while accessing db"+e);
		}catch(Exception e){
			throw new EvuntuManagementException("Internal server error"+e);
		}
		finally{
			session.close();
		}
		return false;
	}
	
	@Override
	public User getUserDetails(String userName) throws EvuntuManagementException {
		LOGGER.info("UserId in getUserDetails :::" + userName);
		Session session = null;
		User userDetails = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("userName",userName));
			userDetails = (User) criteria.uniqueResult();            

		} catch (HibernateException he) {
			LOGGER.error(he);
			throw new EvuntuManagementException(he.getMessage());
		} catch (RuntimeException exception) {
			LOGGER.error(exception);
			throw new EvuntuManagementException(exception.getMessage());
		} finally {
			closeSession(session);
		}
		return userDetails;
	}
	
	
	@Override
	public Long addCustomer(Customer c) throws EvuntuManagementException {
		LOGGER.info("DAO::addCustomer-start");
		Long id;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			id=(Long)session.save(c);
			tx.commit();
			LOGGER.info("Customer added successfully");
		}catch(HibernateException e){
			throw new EvuntuManagementException("Error while accessing db"+e);
		}finally{
			session.close();
		}
		return id;
	}

	@Override
	public boolean updateCustomer(Customer c) throws EvuntuManagementException {
		LOGGER.info("DAO::updateCustomer-start");
		try{
			session = sessionFactory.openSession();
			/*Customer o =(Customer) session.load(Customer.class, c.getId());
			tx = session.getTransaction();
			session.beginTransaction();
			session.update(o);
			tx.commit();*/		
			tx = session.beginTransaction();
			session.update(c);
			tx.commit();
		}catch(HibernateException e){
			throw new EvuntuManagementException("Error while accessing db"+e);
		}finally{
			session.close();
		}
		LOGGER.info("Customer details updated successfully for customer::"+c.getId());
		return true;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> listCustomer()throws EvuntuManagementException  {
		LOGGER.info("DAO::listCustomer-start");
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			List<Customer> custList = session.createCriteria(Customer.class)
					.list();
			tx.commit();
			LOGGER.info("All the customer details fetched successfully");
			return custList;

		}catch(HibernateException e){
			throw new EvuntuManagementException("Error while accessing db"+e);
		}finally{
			session.close();
		}
	}

	@Override
	public List getCustomerById(Long id) throws EvuntuManagementException  {
		LOGGER.info("DAO::getCustomerById-start");
		try{
			session = sessionFactory.openSession();
			Criteria cr = session.createCriteria(Customer.class);
			cr.add(Restrictions.eq("id", id));
			LOGGER.info("Customer details loaded for customer="+id);
			return  cr.list();
		}catch(HibernateException e){
			throw new EvuntuManagementException("Error while accessing db"+e);
		}catch(Exception e){
			throw new EvuntuManagementException("Internal server error"+e);
		}
		finally{
			session.close();
		}
		
	}

	@Override
	public boolean removeCustomer(Long id) throws EvuntuManagementException {
		LOGGER.info("DAO::removeCustomer-start");
		try{
			session = sessionFactory.openSession();
			Object o = session.load(Customer.class, id);
			tx = session.getTransaction();
			session.beginTransaction();
			session.delete(o);
			tx.commit();
			LOGGER.info("Customer removed successfully"+id);
		}catch(HibernateException e){
			throw new EvuntuManagementException("Error while accessing db"+e);
		}catch(Exception e){
			throw new EvuntuManagementException("Internal server error"+e);
		}
		finally{
			session.close();
		}
		return false;
	}
	@Override
	public boolean addCompany(Company c) throws EvuntuManagementException {
		LOGGER.info("DAO::addCompany-start");
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(c);
			tx.commit();
			LOGGER.info("Company added successfully");
		}catch(HibernateException e){
			throw new EvuntuManagementException("Error while accessing db"+e);
		}finally{
			session.close();
		}
		return true;
	}
	@Override
	public boolean updateCompany(Company c) throws EvuntuManagementException {
		LOGGER.info("DAO::updateCompany-start");
		try{
			session = sessionFactory.openSession();
			/*Customer o =(Customer) session.load(Customer.class, c.getId());
			tx = session.getTransaction();
			session.beginTransaction();
			session.update(o);
			tx.commit();*/		
			tx = session.beginTransaction();
			session.update(c);
			tx.commit();
		}catch(HibernateException e){
			throw new EvuntuManagementException("Error while accessing db"+e);
		}finally{
			session.close();
		}
		LOGGER.info("Company details updated successfully for company::"+c.getId());
		return true;		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Company> listCompany()throws EvuntuManagementException  {
		LOGGER.info("DAO::listCompanyr-start");
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			List<Company> cmpnyList = session.createCriteria(Company.class)
					.list();
			tx.commit();
			LOGGER.info("All the Company details fetched successfully");
			return cmpnyList;

		}catch(HibernateException e){
			throw new EvuntuManagementException("Error while accessing db"+e);
		}finally{
			session.close();
		}
	}
	@Override
	public List getCompanyById(Long id) throws EvuntuManagementException  {
		LOGGER.info("DAO::getCompanyById-start");
		try{
			session = sessionFactory.openSession();
			Criteria cr = session.createCriteria(Company.class);
			cr.add(Restrictions.eq("id", id));
			LOGGER.info("Company details loaded for accountid="+id);
			return  cr.list();
		}catch(HibernateException e){
			throw new EvuntuManagementException("Error while accessing db"+e);
		}catch(Exception e){
			throw new EvuntuManagementException("Internal server error"+e);
		}
		finally{
			session.close();
		}
		
	}

	@Override
	public boolean removeCompany(Long id) throws EvuntuManagementException {
		LOGGER.info("DAO::removeCompany-start");
		try{
			session = sessionFactory.openSession();
			Object o = session.load(Customer.class, id);
			tx = session.getTransaction();
			session.beginTransaction();
			session.delete(o);
			tx.commit();
			LOGGER.info("Company removed successfully"+id);
		}catch(HibernateException e){
			throw new EvuntuManagementException("Error while accessing db"+e);
		}catch(Exception e){
			throw new EvuntuManagementException("Internal server error"+e);
		}
		finally{
			session.close();
		}
		return false;
	}

	@Override
	public List<FileDetails> fileUpload(List<FileDetails> fileDetails) throws EvuntuManagementException {
		LOGGER.info("DAO::fileUpload-start");
		session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Long fileId = null;
        List<FileDetails> fileIdList = new ArrayList<>();
        try {
            for (FileDetails fileDetailObj : fileDetails) {
                session.saveOrUpdate(fileDetailObj);
                fileIdList.add(fileDetailObj);
            }
            transaction.commit();
            session.flush();
            session.close();
          } catch (RuntimeException e) {
            try {
                transaction.rollback();
                fileId = -1L;
                FileDetails fileDetailObj =new FileDetails();
                fileDetailObj.setFileId(fileId);
                fileIdList.add(fileDetailObj);
                LOGGER.error("Transaction rolled back while saving file details", e);
            } catch (HibernateException he) {
            	throw new EvuntuManagementException("Error while accessing db"+he);
            }
            throw new EvuntuManagementException("Internal server error"+e);
        } 
        return fileIdList;
	 }

	@Override
	public Long addEventServices(EventServices eServices) throws EvuntuManagementException {
		LOGGER.info("DAO::addEventServices-start");
		Long id;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			id=(Long) session.save(eServices);
			tx.commit();
			LOGGER.info("Event Services added successfully");
		}catch(HibernateException e){
			throw new EvuntuManagementException("Error while accessing db"+e);
		}finally{
			session.close();
		}
		return id;
	}
	
	@Override
	public boolean updateEventServices(EventServices eServices) throws EvuntuManagementException {
		LOGGER.info("DAO::updateEventServices-start");
		try{
			session = sessionFactory.openSession();
			/*Customer o =(Customer) session.load(Customer.class, c.getId());
			tx = session.getTransaction();
			session.beginTransaction();
			session.update(o);
			tx.commit();*/		
			tx = session.beginTransaction();
			session.update(eServices);
			tx.commit();
		}catch(HibernateException e){
			throw new EvuntuManagementException("Error while accessing db"+e);
		}finally{
			session.close();
		}
		LOGGER.info("Event Service details updated successfully for User::"+eServices.getId());
		return true;		
	}

	@Override
	public List<EventServicesVO> searchServices(String eventName,String city)throws EvuntuManagementException  {
		LOGGER.info("DAO::listCompanyr-start");
		try{
			session = sessionFactory.openSession();
			Criteria servicesList = session.createCriteria(EventServices.class);
			if(eventName!=""){
				servicesList.add(Restrictions.like("name", eventName));
			}
			if(city!=""){
				servicesList.add(Restrictions.eq("city", city));
			}
			LOGGER.info("All the Company details fetched successfully");
			return servicesList.list();

		}catch(HibernateException e){
			throw new EvuntuManagementException("Error while accessing db"+e);
		}finally{
			session.close();
		}
	}
	
	@Override
	public List getEventServicesById(Long eventServiceId) throws EvuntuManagementException  {
		LOGGER.info("DAO::getEventServices-start");
		try{
			session = sessionFactory.openSession();
			Criteria cr = session.createCriteria(EventServices.class);
			cr.add(Restrictions.eq("id", eventServiceId));
			LOGGER.info("Event Services details loaded for accountid="+eventServiceId);
			return  cr.list();
		}catch(HibernateException e){
			throw new EvuntuManagementException("Error while accessing db"+e);
		}catch(Exception e){
			throw new EvuntuManagementException("Internal server error"+e);
		}
		finally{
			session.close();
		}
		
	}

	@Override
	public boolean removeEventServices(Long eventServiceId) throws EvuntuManagementException {
		LOGGER.info("DAO::removeEventServices-start");
		try{
			session = sessionFactory.openSession();
			Object o = session.load(EventServices.class, eventServiceId);
			tx = session.getTransaction();
			session.beginTransaction();
			session.delete(o);
			tx.commit();
			LOGGER.info("Event Services removed successfully"+eventServiceId);
		}catch(HibernateException e){
			throw new EvuntuManagementException("Error while accessing db"+e);
		}catch(Exception e){
			throw new EvuntuManagementException("Internal server error"+e);
		}
		finally{
			session.close();
		}
		return false;
	}
	private void closeSession(Session session){
		if(isSessionAvailable(session)){
			session.close();
		}
	}
	private boolean isSessionAvailable(Session session){
		return session != null ? true : false;
	}
	
	
	
}
