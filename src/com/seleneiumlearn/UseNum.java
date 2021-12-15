package com.seleneiumlearn;

public class UseNum {

	public static void main(String[] args) {

		Num N1 = new Num();
		N1.set(10, 20);
		N1.show();

		Num N2 = new Num();
		N2.set(5, 7);
		N2.show();

		Num N3 = new Num();
		N3.swap(N1, N2);
		N1.show();
		N2.show();

	}

}
