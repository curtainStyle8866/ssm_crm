package com.itheima.array;

public class Array {
	public static void main(String[] args) {
		int[] arr={1,3,5};
		System.out.println(getIndex(arr, 5));
	}
	public static int getIndex(int[] arr,int key){
		int min,max,mid;
		min=0;
		max=arr.length-1;
		while(min<=max){
		mid=(max+min)>>1;
		if(key>arr[mid]){
			min=mid+1;
		}else if(key<arr[mid]){
			max=mid-1;
		}else{
			return mid;
		}
		}
		return -1;
		
	}
}
