package com.nt.jdbc.ps;

import java.text.SimpleDateFormat;

public class DateConversionTest {
	public static void main (String []args)throws Exception {
		String s1="10-12-1990";
		SimpleDateFormat sdf=new SimpleDateFormat("DD-MM-YYYY");
		java.util.Date jud=sdf.parse(s1);
		System.out.println("String Date Values::"+s1);
        System.out.println("Util Date Values::"+jud);		
		
        long ms=jud.getTime();
        java.sql.Date jsd=new java.sql.Date(ms);
        System.out.println("SQL DATE::"+jsd);
        
        String s2="1999-12-10";
        java.sql.Date jsd2=java.sql.Date.valueOf(s2);
        System.out.println("SQL DATE"+jsd2);
	}

}
