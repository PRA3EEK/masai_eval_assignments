package springCoreDay2Assignment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
	
	public static void main(String[] args) {
		
		ApplicationContext atx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		College cO = atx.getBean(College.class,"c");
		
		cO.showDetails();
		
	}

}
