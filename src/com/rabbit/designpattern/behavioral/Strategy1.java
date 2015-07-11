package com.rabbit.designpattern.behavioral;

public class Strategy1 {

	public static void main(String[] args) {
		PriceStrategy strategy = new DailyStrategy();
		Context context = new Context(strategy);
		System.out.println("JD Daily Price is [" + context.calcPrice(1000) + "]");
		strategy = new June18Strategy();
		context = new Context(strategy);
		System.out.println("JD June 18 Price is [" + context.calcPrice(1000) + "]");
	}
	
	public static interface PriceStrategy{
		public double calcPrice(double price);
	}

	public static class DailyStrategy implements PriceStrategy{
		@Override
		public double calcPrice(double price) {
			return price;
		}
	}
	
	public static class June18Strategy implements PriceStrategy{
		@Override
		public double calcPrice(double price) {
			return 0.8 * price;
		}
	}
	
	public static class Context{
		private PriceStrategy strategy;
		
		public Context(PriceStrategy strategy){
			this.strategy = strategy;
		}
		
		public double calcPrice(double price){
			return strategy.calcPrice(price);
		}
	}
	
}
