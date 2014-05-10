package org.springMQTest.business;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;


@Service("consumer")
public class MessageConsumer {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private Queue jmsQueue;
	
	public void consumeMessage()throws JMSException{
		if(jmsTemplate!=null){
			Message message = jmsTemplate.receive(jmsQueue);
			if(message instanceof TextMessage){
				TextMessage textMessage = (TextMessage)message;
				System.out.println("printing Message Content" + textMessage.getText());
			}
		}
	}

}
