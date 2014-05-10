package org.springMQTest.business;


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component("messageProducer")
public class MessageProducer {
	
	@Autowired
	public JmsTemplate jmsTemplate;
	
	@Autowired
	public ActiveMQQueue jmsQueue;
	
	public MessageProducer(){
		System.out.println("messageProducer created");
	}
	
	public void produce() throws Exception {
		      
		      if (jmsTemplate != null) {
		         MessageCreator mc = new MessageCreator() {
		            public Message createMessage(Session session) throws JMSException {
		               try {
		                  TextMessage message = session.createTextMessage("This is a message.");
		                  return message;
		               } 
		                catch (JMSException je) {
		                  //logger.error("JMS Exception : ", je);
		                  return null;
		               }
		            }
		         };
		         jmsTemplate.send(jmsQueue,mc);
		      }
		   }

}
