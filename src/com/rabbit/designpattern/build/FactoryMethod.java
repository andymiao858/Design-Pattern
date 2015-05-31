package com.rabbit.designpattern.build;

import com.rabbit.designpattern.build.Creator.ExportDBOperation;
import com.rabbit.designpattern.build.Creator.ExportOperation;
import com.rabbit.designpattern.build.Creator.ExportTxtOperation;
import com.rabbit.designpattern.build.Product.ExportFileApi;

public class FactoryMethod {
	
	public static void main(String[] args){
		
		// Application 1
		ExportOperation db = new ExportDBOperation();
		db.export("hello rabbit");
		
		// Application 2
		ExportOperation txt = new ExportTxtOperation();
		ExportFileApi api = txt.factoryMethod();
		api.export("hello rabbit");
	}

}
