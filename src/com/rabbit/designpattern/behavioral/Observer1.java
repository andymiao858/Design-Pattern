package com.rabbit.designpattern.behavioral;

import java.util.ArrayList;
import java.util.List;

public class Observer1 {

	public static abstract class Subject {

		protected List<Observer> observers = new ArrayList<Observer>();

		public void attach(Observer observer) {
			if (observer == null)
				return;
			if (!observers.contains(observer)) {
				observers.add(observer);
			}
		}

		public void detach(Observer observer) {
			if (observer == null) {
				return;
			}
			observers.remove(observer);
		}

		protected void notifyObserver() {
			for (Observer observer : observers) {
				observer.update(this);
			}
		}

	}

	public static class Newspaper extends Subject {

		private String content;

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
			notifyObserver();
		}

	}

	public static interface Observer {
		public void update(Subject subject);
	}

	public static class Reader implements Observer {

		private String name;

		public Reader(String name) {
			this.name = name;
		}

		@Override
		public void update(Subject subject) {
			System.out.println(name + " has received newspaper, content is ["
					+ ((Newspaper) subject).getContent() + "]");

		}
	}

	public static void main(String[] args) {

		Reader reader1 = new Reader("刘德华");

		Reader reader2 = new Reader("张学友");

		Newspaper subject = new Newspaper();

		subject.attach(reader1);
		subject.attach(reader2);

		subject.setContent("Head News");

	}

}
