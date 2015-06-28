package com.rabbit.designpattern.structural;


public class Adapter2 {
	
	public static void main(String[] args){
		LegacyShape legacyShape = new LegacyShapeImpl();
		Shape shape = new Rect();
		
		Shape shape2 = new Adapter(shape, legacyShape);
		LegacyShape legacyShape2 = new Adapter(shape, legacyShape);
		
		shape2.display(0, 0, 100, 100);
		legacyShape2.displayCircle(5, 5, 5);
	}
	
	
	public static interface LegacyShape{
		public void displayRect(int x1, int y1, int w, int h);
		public void displayCircle(int cx, int cy, int r);
	}
	
	public static class LegacyShapeImpl implements LegacyShape{
		public void displayRect(int x1, int y1, int w, int h){
			System.out.println("left-top point is [" + x1 + ", " + y1 + "], width = " + w + ", height = " + h);
		}

		@Override
		public void displayCircle(int cx, int cy, int r) {
			System.out.println("Circle center = [" + cx + ", " + cy + "], radius = " + r);
		}
		
	}
	
	public static interface Shape{
		public void display(int x1, int y1, int x2, int y2);
		public void draw();
	}
	
	public static class Rect implements Shape{
		
		@Override
		public void display(int x1, int y1, int x2, int y2) {
			System.out.println("Rect --> display");
		}

		@Override
		public void draw() {
			System.out.println("Rect --> draw");
		}
		
	}
	
	public static class Adapter implements Shape, LegacyShape{
		
		private LegacyShape legacyShape;
		
		private Shape shape;
		
		public Adapter(Shape shape, LegacyShape legacyShape) {
			this.legacyShape = legacyShape;
			this.shape = shape;
		}

		@Override
		public void display(int x1, int y1, int x2, int y2) {
			shape.display(x1, y1, x2 - x1, y2 - y1);
		}
		
		@Override
		public void draw() {
			shape.draw();
		}

		@Override
		public void displayRect(int x1, int y1, int w, int h) {
			legacyShape.displayRect(x1, y1, w, h);
		}

		@Override
		public void displayCircle(int cx, int cy, int r) {
			legacyShape.displayCircle(cx, cy, r);
		}
		
		

	}

}
