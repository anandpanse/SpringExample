package com.mkyong.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class ProducerConsumer {

	public static void main(String[] args) {
	 
		Stack<Integer> pool=new Stack<Integer>();
		Thread t1=new Thread(new Producer(pool,4),"t1");
		Thread t2=new Thread(new Consumer(pool,4),"t2");

		t1.start();
		t2.start();
	}
	
}

class Producer implements Runnable{
	Stack<Integer> pool=new Stack<Integer>();
	int maxSize;
	public static int counter=0;
	Producer(Stack buffer,int maxSize){
		this.pool=buffer;
		this.maxSize=maxSize;
	}
	
	public void run(){
		
		while(true){
			synchronized (pool) {
			   while(pool.size()==maxSize){
				   try {
					   System.out.println("Pool is full......");
					pool.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			   }   
				Random num=new Random();
				Integer num1=new Integer(num.nextInt(100));
				pool.add(num1);
				System.out.println("Number Produced:"+num1);
				pool.notify();			
			}
		}
		
	}
	
}


class Consumer implements Runnable{
	Stack<Integer> pool=new Stack<Integer>();
	int maxSize;
	Consumer(Stack buffer,int maxSize){
		this.pool=buffer;
		this.maxSize=maxSize;
	}
	
	public void run(){
		while(true){
		synchronized (pool) {
			while(pool.isEmpty()){
				try {
					 System.out.println("Que is Empty");
					pool.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Number Consumer:"+pool.pop());
			pool.notify();
		}
		
		}
		
	}
	
}
