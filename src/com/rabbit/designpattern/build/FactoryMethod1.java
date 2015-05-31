package com.rabbit.designpattern.build;

import com.rabbit.designpattern.build.Creator.BMWManuFactory;
import com.rabbit.designpattern.build.Creator.ManuFactory;
import com.rabbit.designpattern.build.Creator.ToyotaManuFactory;
import com.rabbit.designpattern.build.Product.ProduceApi;

public class FactoryMethod1 {
	
	public static void main(String[] args){
		
		// Application 1
		ManuFactory db = new BMWManuFactory();
		db.produce("hello rabbit");
		
		// Application 2
		ManuFactory txt = new ToyotaManuFactory();
		ProduceApi api = txt.factoryMethod();
		api.produce("hello rabbit");
		
	}

}
