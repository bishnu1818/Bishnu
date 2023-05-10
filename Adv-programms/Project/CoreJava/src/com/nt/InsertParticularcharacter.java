package com.nt;

public class InsertParticularcharacter {
	
	public static void main(String[] args) {
		StringBuffer sb=new StringBuffer("bishuprasadswal");
		sb.insert(4, "n");
		sb.insert(12," bi");
		sb.insert(6," ");
		System.out.println(sb);
	}

}
