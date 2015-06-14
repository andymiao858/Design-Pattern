package com.rabbit.designpattern.build;

public class Builder2 {

	public static void main(String[] args) {
		Car.Builder builder = new Car.Builder("BMW-Engine", "BMW-Transmission")
				.ABS("BMW-ABS");
		Car car = builder.build();
		System.out.println("Car engine: " + car.getEngine()
				+ ", transmission: " + car.getTransmission() + ", GPS: "
				+ car.getGPS() + ", ABS: " + car.getABS());
	}

	private static class Car {
		private String engine;
		private String transmission;

		private String GPS;
		private String ABS;

		private Car(Builder builder) {
			this.engine = builder.engine;
			this.transmission = builder.transmission;
			this.GPS = builder.GPS;
			this.ABS = builder.ABS;
		}

		public String getEngine() {
			return engine;
		}

		public String getTransmission() {
			return transmission;
		}

		public String getGPS() {
			return GPS;
		}

		public String getABS() {
			return ABS;
		}

		private static class Builder {
			private String engine;
			private String transmission;

			private String GPS;
			private String ABS;

			public Builder(String engine, String transmission) {
				this.engine = engine;
				this.transmission = transmission;
			}

			public Builder GPS(String GPS) {
				this.GPS = GPS;
				return this;
			}

			public Builder ABS(String ABS) {
				this.ABS = ABS;
				return this;
			}

			public Car build() {
				if(this.engine == null){
					throw new IllegalArgumentException("engine can not be null!");
				}
				if(transmission == null){
					throw new IllegalArgumentException("transmission can not be null");
				}
				
				if(GPS == null){
					System.out.println("do you really not wanna GPS?");
				}
				return new Car(this);
			}

		}
	}
}
