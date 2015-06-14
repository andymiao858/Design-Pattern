package com.rabbit.designpattern.build;

public class Prototype1 {
	
	public static void main(String[] args){

		EngineInfo engine = new EngineInfo();
		engine.setEngineName("BMW-V6");
		engine.setEngineNo(888);
		
		
		Car car = new BMW();
		car.setName("Rabbit BMW");
		car.setEngineInfo(engine);
		
		Car cloneCar = car.cloneCar();
		cloneCar.getEngineInfo().setEngineName("BMW-V8");
		System.out.println("Car Name [" + car.getName() + "], Engine [" + car.getEngineInfo().getEngineName() + "]");
		System.out.println("Clone Car Name [" + cloneCar.getName() + "], Engine [" + cloneCar.getEngineInfo().getEngineName() + "]");
	}
	
	private static interface Car{
		public String getName();
		public void setName(String name);
		public EngineInfo getEngineInfo();
		public void setEngineInfo(EngineInfo engineInfo);
		public Car cloneCar();
	}
	
	
	private static class BMW implements Car{
		protected String name;
		protected EngineInfo engineInfo;
		
		public BMW(){}
		
		@Override
		public String getName() {
			return name;
		}
		
		@Override
		public void setName(String name) {
			this.name = name;
		}

		@Override
		public EngineInfo getEngineInfo() {
			return engineInfo;
		}

		@Override
		public void setEngineInfo(EngineInfo engineInfo) {
			this.engineInfo = engineInfo;
			
		}
		
		@Override
		public Car cloneCar() {
			BMW bmw2 = new BMW();
			bmw2.setName(name);
			EngineInfo engineInfo = new EngineInfo();
			engineInfo.setEngineName(this.engineInfo.getEngineName());
			engineInfo.setEngineNo(this.engineInfo.getEngineNo());
			bmw2.setEngineInfo(engineInfo);
			return bmw2;
		}

		
	}
	
	private static class EngineInfo{
		private int engineNo;
		private String engineName;
		
		public EngineInfo(){}

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
	}
}
