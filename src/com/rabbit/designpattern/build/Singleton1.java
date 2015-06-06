package com.rabbit.designpattern.build;

// early mode
public class Singleton1 {

	private final static Singleton1 instance = new Singleton1();
	
	private Singleton1(){
		System.out.println("Singleton1 construct!");
	};
	
	public static Singleton1 getInstance(){
		return instance;
	}
	
	public void method(){
		System.out.println("method called!");
	}
	
	public static void main(String[] args){
		Singleton1 singleton = Singleton1.getInstance();
		singleton.method();
	}
	
}
