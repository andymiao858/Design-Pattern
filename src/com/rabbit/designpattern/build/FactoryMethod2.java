package com.rabbit.designpattern.build;

import com.rabbit.designpattern.build.Creator.*;
import com.rabbit.designpattern.build.Product.CAR;
import com.rabbit.designpattern.build.Product.ProduceApi;

public class FactoryMethod2 {
	
	
	public static ManuFactory createApi(CAR type){
		if(type == CAR.BMW){
			return new BMWManuFactory();
		}else if(type == CAR.TOYOTA){
			return new ToyotaManuFactory();
		}else{
			throw new IllegalArgumentException();
		}
	}
	
	public static void main(String[] args){
		ManuFactory operation = FactoryMethod2.createApi(CAR.BMW);
		ProduceApi api = operation.factoryMethod();
		api.produce("Hello Rabbit");
		
		operation.produce("Hello Rabbit");
	}

}
