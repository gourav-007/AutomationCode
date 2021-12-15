package com.seleneiumlearn;

public class MyMath {

	public int calculate(int[] brr) {
		int sum=0;
		for(int i=0;i<brr.length;i++) {
			sum = sum + brr[i];
		}
		return sum;
	}

}
