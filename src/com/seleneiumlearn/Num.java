package com.seleneiumlearn;

public class Num {

	private int a;
	private int b;

	public void set(int i, int j) {
		this.a = i;
		this.b = j;
	}

	public void swap(Num P, Num Q) {

		int x;
		x=P.a;
		P.a=Q.a;
		Q.a=x;
		x=P.b;
		P.b=Q.b;
		Q.b=x;
	}

	public void show() {
		System.out.println(a);
		System.out.println(b);
	}

}
