package activemqWeb;

import org.springMQTest.model.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"org.springMQTest.model"})
public class JMSConfig {
	
	@Bean
	public Message getMessage(){
		return new Message("hello Anupam. welcome...You have arrived.");
	}
	
	

}
