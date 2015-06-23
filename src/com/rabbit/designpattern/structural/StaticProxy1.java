package com.rabbit.designpattern.structural;

public class StaticProxy1 {
	
	public static void main(String[] args){
		Subject subject = new Proxy();
		subject.display("Hello Rabbit");
	}
	
	public static interface Subject{
		public void display(String name);
	}
	
	public static class RealSubject implements Subject{
		
		@Override
		public void display(String name){
			System.out.println("diplay name is " + name);
		}
	}
	
	public static class Proxy implements Subject{

		private RealSubject realSubject;
		
		@Override
		public void display(String name) {
			if(realSubject == null){
				realSubject = new RealSubject();
			}
			realSubject.display(name);
			
		}
		
	}

}
