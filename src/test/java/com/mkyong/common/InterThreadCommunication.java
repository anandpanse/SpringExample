/**
 * 
 */
package com.mkyong.common;

/**
 * @author anandpa
 *
 */
public class InterThreadCommunication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Account a=new Account();
			Depositor d=new Depositor(a);
			Withdrawer w=new Withdrawer(a);
			Thread t=new Thread(d,"Depositer");
			t.start();
			Thread t1=new Thread(w,"Withdrawer 1");
			t1.start();
			Thread t2=new Thread(w,"Withdrawer 2");
			t2.start();

	}

}


class Account{
	int money;
	boolean valueSet=false;
	public synchronized void put(int amount){
		while(valueSet){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		money=money+amount;
		System.out.println("Money Deposited:" +Thread.currentThread().getName()  +this.money);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		notifyAll();
		valueSet=true;
	}
	
	public synchronized void withdraw(){
		while(!valueSet){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Money Withdrawn:" +Thread.currentThread().getName() +this.money);
		this.money=0;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		valueSet=false;
		notifyAll();
	}
}


class Depositor implements Runnable{
	Account classAccount;
	 Depositor(Account a){
		 this.classAccount=a;
	 }
		 
		 
		public void run(){
			int money=100;
			while(true){
				 classAccount.put(money++);
			 }
		}
	 
}


class Withdrawer implements Runnable{
	Account withdrawerAccount;
	Withdrawer(Account a){
	this.withdrawerAccount=a;
	}
	
	public void run(){
		while(true){
			withdrawerAccount.withdraw();
		 }
	}
}