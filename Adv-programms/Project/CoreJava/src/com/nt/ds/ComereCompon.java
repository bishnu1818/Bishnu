package com.nt.ds;

import java.util.TreeSet;

 class ComereCompon {
public static void main(String[] args) {
	
	Employee e=new Employee("biswa",1000);
	Employee e1=new Employee("bisnu",1001);
	Employee e2=new Employee("joti",1002);
	Employee e3=new Employee("sachin",1003);
	Employee e4=new Employee("suvendu",1004);
	Employee e5=new Employee("bideshi",1005);
	Employee e6=new Employee("litu",1006);
	Employee e7=new Employee("bikash",10007);
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
