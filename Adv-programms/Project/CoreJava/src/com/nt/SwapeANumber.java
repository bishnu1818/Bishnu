package com.nt;

public class SwapeANumber {
	public static void main (String[]args) {
		int a=20,b=30;
		System.out.println("Befor Swapping Number A::"+a);
		System.out.println("Befor Swapping Number B::"  +b);
		
		int t=a;
		a=b;
		b=t;
		
		
		
		System.out.println("\nAfter Swapping Number A::"+a);
		System.out.println("After Swapping Number B::"+b);
	}

}
