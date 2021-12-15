package com.seleneiumlearn;

public class EmpExampleWithFinalizeAndGarbageCollectorCall {
	
	private int id;
	private String name;
	private int age;
	private static int nextID=1;
	
	public EmpExampleWithFinalizeAndGarbageCollectorCall(int age,String name) {
		this.age = age;
		this.name = name;
		id=nextID++;
	}
	
	public void show() {
		System.out.println(id+" "+name+" "+age);
	}
	
	public void showNextID() {
		System.out.println("Employee NextID will be: "+nextID);
	}
	
	protected void finalize() {
		--nextID;
	}
}
