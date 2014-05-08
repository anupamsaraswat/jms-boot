package org.springMQTest.model;

public class Message {
	
	private String messageHeader;
	
	public Message(String messageHeader){
		this.messageHeader = messageHeader;
	}
	public Message(){
	
	}

	public String getMessageHeader() {
		return messageHeader;
	}

	public void setMessageHeader(String messageHeader) {
		this.messageHeader = messageHeader;
	}

}
