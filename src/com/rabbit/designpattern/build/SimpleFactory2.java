package com.rabbit.designpattern.build;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.rabbit.designpattern.build.Product.ProduceApi;

public class SimpleFactory2 {

	public static ProduceApi createApi(){
		
		Properties prop = new Properties();
		InputStream is = null;
		try {
			is = SimpleFactory2.class.getClassLoader().getResourceAsStream("impl.properties");
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String targetClass = prop.getProperty("targetClass");
		try {
			return (ProduceApi)Class.forName(targetClass).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally{
			if(is != null){
				try{
					is.close();
				}catch(Exception e){
					
				}
			}
		}
		
		throw new RuntimeException("can not find target class [" + targetClass + "]");
	}
	
	public static void main(String[] args){
		ProduceApi api = SimpleFactory2.createApi();
		api.produce("Hello Rabbit");
	}
	
}
