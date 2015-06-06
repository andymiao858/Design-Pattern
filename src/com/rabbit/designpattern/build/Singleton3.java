package com.rabbit.designpattern.build;

public class Singleton3 {
	
	private Singleton3(){
		System.out.println("Singleton3 construct!");
	}
	
	private static class SingletonHolder{
		private static Singleton3 instance = new Singleton3();
	}
	
	public static Singleton3 getInstance(){
		return SingletonHolder.instance;
	}
	
	public void method(){
		System.out.println("method called!");
	}
	
	public static void main(String[] args){
		Singleton3 singleton =  Singleton3.getInstance();
		singleton.method();
	}
	
}
