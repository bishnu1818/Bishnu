package com.nt;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Demo {
	public static void main(String[] args) {
		/*
		 * String str = "{()[]}"; int count1 = 0; int count2 = 0; int count3 = 0;
		 * 
		 * for (int i = 0; i < str.length(); i++) { char c = str.charAt(i); if (c ==
		 * '{') { count1++; } if (c == '}') { count1--; } if (c == '[') { count2++; } if
		 * (c == ']') { count2--; } if (c == '(') { count3++; } if (c == ')') {
		 * count3--; } } if (count1 == 0 && count2 == 0 && count3 == 0) {
		 * System.out.println("Enclosure "); } else {
		 * System.out.println("Not a Enclosure"); }
		 */
		/*
		 * String str = "abcdef"; 
		 * String rev = "";
		 *  for (int i = str.length() - 1; i >=0; i--) {
		 *  Character c = str.charAt(i); 
		 *  rev = rev + (c.toString());
		 *   }
		 * System.out.println(rev);
		 */
		int [] arr=new int[] {1,2,3,4,5};
		int [] revArr=new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			revArr[i]=arr[arr.length-i-1];
		}
	}

}
