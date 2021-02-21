package com.employee;

public class Employee {
	static short IS_PRESENT;
	
	static int WAGE_PER_HR;
	static int FULL_DAY;
	
	int dailyPayment;
	
	static {
		IS_PRESENT=1;
		FULL_DAY=8;
		
		WAGE_PER_HR=20;
	}
	
	Employee(){
		dailyPayment=0;
	}
	
	public int checkAttendance() {
		short empCheck = (short)((Math.random() * 10)%2);
		if(empCheck == IS_PRESENT)
			return 1;
		else
			return 0;
	}
	
	public void calculateDailyWage() {
        if(checkAttendance()==1){
            System.out.println("Employee is present");
            dailyPayment = FULL_DAY * WAGE_PER_HR;
        }
        else{
            System.out.println("Employee is absent");
        }
        System.out.println("Daily Payment is : " + dailyPayment);
    }
}
