package com.itheima.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Array5 {

	public static void main(String[] args) {
		int arr[]={1,1,51,6,6,8,8,5,25};
		System.out.println(Arrays.toString(quChong(arr)));

	} 
	public static int[] paixu(int arr[]){
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-1-i; j++) {
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		return arr;
	}
	public static Object[] quChong(int[] arr){
		List<Integer> list=new ArrayList<>();
		for (int i = 0; i < arr.length-1; i++) {
			if(!list.contains(arr[i])){
				list.add(arr[i]);
			}
		}
		Collections.sort(list);
		return list.toArray();
		
	}

}
