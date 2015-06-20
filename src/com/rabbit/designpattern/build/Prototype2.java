package com.rabbit.designpattern.build;

public class Prototype2 {

	public static void main(String[] args) {

		String str1 = "abc";
		String str2 = "abc";
		System.out.println(str1 == str2);

		String str3 = new String("abc");
		String str4 = new String("abc");
		System.out.println(str3 == str4);

		EngineInfo engine = new EngineInfo();
		engine.setEngineName("BMW-V6");
		engine.setEngineNo(888);

		BMW car = new BMW();
		car.setName("Rabbit BMW");
		car.setEngineInfo(engine);
		car.setRadar("Radar");

		BMW cloneCar = null;
		try {
			cloneCar = (BMW) car.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		cloneCar.getEngineInfo().setEngineName("BMW-V8");

		System.out.println("Car Name [" + car.getName() + "], Engine ["
				+ car.getEngineInfo().getEngineName() + "]");
		System.out.println("Clone Car Name [" + cloneCar.getName()
				+ "], Engine [" + cloneCar.getEngineInfo().getEngineName()
				+ "], Radar [" + cloneCar.getRadar() + "]");
	}

	private static abstract class Car implements Cloneable {
		protected String name;

		protected EngineInfo engineInfo;

		public EngineInfo getEngineInfo() {
			return engineInfo;
		}

		public void setEngineInfo(EngineInfo engineInfo) {
			this.engineInfo = engineInfo;

		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		protected Car clone() throws CloneNotSupportedException {
			Car car = (Car) super.clone();
			EngineInfo engineInfo = (EngineInfo) this.engineInfo.clone();
			car.setEngineInfo(engineInfo);
			return car;
		}
	}

	private static class BMW extends Car {
		
		private String radar;
		
		public String getRadar() {
			return radar;
		}

		public void setRadar(String radar) {
			this.radar = radar;
		}

		@Override
		public Car clone() throws CloneNotSupportedException {
			return super.clone();
		}

	}

	private static class EngineInfo implements Cloneable {
		private int engineNo;
		private String engineName;

		public int getEngineNo() {
			return engineNo;
		}

		public void setEngineNo(int engineNo) {
			this.engineNo = engineNo;
		}

		public String getEngineName() {
			return engineName;
		}

		public void setEngineName(String engineName) {
			this.engineName = engineName;
		}

		@Override
		protected Object clone() throws CloneNotSupportedException {
			return super.clone();
		}
	}

}
