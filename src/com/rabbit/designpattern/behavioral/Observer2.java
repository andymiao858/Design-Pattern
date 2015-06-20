package com.rabbit.designpattern.behavioral;

import java.util.Observable;
import java.util.Observer;

public class Observer2 {
	
	public static class Newspaper extends Observable{
		
		private String content;

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
			this.setChanged();
			this.notifyObservers(this);
		}
		
	}
	
	
	public static class Reader implements Observer{
		
		private String name;
		
		public Reader(String name){
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}


		@Override
		public void update(Observable o, Object arg) {
			System.out.println(name + " has received newspaper, content is ["
					+ ((Newspaper) o).getContent() + "]");
		}
	}
	
	public static void main(String[] args) {

		Reader reader1 = new Reader("刘德华");

		Reader reader2 = new Reader("张学友");

		Newspaper observable = new Newspaper();

		observable.addObserver(reader1);
		observable.addObserver(reader2);
		
		observable.setContent("Head News");

	}

}
