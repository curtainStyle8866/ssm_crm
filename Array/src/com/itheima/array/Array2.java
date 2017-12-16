package com.itheima.array;

import java.util.Arrays;

public class Array2 {

	public static void main(String[] args) {
		int[] arr={1,3,5,7,9};
		reverse(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void reverse(int[] arr){
		for(int start=0,end = arr.length-1;start<end;start++,end--){
			int temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
		}
	}

}
