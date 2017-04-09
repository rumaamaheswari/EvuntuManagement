package com.evuntu.management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean
 * @author umaa maheswari
 *
 */
@Entity
@Table(name="CUSTOMER")
public class Customer {

	@Id
	@Column(name="CUSTOMER_ID")
	@GeneratedValue
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String mobileNumber;
	
	private String emailAddress;
	
	private String purpose;
	
	@Column(name="ALLOW_TO_CONTACT")
	private char allowToContact;
	
	/*@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private User user;*/
	
	@Column(name="USER_ID")
	private Long userId;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the purpose
	 */
	public String getPurpose() {
		return purpose;
	}

	/**
	 * @param purpose the purpose to set
	 */
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}


	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the allowToContact
	 */
	public char getAllowToContact() {
		return allowToContact;
	}

	/**
	 * @param allowToContact the allowToContact to set
	 */
	public void setAllowToContact(char allowToContact) {
		this.allowToContact = allowToContact;
	}

	/**
	 * @return the users
	 *//*
	public User getUsers() {
		return user;
	}

	*//**
	 * @param users the users to set
	 *//*
	public void setUsers(User users) {
		this.user = users;
	}*/

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	

	
}
