package com.nt.test;

public class SwappinTwoNumber {
	public static void main( String[] args) {
		int a=10;
		int b=20;
		System.out.println("Befor Swapping Number..A :"+a+"   B :"+b);
		/*int c=a;
		a=b;
		b=c;*/
		b=a+b-(a=b);
		System.out.println("After Swapping Number..A  :"+a+"  B :"+b);
	}

}
