package com.nt.ds;

 class Thread1 {
	public static void main(String []args)throws InterruptedException {
		Thread2 t=new Thread2();
		t.start();
		synchronized(t) {
			System.out.println("main thread calling wait() method");
			t.wait();
			System.out.println("main thread got notifiction");
			System.out.println(t.total);
		}
		
		
	}

}

class Thread2 extends Thread{
	int total=0;
	public void run() {
		synchronized(this) {
			System.out.println("child thread start calculation");
			for(int i=0;i<=100;i++) {
				total=total+i;
			}
			System.out.println("child thread giving notifiction");
			this.notify();
		}
	}
}