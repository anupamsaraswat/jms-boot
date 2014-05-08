package activemqWeb;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springMQTest.model.Message;
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
		
		//servletContext.addListener(new ContextLoaderListener());
	}

}
