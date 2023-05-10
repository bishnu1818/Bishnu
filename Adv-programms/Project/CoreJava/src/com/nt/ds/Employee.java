package com.nt.ds;

import java.util.*;

public class Employee implements Comparable {
	String name;
	int eid;
	Employee(String name,int eid){
		this.name=name;
		this.eid=eid;
	}
	public String toString() {
		return name+"--------"+eid;
	}
	
	public int compareTo(Object o) {
		int eid1=this.eid;
		int eid2=((Employee)o).eid;
		if(eid1<eid2) {
			return -1;
		}
		else if(eid1>eid2) {
			return +1;
		
	}
		else
			return 0;

	}
}


