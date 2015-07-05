package com.rabbit.designpattern.behavioral;

import java.util.Arrays;
import java.util.List;

public class TemplateMethod2 {
	public static void main(String[] args) {
		Integer[] array = {4, 7, 1, 3, 8, 5, 22, 14, 3};
		List<Integer> list = Arrays.asList(array);
		for(Integer i : list){
			System.out.println(i);
		}
		SortTemplate template = new SortTemplate();
		template.sort(list, new Comparator<Integer>() {

			@Override
			public boolean compare(Integer t1, Integer t2) {
				return t1 > t2;
			}
		});
		
		System.out.println("=======================");
		for(Integer i : list){
			System.out.println(i);
		}
	}

	
	public static class SortTemplate{
		
		public final <T> void sort(List<T> list, Comparator<T> comparator){
			T temp = null;
			for(int i = 0; i < list.size() - 1; i++){
				for(int j = list.size() - 2; j >= i; j--){
					if(comparator.compare(list.get(j), list.get(j + 1))){
						temp = list.get(j + 1);
						list.set(j + 1, list.get(j));
						list.set(j, temp);
					}
				}
			}
		}
		
	}
	
	public static interface Comparator<T>{
		
		public boolean compare(T t1, T t2);
		
	}
	
}
