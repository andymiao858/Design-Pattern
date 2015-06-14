package com.rabbit.designpattern.build;



public class Prototype2 {
	
	public static void main(String[] args){
		EngineInfo engine = new EngineInfo();
		engine.setEngineName("BMW-V6");
		engine.setEngineNo(888);
		
		BMW car = new BMW();
		car.setName("Rabbit BMW");
		car.setEngineInfo(engine);
		
		
		BMW cloneCar = null;
		try {
			cloneCar = (BMW)car.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cloneCar.getEngineInfo().setEngineName("BMW-V8");
		
		System.out.println("Car Name [" + car.getName() + "], Engine [" + car.getEngineInfo().getEngineName() + "]");
		System.out.println("Clone Car Name [" + cloneCar.getName() + "], Engine [" + cloneCar.getEngineInfo().getEngineName() + "]");
	}
	
	private static interface Car{
		public String getName();
		public void setName(String name);
		public EngineInfo getEngineInfo();
		public void setEngineInfo(EngineInfo engineInfo);
	}
	
	
	private static class BMW implements Car, Cloneable{
		protected String name;
		protected EngineInfo engineInfo;
		
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
		public Car clone() throws CloneNotSupportedException {
			Car car = (BMW)super.clone();
			EngineInfo engineInfo = (EngineInfo)this.engineInfo.clone();
			car.setEngineInfo(engineInfo);
			return car;
		}

		
	}
	
	private static class EngineInfo implements Cloneable{
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
