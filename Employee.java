package com.employee;

public class Employee {
	static short IS_PRESENT;
	
	static {
		IS_PRESENT=1;
	}
	
	public int checkAttendance() {
		short empCheck = (short)((Math.random() * 10)%2);
		if(empCheck == IS_PRESENT)
			return 1;
		else
			return 0;
	}
}

