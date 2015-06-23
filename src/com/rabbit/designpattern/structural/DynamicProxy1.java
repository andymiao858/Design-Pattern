package com.rabbit.designpattern.structural;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy1 {

	public static void main(String[] args) {
		Subject subject = new RealSubject();
		ProxySubject proxySubject = new ProxySubject();
		Subject proxy = proxySubject.getProxyInterface(subject);
		proxy.sayHello("Rabbit");
		System.out.println(proxy.hashCode());
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

	public static class ProxySubject implements InvocationHandler {

		private Subject subject = null;

		public Subject getProxyInterface(Subject subject) {
			this.subject = subject;
			return (Subject) Proxy
					.newProxyInstance(subject.getClass().getClassLoader(),
							subject.getClass().getInterfaces(), this);
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
