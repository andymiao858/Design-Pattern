package com.rabbit.designpattern.build;

import com.rabbit.designpattern.build.Product.ProduceApi;
import com.rabbit.designpattern.build.Product.ProduceBMW;
import com.rabbit.designpattern.build.Product.ProduceToyota;

public class Creator {
	
	public static abstract class ManuFactory{
		
		public void produce(String data){
			ProduceApi api = factoryMethod();
			api.produce(data);
		};
		
		public abstract ProduceApi factoryMethod();
	}
	
	
	public static class BMWManuFactory extends ManuFactory{
		@Override
		public ProduceApi factoryMethod() {
			return new ProduceBMW();
		}
	}
	
	
	public static class ToyotaManuFactory extends ManuFactory{
		@Override
		public ProduceApi factoryMethod() {
			return new ProduceToyota();
		}
	}
	
}
