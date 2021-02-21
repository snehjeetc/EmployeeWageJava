package com.employee;
import java.util.Random;

public class Employee {
	static final short IS_FULL_TIME=1;
	static final short IS_PART_TIME=2;
	
	static int WAGE_PER_HR;
	static int FULL_DAY;
	static int PART_TIME_HR;
    
	int dailyPayment;
    int salary;

	static {
		FULL_DAY=8;
		PART_TIME_HR=8;
		
		WAGE_PER_HR=20;
	}
	
	Employee(){
		dailyPayment=0;
        salary=0;
	}

	public void calculateDailyWage() {
        Random rand = new Random();
		int empCheck= rand.nextInt(3);
		switch(empCheck) {
		case IS_FULL_TIME:	
				System.out.println("Employee is present");
				dailyPayment = FULL_DAY * WAGE_PER_HR;
				break;
		case IS_PART_TIME:
				System.out.println("Employee is present");
				dailyPayment = PART_TIME_HR* WAGE_PER_HR;
				break;
		default:
				System.out.println("Employee is absent");
				dailyPayment = 0;
				break;
		}
        	salary += dailyPayment;
		System.out.println("Daily Payment: " + dailyPayment);
    }
}
