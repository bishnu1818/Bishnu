package in.ashok.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
	public static void main(String[]args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
		car c=context.getBean(car.class);
		c.drive();
	}

}
