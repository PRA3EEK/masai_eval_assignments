package mainApps;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.prateek.classes.Triangle;

public class Demo {
	
	public static void main(String[] args) {
		
    ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
      Triangle t = ctx.getBean("T", Triangle.class);
		t.draw();
	}

}
