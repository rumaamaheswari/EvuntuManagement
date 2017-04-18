package com.evuntu.management.util;

import org.springframework.util.DigestUtils;

//import org.apache.commons.codec.digest.DigestUtils;

public class PassHashHelper {
	public static String getHash(String pass){
		return DigestUtils.md5DigestAsHex(pass.getBytes());
		//return DigestUtil.sha256Hex(pass.getBytes());
	}

}
