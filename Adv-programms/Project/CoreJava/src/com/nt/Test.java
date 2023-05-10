package com.nt;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException {
		/*
		 * Class clazz=Demo.class; System.out.println(clazz);
		 * System.out.println(clazz.hashCode()); Class<?> forName =
		 * Class.forName("com.nt.Demo"); System.out.println(forName);
		 * System.out.println(forName.hashCode());
		 */
		/*
		 * Demo demo = new Demo(); Demo demo2 = new Demo();
		 * 
		 * System.out.println(demo.hashCode()); System.out.println(demo2.hashCode());
		 * System.out.println(demo.toString()); Integer i = 10; System.out.println(i);
		 */
		/*
		 * System.out.println(demo.getClass().getName()+"@"+Integer.toHexString(demo.
		 * hashCode()));
		 */

		/*
		 * Class<? extends Demo> class1 = demo.getClass(); System.out.println(class1);
		 * System.out.println(class1.hashCode());
		 */
		Demo1 demo1 = new Demo1(10);
		System.out.println(demo1);
	}

}

class Demo1 {
	int x;

	public Demo1(int x) {
		this.x = x;

	}

	@Override
	public String toString() {
		return x + "";
	}

}
