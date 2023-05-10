package com.nt;


	public class Employee1 implements Comparable {
		String name;
		int eid;
		Employee1(String name,int eid){
			this.name=name;
			this.eid=eid;
		}
		public String toString() {
			return name+"--------"+eid;
		}
		
		public int compareTo(Object o) {
			int eid1=this.eid;
			int eid2=((Employee1)o).eid;
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




