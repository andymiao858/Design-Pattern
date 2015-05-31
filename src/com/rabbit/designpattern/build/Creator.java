package com.rabbit.designpattern.build;

import com.rabbit.designpattern.build.Product.*;

public class Creator {
	
	public static abstract class ExportOperation{
		
		public void export(String data){
			ExportFileApi api = factoryMethod();
			api.export(data);
		};
		
		public abstract ExportFileApi factoryMethod();
	}
	
	
	public static class ExportDBOperation extends ExportOperation{
		@Override
		public ExportFileApi factoryMethod() {
			return new ExportDB();
		}
	}
	
	
	public static class ExportTxtOperation extends ExportOperation{
		@Override
		public ExportFileApi factoryMethod() {
			return new ExportTxt();
		}
	}

}
