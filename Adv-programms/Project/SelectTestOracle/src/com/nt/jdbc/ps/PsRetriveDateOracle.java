package com.nt.jdbc.ps;

import java.text.SimpleDateFormat;

public class PsRetriveDateOracle {
	public static void main(String []args)throws Exception{
		String s1="34-18-1990";
	    SimpleDateFormat sdf=new SimpleDateFormat("DD-MM-YYYY");
		java.util.Date jud=sdf.parse(s1);
		System.out.println("ENTER STRING DATE VALUE::"+s1);
		System.out.println("ENTER UTIL DATE VALUE::"+jud);
		long ms=jud.getTime();
		java.sql.Date jsd=new java.sql.Date(ms);
		System.out.println("ENTER SQL DATE VALUES::"+jsd);
		
		String s2="1980-10-10";
		java.sql.Date jsd1=java.sql.Date.valueOf(s2);
		System.out.println("ENTER 2ND SQL DATE::"+jsd1);
		
		java.util.Date jud1=jsd1;
		System.out.println("ENTER UTIL DATE::"+jud1);
		
	    SimpleDateFormat sdf1=new SimpleDateFormat("DD-MM-YYYY");
	    String sd2=sdf1.format(jud1);
	    System.out.println("ENTER STRING DATE VALUES::"+sd2);
		
		
	}

}
