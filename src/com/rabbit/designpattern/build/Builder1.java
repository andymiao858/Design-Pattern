package com.rabbit.designpattern.build;

public class Builder1 {
	
	public static void main(String[] args){
		Builder builder = new BMWBuilder();
		Director director = new Director(builder);
		director.construct();
		Car car = builder.getResult();
		System.out.println("Car engine: " + car.getEngine() + ", transmission: " + car.getTransmission());
	}
	
	public static class Car{
		private String engine;
		private String transmission;
		public String getEngine() {
			return engine;
		}
		public void setEngine(String engine) {
			this.engine = engine;
		}
		public String getTransmission() {
			return transmission;
		}
		public void setTransmission(String transmission) {
			this.transmission = transmission;
		}
		
	}
	
	public static interface Builder{
		public void assembleEngine();
		public void assembleTransmission();
		public Car getResult();
	}
	
	public static class BMWBuilder implements Builder{
		
		private Car car = new Car();

		@Override
		public void assembleEngine() {
			car.setEngine("BMW engine");
			System.out.println("assemble BMW engine!");
		}

		@Override
		public void assembleTransmission() {
			car.setTransmission("BMW transmission");
			System.out.println("assemble BMW transmission!");
		}

		@Override
		public Car getResult() {
			return car;
		}
		
	}
	
	public static class ToyotaBuilder implements Builder{
		
		private Car car = new Car();

		@Override
		public void assembleEngine() {
			System.out.println("make TOYOTA engine!");
		}

		@Override
		public void assembleTransmission() {
			System.out.println("make TOYOTA transmission!");
		}

		@Override
		public Car getResult() {
			return car;
		}
		
	}
	
	public static class Director{
		
		private Builder builder;
		
		public Director(Builder builder){
			this.builder = builder;
		}
		
		public void construct(){
			builder.assembleEngine();
			builder.assembleTransmission();
		}
	}

}
