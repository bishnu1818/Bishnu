package com.nt;

public class ReverseNumberAndCharacter {
	
	public static void main(String []args) {
		StringBuffer sb=new StringBuffer("Bishnu Prasad Biswal");
		StringBuffer sb4=new StringBuffer();
		sb4.ensureCapacity(123);
        StringBuffer sb1=new StringBuffer("12345");
		String s=new String("bishnuprasadbiswal");
		String s2=s.concat("money");
		String s1=s.toUpperCase();
		s=s.toLowerCase();
		sb.setLength(6);
		sb.setLength(12);
		System.out.println(sb.reverse());
		System.out.println(sb1.reverse());
		System.out.println(s1);
		System.out.println(s);
		System.out.println(s2);
		System.out.println(sb);
		System.out.println(sb);
		System.out.println(sb4.capacity());
		System.out.println(sb4.capacity());
		
	}

}
