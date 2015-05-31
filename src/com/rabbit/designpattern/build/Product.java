package com.rabbit.designpattern.build;


public class Product {
	public enum EXPORTTYPE {
		DB, TXT
	}

	public static interface ExportFileApi {
		public boolean export(String data);
	}

	public static class ExportDB implements ExportFileApi {

		@Override
		public boolean export(String data) {
			System.out.println("export DB [" + data + "]");
			return true;
		}

	}

	public static class ExportTxt implements ExportFileApi {
		@Override
		public boolean export(String data) {
			System.out.println("export Txt [" + data + "]");
			return false;
		}
	}
}
