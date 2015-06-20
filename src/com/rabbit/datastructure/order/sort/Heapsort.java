package com.rabbit.datastructure.order.sort;

public class Heapsort {
	public static void main(String[] args) {
		int[] _array = { 9, 12, 17, 30, 50, 20, 60, 65, 4, 49 };
		int n = _array.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			minHeapFixDown(_array, i, n);
		}
		for (int i = n - 1; i >= 1; i--) {
			int temp;
			temp = _array[0];
			_array[0] = _array[i];
			_array[i] = temp;
			minHeapFixDown(_array, 0, i);
		}
		for (int c = 0; c < n; c++) {
			System.out.println(_array[c]);
		}

	}

	private static void minHeapFixDown(int a[], int i, int n) {
		int temp, j;
		temp = a[i];
		j = 2 * i + 1;
		while (j < n) {
			if (j + 1 < n && a[j + 1] < a[j])
				j++;

			if (a[j] >= temp)
				break;

			a[i] = a[j];
			i = j;
			j = 2 * i + 1;

		}
		a[i] = temp;
	}

}