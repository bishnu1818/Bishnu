package com.nt;

public class Test101 {
	String name;
	int rollNo;
	Test101(String name,int rollNo){
		this.name=name;
		this.rollNo=rollNo;
	}
	public String toString() {
		return name+"-----"+rollNo;
		
	}
		public static void main(String []args) {
			Test101 t1=new Test101("bishnu",1000);
			Test101 t2=new Test101("biswa",1001);
			System.out.println(t1.toString());
			System.out.println(t2);
			
		}
	}


