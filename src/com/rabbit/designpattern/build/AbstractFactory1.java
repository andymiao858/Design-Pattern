package com.rabbit.designpattern.build;


public class AbstractFactory1 {
	
	public static void main(String[] args){
		AssembleFactory factory = new BMWAssembleFactory();
		Engine engine = factory.assembleEngine();
		Transmission transmission = factory.assembleTransmission();
		System.out.println(engine.getEngineManufactory());
		System.out.println(transmission.getTransmissionManufactory());
	}
	
	// abstract factory use
	
	public static interface AssembleFactory{
		public Engine assembleEngine();
		public Transmission assembleTransmission();
	}
	
	public static class BMWAssembleFactory implements AssembleFactory{

		@Override
		public Engine assembleEngine() {
			return new BMWEngine();
		}

		@Override
		public Transmission assembleTransmission() {
			return new BMWTransmission();
		}
	}

	public static class ToyotaAssembleFactory implements AssembleFactory{

		@Override
		public Engine assembleEngine() {
			return new ToyotaEngine();
		}

		@Override
		public Transmission assembleTransmission() {
			return new ToyotaTransmission();
		}
		
	}
	
	public static interface Engine{
		public String getEngineManufactory();
	}
	
	public static interface Transmission{
		public String getTransmissionManufactory();
	}
	
	public static class BMWEngine implements Engine{

		@Override
		public String getEngineManufactory() {
			return "BMW engine";
		}
	}
	
	public static class ToyotaEngine implements Engine{

		@Override
		public String getEngineManufactory() {
			return "Toyota engine";
		}
	}
	
	public static class BMWTransmission implements Transmission{

		@Override
		public String getTransmissionManufactory() {
			return "BMW Transmission";
		}
	}

	public static class ToyotaTransmission implements Transmission{

		@Override
		public String getTransmissionManufactory() {
			return "Toyota Transmission";
		}
		
	}

}
