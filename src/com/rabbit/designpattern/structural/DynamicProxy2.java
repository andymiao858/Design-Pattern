package com.rabbit.designpattern.structural;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy2 {

	public static void main(String[] args) {
		Subject subject = SubjectFactory.createApi();
		subject.sayHello("Rabbit");
		System.out.println(subject.hashCode());
	}

	public static interface Subject {
		public void sayHello(String name);
	}

	public static class RealSubject implements Subject {

		@Override
		public void sayHello(String name) {
			System.out.println("Hello [" + name + "]");
		}
	}
	
	public static class SubjectFactory{
		
		public static Subject createApi(){
			Subject subject = new RealSubject();
			InvocationHandler proxySubject = new InvocationHandlerImpl(subject);
			return (Subject) Proxy.newProxyInstance(
					subject.getClass().getClassLoader(),
					subject.getClass().getInterfaces(), proxySubject);
		}
	}

	public static class InvocationHandlerImpl implements InvocationHandler {

		private Subject subject = null;

		public InvocationHandlerImpl(Subject subject) {
			this.subject = subject;
		}
		
		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			System.out.println("before hello");
			Object obj = method.invoke(subject, args);
			System.out.println("after hello");
			return obj;
		}

	}

}
