package com.rabbit.designpattern.build;

public enum Singleton4 {

	INSTANCE;
	
	public void method(){
		System.out.println("method called!");
	}
	
	public static void main(String[] args){
		Singleton4.INSTANCE.method();
	}
}
