package activemqWeb;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springMQTest.business.MessageConsumer;
import org.springMQTest.business.MessageProducer;
import org.springMQTest.model.Message;
import org.springMQTest.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;

public class activemqSpringInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//use annotationScanner to register all the beans and context loaderListener
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(JMSConfig.class);
		ctx.refresh();
		
		Message message = (Message)ctx.getBean(Message.class);
		System.out.println(message.getMessageHeader());
		
		
		User user = (User)ctx.getBean("userBean");
		user.setUserName("Anuapm");
		
		System.out.println("Hey" + user.getUserName() + "welcome Back......");
		
		
		MessageProducer messageProducer=(MessageProducer)ctx.getBean("messageProducer");
		MessageConsumer messageConsumer = (MessageConsumer)ctx.getBean("consumer");
		try{
			messageProducer.produce();
			messageConsumer.consumeMessage();
			messageProducer.produce();
			messageConsumer.consumeMessage();
		}catch(Exception e){
			
		}
		
		//servletContext.addListener(new ContextLoaderListener());
	}

}
