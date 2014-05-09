package activemqWeb;

import java.net.URI;

import org.apache.activemq.broker.Broker;
import org.apache.activemq.broker.TransportConnector;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.apache.activemq.xbean.XBeanBrokerService;
import org.springMQTest.model.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@ComponentScan(basePackages={"org.springMQTest"})
public class JMSConfig {
	
	@Bean
	public Message getMessage(){
		return new Message("hello Anupam. welcome...You have arrived.");
	}
	
	@Bean
	public XBeanBrokerService jmsBroker(){
		XBeanBrokerService brokerService = new XBeanBrokerService();
		brokerService.setPersistent(false);
		brokerService.setUseJmx(false);
		try{
			TransportConnector connector = new TransportConnector();
			connector.setUri(new URI("tcp://localhost:9191"));
		}catch(Exception e){
			
		}
		return brokerService;
	}
	
	@Bean
	public ActiveMQQueue queue(){
		ActiveMQQueue activeMQQueue = new ActiveMQQueue();
		activeMQQueue.setPhysicalName("saltLakeMessageQueue");
		return activeMQQueue;
	}
	
	@Bean
	public ActiveMQConnectionFactory jmsConnectionFactory(){
		ActiveMQConnectionFactory activeMQConnectionFactory= new ActiveMQConnectionFactory();
		activeMQConnectionFactory.setBrokerURL("vm://localhost");		 
		return activeMQConnectionFactory;
	}
	
	@Bean
	public JmsTemplate jmsTemplate(){
		JmsTemplate jmsTemplate=new JmsTemplate();
		jmsTemplate.setConnectionFactory(jmsConnectionFactory());
		return jmsTemplate;
	}

}
