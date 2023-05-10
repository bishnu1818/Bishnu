package com.nt.sbeans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMesssgeGenerator {
	
	private LocalDateTime ldt;
	
	public WishMesssgeGenerator() {
		System.out.println("WishmessageGenerator:0 param constuctor");
	}
	
	@Autowired
	public void setLdt(LocalDateTime ldt) {
		System.out.println("WishMessageGenerator.setLdt()");
		this.ldt=ldt;
	}
	public String generateWishMessage(String user) {
	   System.out.println("WishMessageGenerator.generateWishMessage()");
	   int hour=ldt.getHour();
	   if(hour<12)
		   return"Good Morning::"+user;
	   else if(hour<16)
		   return"Good Afternoon::"+user;
	   else if(hour<20)
		   return"good evening::"+user;
	   else
		   return"good night::"+user;
		
	}

}
