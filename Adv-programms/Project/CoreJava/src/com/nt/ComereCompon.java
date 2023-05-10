package com.nt;

import java.util.TreeSet;

public class ComereCompon {
	public static void main(String[] args) {
		
		Employee1 e=new Employee1("biswa",1010);
		Employee1 e1=new Employee1("bisnu",1001);
		Employee1 e2=new Employee1("joti",1002);
		Employee1 e3=new Employee1("sachin",1003);
		Employee1 e4=new Employee1("suvendu",1004);
		Employee1 e5=new Employee1("bideshi",1005);
		Employee1 e6=new Employee1("litu",1006);
		Employee1 e7=new Employee1("bikash",10007);
		TreeSet t=new TreeSet();
		t.add(e);
		t.add(e1);
		t.add(e2);
		t.add(e3);
		t.add(e4);
		t.add(e5);
		t.add(e6);
		t.add(e7);
		System.out.println(t);
	}

	}



