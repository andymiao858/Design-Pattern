package com.rabbit.designpattern.build;

public enum Singleton4 {

	INSTANCE;
	
	private int var = 100;
	
	public void method(){
		System.out.println("method called! var = " + var);
	}
	
	public static void main(String[] args){
		Singleton4.INSTANCE.method();
	}
}
