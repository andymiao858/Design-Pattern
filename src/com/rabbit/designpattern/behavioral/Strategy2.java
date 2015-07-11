package com.rabbit.designpattern.behavioral;

import java.util.ArrayList;
import java.util.List;

public class Strategy2 {

	public static void main(String[] args) {
		PriceStrategy strategy = new DailyStrategy();
		Context context = new Context();
		context.setStrategy(strategy);
		Goods goods1 = new Goods(100);
		Goods goods2 = new Goods(200);
		context.addGoods(goods1);
		context.addGoods(goods2);
		context.setCoupon(20);
		context.setFirst(true);
		System.out.println("JD Daily Price is [" + context.calcPrice() + "]");

		strategy = new June18Strategy();
		context.setStrategy(strategy);
		System.out.println("JD June 18 Price is [" + context.calcPrice() + "]");
		
	}

	public static interface PriceStrategy {
		public double calcPrice(Context context);
	}

	public static class DailyStrategy implements PriceStrategy {
		@Override
		public double calcPrice(Context context) {
			double sum = 0;
			for (Goods goods : context.getGoodsList()) {
				sum += goods.getPrice();
			}
			if (sum < Context.FREE_POST_MIN) {
				sum += Context.POSTAGE;
			}

			return sum;
		}
	}

	public static class June18Strategy implements PriceStrategy {
		@Override
		public double calcPrice(Context context) {
			double sum = 0;
			for (Goods goods : context.getGoodsList()) {
				sum += goods.getPrice();
			}
			if (sum >= 299) {
				sum -= context.getCoupon();
			}
			if(context.first){
				sum -= 5;
			}
			return sum >= 0 ? sum : 0;
		}
	}

	public static class Goods {
		private double price;

		public Goods(double price){
			this.price = price;
		}
		
		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}
	}

	public static class Context {
		private List<Goods> goodsList = new ArrayList<Goods>();
		private double coupon;
		private boolean first;
		private static final double FREE_POST_MIN = 50;
		private static final double POSTAGE = 8;

		private PriceStrategy strategy;
		
		public void setStrategy(PriceStrategy strategy) {
			this.strategy = strategy;
		}
		
		public double calcPrice(){
			return strategy.calcPrice(this);
		}
		
		public void addGoods(Goods goods) {
			goodsList.add(goods);
		}

		
		public List<Goods> getGoodsList() {
			return goodsList;
		}

		public double getCoupon() {
			return coupon;
		}

		public void setCoupon(double coupon) {
			this.coupon = coupon;
		}

		public boolean isFirst() {
			return first;
		}

		public void setFirst(boolean first) {
			this.first = first;
		}
		
	}

}
