package com.evuntu.management.vo;

/**
 * UserVo 
 * @author umaa maheswari
 *
 */
public class AuthenticateResponseVO {
	
	private Long authToken;
	
	private String userType;
	
	private CompanyResponseVO companyDetails;
	
	private CustomerResponseVO  customerDetails;
	
	public Long getAuthToken() {
		return authToken;
	}

	public void setAuthToken(Long authToken) {
		this.authToken = authToken;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * @return the companyDetails
	 */
	public CompanyResponseVO getCompanyDetails() {
		return companyDetails;
	}

	/**
	 * @param companyDetails the companyDetails to set
	 */
	public void setCompanyDetails(CompanyResponseVO companyDetails) {
		this.companyDetails = companyDetails;
	}

	/**
	 * @return the customerDetails
	 */
	public CustomerResponseVO getCustomerDetails() {
		return customerDetails;
	}

	/**
	 * @param customerDetails the customerDetails to set
	 */
	public void setCustomerDetails(CustomerResponseVO customerDetails) {
		this.customerDetails = customerDetails;
	}



}
