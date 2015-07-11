package com.rabbit.designpattern.behavioral;

import java.util.Arrays;
import java.util.List;

public class TemplateMethod1 {
	
	
	public static void main(String[] args) {
		Integer[] array = {4, 7, 1, 3, 8, 5, 22, 14, 3};
		List<Integer> list = Arrays.asList(array);
		for(Integer i : list){
			System.out.println(i);
		}
		SortTemplate<Integer> template = new SortInteger();
		template.sort(list);
		System.out.println("=======================");
		for(Integer i : list){
			System.out.println(i);
		}
	}

	
	public static abstract class SortTemplate<T>{
		
		public final void sort(List<T> list){
			T temp = null;
			for(int i = 0; i < list.size() - 1; i++){
				for(int j = list.size() - 2; j >= i; j--){
					if(compare(list.get(j), list.get(j + 1))){
						temp = list.get(j + 1);
						list.set(j + 1, list.get(j));
						list.set(j, temp);
					}
				}
			}
		}
		
		public abstract boolean compare(T t1, T t2);
	}
	
	public static class SortInteger extends SortTemplate<Integer>{

		@Override
		public boolean compare(Integer t1, Integer t2) {
			return t1 > t2;
		}

	}
	
}
