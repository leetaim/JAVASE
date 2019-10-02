package sort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Sort {

	public static void main(String[] args) {

		int[] array = doGetArray();
		System.out.println(Arrays.toString(array));
		System.out.println("1.冒泡 2.简单选择排序 3.简单插入排序 4.快速排序 5.希尔排序 6.堆排序");
		System.out.println("请输入:");

		@SuppressWarnings("resource")
		int scan = new Scanner(System.in).nextInt();
		switch (scan) {
		case 1:
			doBuddleSort(array);
			break;
		case 2:
			doSelectSort(array);
			break;
		case 3:
			doInsertSort(array);
			break;
		case 4:
			doQuickSort(array,0,array.length-1);
			break;
		case 5:
			doShellSort(array);
			break;
		case 6:
			System.out.println("--无--");
			break;
		}
		System.out.println(Arrays.toString(array));
	}

	public static void doBuddleSort(int[] array) {
		boolean flag = true;
		for(int i=0;i<array.length-1 && flag;i++) {
			flag = false;
			for(int j=array.length-1;j>i;j--) {
				if(array[j]<array[j-1]) {
					int temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
					flag = true;
				}
			}
		}
	}

	public static void doInsertSort(int[] array) {
		for(int i=1;i<array.length;i++) {
			int temp = array[i];
			int j = i-1;
			while(j>=0 && array[j]>temp) {
				array[j+1] = array[j];
				j--;
			}
			array[++j] = temp;
		}
	}

	public static void doSelectSort(int[] array) {
		for(int i=0;i<array.length-1;i++) {
			int min = i;
			for(int j=i+1;j<array.length;j++) {
				if(array[min] > array[j]) {
					min = j;
				}
			}
			if(min != i) {
				int temp = array[min];
				array[min] = array[i];
				array[i] = temp;
			}
		}
	}

	public static void doQuickSort(int[] array,int low,int high) {
		int i = low;
		int j = high;
		if(low < high) {
			int temp = array[low];
			while(i != j) {
				while(i < j && array[j] >= temp) {
					j--;
				}
				array[i] = array[j];
				while(i < j && array[i] <= temp) {
					i++;
				}
				array[j] = array[i];
			}
			array[i] = temp;
			System.out.println(Arrays.toString(array));
			doQuickSort(array,low,i-1);
			doQuickSort(array,i+1,high);
		}
	}

	public static void doShellSort(int[] array) {
		int gap = array.length;
		while(gap > 0) {
			for(int i=gap;i<array.length;i++) {
				int temp = array[i];
				int j = i-gap;
				while(j >= 0 && temp < array[j]) {
					array[j+gap] = array[j];
					j = j-gap;
				}
				array[j+gap] = temp;
			}
			gap = gap>>1;
		}
	}
	
	public static void doHeapSort() {
		
	}
	
	private static int[] doGetArray() {
		int length = new Random().nextInt(10)+1;
		int[] array = new int[length];
		for(int i=0;i<length;i++) {
			array[i] = new Random().nextInt(100)+1;
		}
		return array;
	}

}
