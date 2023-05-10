package com.nt;

import java.util.TreeSet;

public class NavigableTest {
	public static void main (String[]args) {
		TreeSet<Integer> ts=new TreeSet<Integer>();
		ts.add(1000);
		ts.add(2000);
		ts.add(3000);
		ts.add(4000);
		ts.add(5000);
		ts.add(6000);
		System.out.println(ts.ceiling(2000));
		System.out.println(ts.higher(2000));
		System.out.println(ts.floor(3000));
		System.out.println(ts.lower(3000));
		System.out.println(ts.subSet(1000,5000 ));
		System.out.println(ts.pollFirst());
		System.out.println(ts.pollLast());
		System.out.println(ts.descendingSet());
		System.out.println(ts);
		
	}

}
