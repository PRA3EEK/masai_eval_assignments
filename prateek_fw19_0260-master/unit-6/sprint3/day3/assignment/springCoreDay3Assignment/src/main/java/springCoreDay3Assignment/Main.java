package springCoreDay3Assignment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
   
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Demo d = ctx.getBean(Demo.class, "demo");
		
		d.showDetails();
		ClassPathXmlApplicationContext c = (ClassPathXmlApplicationContext)ctx;
		c.close();
	}
	
}
