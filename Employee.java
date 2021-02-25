package com.employee;
import java.util.Random;

public class Employee {
	public static final short IS_FULL_TIME = 1;
	public static final short IS_PART_TIME = 2;
    public static final short IS_PRESENT = 1;

	
	private int WAGE_PER_HR;
	private int FULL_DAY;
	private int PART_TIME_HR;
    
	private int TOT_WORKDAYS_LIMIT;
	private int TOT_WORKING_HRS_LIMIT;

	private int hrsWorked;
	private int totDaysWorked;
	private int dailyPayment;
    private int salary;
    
	
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
				        dailyPayment = FULL_DAY * WAGE_PER_HR;
                        hrsWorked += FULL_DAY;
                        totDaysWorked++;
				        break;
		        case IS_PART_TIME:
				        dailyPayment = PART_TIME_HR* WAGE_PER_HR;
                        hrsWorked += PART_TIME_HR;
                        totDaysWorked++;
				        break;
		
		        }
        }
        else{
            dailyPayment = 0;
        }
        	salary += dailyPayment;
    }
    
    public boolean workingDayExceeded(){
        return totDaysWorked >= TOT_WORKDAYS_LIMIT;  
    }

    public boolean workingHrExceeded(){
        return hrsWorked >= TOT_WORKING_HRS_LIMIT;
    }
    public int getTotWorkingHrs(){
        return hrsWorked;
    }
    public int getTotWorkingDays(){
        return totDaysWorked;
    }
    public int getSalary(){
        return salary;
    }

}
