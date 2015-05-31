package com.rabbit.designpattern.build;

import com.rabbit.designpattern.build.Product.EXPORTTYPE;
import com.rabbit.designpattern.build.Product.ExportDB;
import com.rabbit.designpattern.build.Product.ExportFileApi;
import com.rabbit.designpattern.build.Product.ExportTxt;

public class SimpleFactory1 {
		
	public static ExportFileApi createApi(EXPORTTYPE type){
		if(type == EXPORTTYPE.DB){
			return new ExportDB();
		}else if(type == EXPORTTYPE.TXT){
			return new ExportTxt();
		}else{
			throw new IllegalArgumentException();
		}
		
	}
	
	public static void main(String[] args){
		ExportFileApi api = SimpleFactory1.createApi(EXPORTTYPE.DB);
		api.export("Hello Rabbit");
	}
	
	
}
