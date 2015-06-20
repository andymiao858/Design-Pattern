package com.rabbit.datastructure.order.sort;

public class QuickSort {

	private static final int[] number = new int[] { 4, 10, 7, 50, 33, 66, 7,
			23, 30, 44 };

	public static void quickSort(int start, int end, int[] a) {
		int temp = a[start];
		int i = start;
		int j = end;
		if (start >= end) {
			return;
		}
		while (i < j) {
			while (a[j] >= temp && j > i) {
				j--;
			}
			if (i < j) {
				a[i] = a[j];
				i++;
			}
			while (a[i] <= temp && i < j) {
				i++;
			}
			if (i < j) {
				a[j] = a[i];
				j--;
			}
		}
		a[i] = temp;
		quickSort(start, i - 1, a);
		quickSort(i + 1, end, a);

	}

	public static void print(int[] a) {
		for (int element : a) {
			System.out.print(element + ", ");
		}
	}

	public static void main(String[] args) {
		print(number);
		quickSort(0, number.length - 1, number);
		System.out.println();
		print(number);
	}

}
