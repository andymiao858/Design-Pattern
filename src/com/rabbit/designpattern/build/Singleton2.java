package com.rabbit.designpattern.build;

// lazy mode
public class Singleton2 {

	private static Singleton2 instance;
	
	private Singleton2(){
		System.out.println("Singleton1 construct!");
	};
	
	public synchronized static Singleton2 getInstance(){
		if(instance == null){
			instance = new Singleton2();
		}
		return instance;
	};
	
	public void method(){
		System.out.println("method called!");
	}
	
	public static void main(String[] args){
		Singleton2 singleton = Singleton2.getInstance();
		singleton.method();
	}
	
}
