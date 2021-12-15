package com.seleneiumlearn;

public class UseMyMath {

	public static void main(String[] args) {
		
		MyMath obj = new MyMath();
		int [] arr = {10,20,30,40,50};
		int result = obj.add(arr);
		System.out.println("Sum is "+result);
	}

}
