package com.seleneiumlearn;

import java.util.Scanner;

public class SampleClass {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String text = sc.next();

		sc.close();

		String words[] = text.split("\\s");
		String rev=" ";

		for(int i=0;i<text.length();i++) {
			String word = words[i];
			String rev_string = " ";
			for(int j=word.length()-1;j>=0;j--) {
				rev_string=rev_string+word.charAt(j);
			}

			rev = rev + rev_string +" ";

		}

		System.out.println(rev);
	}

}
