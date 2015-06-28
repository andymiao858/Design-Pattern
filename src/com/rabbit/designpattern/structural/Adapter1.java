package com.rabbit.designpattern.structural;

public class Adapter1 {
	
	public static void main(String[] args) {
		Adaptee legacy = new Adaptee();
		Target shape = new Adapter(legacy);
		shape.display(0, 0, 100, 200);
	}
	
	public static class Adaptee{
		public void displayRect(int x1, int y1, int w, int h){
			System.out.println("left-top point is [" + x1 + ", " + y1 + "], width = " + w + ", height = " + h);
		}
	}
	
	public static interface Target{
		public void display(int x1, int y1, int x2, int y2);
		public void draw();
	}
	
	public static class Adapter implements Target{
		
		private Adaptee adaptee;
		
		public Adapter(Adaptee legacyRectangle) {
			this.adaptee = legacyRectangle;
		}

		@Override
		public void display(int x1, int y1, int x2, int y2) {
			adaptee.displayRect(x1, y1, x2 - x1, y2 - y1);
		}
		
		@Override
		public void draw() {
			// Do nothing
		}

	}

}
