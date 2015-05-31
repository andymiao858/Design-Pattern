package com.rabbit.designpattern.build;

import com.rabbit.designpattern.build.Product.CAR;
import com.rabbit.designpattern.build.Product.ProduceBMW;
import com.rabbit.designpattern.build.Product.ProduceApi;
import com.rabbit.designpattern.build.Product.ProduceToyota;

public class SimpleFactory1 {
		
	public static ProduceApi createCar(CAR type){
		if(type == CAR.BMW){
			return new ProduceBMW();
		}else if(type == CAR.TOYOTA){
			return new ProduceToyota();
		}else{
			throw new IllegalArgumentException();
		}
		
	}
	
	public static void main(String[] args){
		ProduceApi api = SimpleFactory1.createCar(CAR.BMW);
		api.produce("Hello Rabbit");
	}
	
	
}
