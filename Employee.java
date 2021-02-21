package com.employee;

public class Employee {
	static short IS_PRESENT;
	static short IS_FULL_TIME;
	static short IS_PART_TIME;
	
	static int WAGE_PER_HR;
	static int FULL_DAY;
	static int PART_TIME_HR;
    
	int dailyPayment;
	
	static {
		IS_PRESENT=1;
		IS_FULL_TIME=1;
		IS_PART_TIME=0;
		FULL_DAY=8;
		PART_TIME_HR=8;
		
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
            int jobTime = (int)(Math.random() * 10)%2;
            if(jobTime == IS_FULL_TIME) 
                dailyPayment = FULL_DAY * WAGE_PER_HR;
            else
                dailyPayment = PART_TIME_HR * WAGE_PER_HR; 
        }
        else{
            System.out.println("Employee is absent");
        }
        System.out.println("Daily Payment is : " + dailyPayment);
    }
}
