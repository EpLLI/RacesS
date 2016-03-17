package by.academy.it;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

	@Test
	public void testBean() {
		
		ApplicationContext ctxt = new ClassPathXmlApplicationContext("bean-services.xml");
		
		System.out.println("ADMIN_SERVICE : " + ctxt.getBean("adminService"));
	}
}
