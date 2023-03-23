package examples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import springCoreDay3Assignment.Demo;

public class DemoA {
  
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		A abean = ctx.getBean(A.class, "a");
		abean.display();
		}
}
