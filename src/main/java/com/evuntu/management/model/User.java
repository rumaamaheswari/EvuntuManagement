package com.evuntu.management.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity bean 
 * @author umaa maheswari
 */
@Entity
@Table(name="USER")
public class User implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -66208467084103818L;

	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="USERNAME")
	private String userName;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="USERTYPE")
	private String userType;
	
	@OneToMany(mappedBy = "user")
	private Set<Company> company = new HashSet<Company>();
	
	@OneToMany(mappedBy = "user")
	private Set<Customer> Customer = new HashSet<Customer>();
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	/**
	 * @return the company
	 */
	public Set<Company> getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(Set<Company> company) {
		this.company = company;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
