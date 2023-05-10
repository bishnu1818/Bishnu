package com.nt;

public class ReverseNumber {
	public static void main(String []args) {
		
		int number=876543;
		int	reverse=0;
		while(number!=0) {
			int x=number% 10;
			reverse=reverse*10+x;
			number=number/10;
		}
		
		System.out.println("THE REVERSE OF THE GIVEN NUMBER IS:");
		System.out.println(reverse);

	}

}
