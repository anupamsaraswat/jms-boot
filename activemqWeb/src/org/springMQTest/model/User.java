package org.springMQTest.model;

import org.springframework.stereotype.Component;

@Component("userBean")
public class User {
	
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
