package com.rabbit.designpattern.build;


public class Product {
	public enum CAR {
		BMW, TOYOTA
	}

	public static interface ProduceApi {
		public boolean produce(String data);
	}

	public static class ProduceBMW implements ProduceApi {

		@Override
		public boolean produce(String data) {
			System.out.println("produce BMW [" + data + "]");
			return true;
		}

	}

	public static class ProduceToyota implements ProduceApi {
		@Override
		public boolean produce(String data) {
			System.out.println("produce TOYOTA [" + data + "]");
			return false;
		}
	}
}
