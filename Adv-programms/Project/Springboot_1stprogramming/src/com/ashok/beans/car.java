package com.ashok.beans;

public class car extends Engine {
	public void drive() {
		
		int enginestatus=start();
		
		if(enginestatus==1) {
			System.out.println("Engine Started");
			
		}
		else {
			System.out.println("Engine not Started");
		}
			
	}

}
