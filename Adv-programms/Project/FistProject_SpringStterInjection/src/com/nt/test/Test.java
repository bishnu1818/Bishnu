package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.sbeans.WishMesssgeGenerator;

public class Test {
	public static void main(String []args) {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("com/nt/cfgs/ApplicationContext.xml");
		WishMesssgeGenerator generator=context.getBean("wmg",WishMesssgeGenerator.class);
		String message=generator.generateWishMessage("bishnu");
		System.out.println(message);
		context.close();
				
	}
	
}
