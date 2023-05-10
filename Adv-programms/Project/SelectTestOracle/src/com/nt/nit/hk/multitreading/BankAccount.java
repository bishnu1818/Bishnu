package com.nit.hk.multitreading;

 class Bank {

	private long accNum;
	private String accHName;
	private double balance;


	public Bank(long accNum, String accHName, double balance) {
	
		this.accNum = accNum;
		this.accHName = accHName;
		this.balance = balance;
	}
	public void deposit(double amt) {
		this.balance=this.balance+amt;
	}
	public void withdraw(double amt) {
		this.balance=this.balance-amt;
	}
	public void currentBalance() {
		System.out.println(balance);
	}
	public long getAccountNum() {
		return accNum;
	}
}


class DepositThread extends Thread{
	private Bank acc;
	private double amt;
	public DepositThread(Bank acc, double amt) {
		
		this.acc = acc;
		this.amt = amt;
	}

	@Override
	public void run() {
		acc.deposit(amt);
		System.out.println(getName()+"deposit"+amt+"from the account"+acc.getAccountNum());
	}
}
class WithdrawThread extends Thread{
	private Bank acc;
	private double amt;
	
	public WithdrawThread(Bank acc, double amt) {
	
		this.acc = acc;
		this.amt = amt;
	}

	@Override
	public void run() {
		acc.withdraw(amt);
		System.out.println(getName()+"withdrawn"+amt+"from the account"+acc.getAccountNum());
	}
}
public class BankAccount {
	public static void main(String []args)throws InterruptedException{
		System.out.println("Bank start");
		
		Bank b1=new Bank(1234,"c1",10000);
		Bank b2=new Bank(9868,"c2",20000);
		Bank b3=new Bank(8640,"c3",30000);
		Bank b4=new Bank(1764,"c4",40000);
		
		DepositThread dt1=new DepositThread (b1,5000);
		DepositThread dt2=new DepositThread (b1,8000);
		
		 WithdrawThread wt1=new  WithdrawThread(b3,2000);
		 WithdrawThread wt2=new  WithdrawThread(b4,7000);
		 
		 dt1.start();
		 dt2.start();
		 wt1.start();
		 wt2.start();
		 
		 Thread.sleep(1000);
		 System.out.println("b1 balance:");
		b1.currentBalance();
		 System.out.println("b2 balance:");
		b2.currentBalance();
		 System.out.println("b3 balance:");
		b3.currentBalance();
		 System.out.println("b4 balance:");
		b4.currentBalance();
      
		System.out.println("Bank end");
		
		
	}
}
	
