package com.rabbit.designpattern.build;

import java.io.IOException;
import java.util.Properties;

import com.rabbit.designpattern.build.Product.ExportFileApi;

public class SimpleFactory2 {

	public static ExportFileApi createApi(){
		
		Properties prop = new Properties();
		try {
			prop.load(SimpleFactory2.class.getClassLoader().getResourceAsStream("impl.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String targetClass = prop.getProperty("targetClass");
		try {
			return (ExportFileApi)Class.forName(targetClass).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 	
		
		throw new RuntimeException("can not find target class [" + targetClass + "]");
	}
	
	public static void main(String[] args){
		ExportFileApi api = SimpleFactory2.createApi();
		api.export("Hello Rabbit");
	}
	
}
