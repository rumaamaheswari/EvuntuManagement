package com.evuntu.management.vo;

/**
 * UserVo 
 * @author umaa maheswari
 *
 */
public class AuthenticateResponseVO {
	
	private Long authToken;
	
	private String userType;
	
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

}
