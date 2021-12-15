package com.seleneiumlearn;

public class UseEmp {

	public static void main(String[] args) {
		
		EmpExampleWithFinalizeAndGarbageCollectorCall e = new EmpExampleWithFinalizeAndGarbageCollectorCall(24,"Gourav");
		EmpExampleWithFinalizeAndGarbageCollectorCall e1 = new EmpExampleWithFinalizeAndGarbageCollectorCall(40,"Jain");
		EmpExampleWithFinalizeAndGarbageCollectorCall e2 = new EmpExampleWithFinalizeAndGarbageCollectorCall(50,"Kumar");
		e.show();
		e1.show();
		e2.show();
		e.showNextID();
		e1.showNextID();
		e2.showNextID();
		
		{
			EmpExampleWithFinalizeAndGarbageCollectorCall x = new EmpExampleWithFinalizeAndGarbageCollectorCall(26,"Ravi");
			EmpExampleWithFinalizeAndGarbageCollectorCall y = new EmpExampleWithFinalizeAndGarbageCollectorCall(89,"Kavi");
			x.show();
			y.show();
			x.showNextID();
			y.showNextID();
			//steps to call finalize and GC
			x=y=null;
			System.gc();
			System.runFinalization();
			//Above 3Steps will call Garbage COllector and run finallize we defined in our class.
		}
	e.showNextID();	
	}

}
