package com.employee;
import java.util.Random;

public class Employee {
	static final short IS_FULL_TIME = 1;
	static final short IS_PART_TIME = 2;
    static final short IS_PRESENT = 1;
	
	int WAGE_PER_HR;
	int FULL_DAY;
	int PART_TIME_HR;
    
	int TOT_WORKDAYS_LIMIT;
	int TOT_WORKING_HRS_LIMIT;

	int hrsWorked;
	int totDaysWorked;
	int dailyPayment;
    int salary;
	
	Employee(int wagePerHr, int FullDayHr, int PartTimeHr, int workDaysLimit, 
            int workHrsLimit){
		dailyPayment = 0;
		hrsWorked = 0;
		totDaysWorked = 0;
        salary = 0;
        WAGE_PER_HR = wagePerHr;
        FULL_DAY = FullDayHr;
        PART_TIME_HR = PartTimeHr;
        TOT_WORKDAYS_LIMIT = workDaysLimit;
        TOT_WORKING_HRS_LIMIT = workHrsLimit;
	}
    
    public int checkAttendance() {
		short empCheck = (short)((Math.random() * 10)%2);
		if(empCheck == IS_PRESENT)
			return 1;
		else
			return 0;
	}

	public void calculateDailyWage() {
        Random rand = new Random();
		int empCheck= checkAttendance();
        if(empCheck == 1){
            int jobType = rand.nextInt(2) + 1;
		    switch(jobType) {
		        case IS_FULL_TIME:	
				        System.out.println("Employee is present");
				        dailyPayment = FULL_DAY * WAGE_PER_HR;
                        hrsWorked += FULL_DAY;
                        totDaysWorked++;
				        break;
		        case IS_PART_TIME:
				        System.out.println("Employee is present");
				        dailyPayment = PART_TIME_HR* WAGE_PER_HR;
                        hrsWorked += PART_TIME_HR;
                        totDaysWorked++;
				        break;
		
		        }
        }
        else{
            System.out.println("Employee is absent");
            dailyPayment = 0;
        }
        	salary += dailyPayment;
		System.out.println("Daily Payment: " + dailyPayment);
    }
    
    public boolean workingDayExceeded(){
        return totDaysWorked >= TOT_WORKDAYS_LIMIT;  
    }

    public boolean workingHrExceeded(){
        return hrsWorked >= TOT_WORKING_HRS_LIMIT;
    }
}
