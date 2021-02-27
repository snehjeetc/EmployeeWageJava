package com.employee;

public class Employee{	

    private int WAGE_PER_HR;
    private int FULL_DAY;
    private int PART_TIME_HR;
    
    private int TOT_WORKDAYS_LIMIT;
    private int TOT_WORKING_HRS_LIMIT;

    private int hrsWorked;
    private int totDaysWorked;
    private int salary;

    Employee(int wagePerHr, int FullDayHr, int PartTimeHr, int workDaysLimit, 
            int workHrsLimit){
        hrsWorked = 0;
        totDaysWorked = 0;
        salary = 0;
        WAGE_PER_HR = wagePerHr;
        FULL_DAY = FullDayHr;
        PART_TIME_HR = PartTimeHr;
        TOT_WORKDAYS_LIMIT = workDaysLimit;
        TOT_WORKING_HRS_LIMIT = workHrsLimit;
    }
        
    public boolean workingDayExceeded(){
        return totDaysWorked >= TOT_WORKDAYS_LIMIT;  
    }

    public boolean workingHrExceeded(){
        return hrsWorked >= TOT_WORKING_HRS_LIMIT;
    }

    //------------------------------------------------------
    //Getters
    public int getTotWorkingHrs(){
        return hrsWorked;
    }
    public int getTotWorkingDays(){
        return totDaysWorked;
    }
    public int getSalary(){
        return salary;
    }
    public int getFullDayHr(){
        return FULL_DAY;
    }
    public int getPartTimeHr(){
        return PART_TIME_HR;
    }
    public int getWagePerHr() {
    	return WAGE_PER_HR;
    }
    //------------------------------------------------------
    
    //------------------------------------------------------
    //Setters
    public void setSalary(int salary){
        this.salary = salary;
    }

    public void setWorkingHrsLimit(int workHrsLimit){
        this.TOT_WORKING_HRS_LIMIT = workHrsLimit;
    }
    
    public void setHoursWorked(int hrs){
        hrsWorked += hrs;
    }
    
    public void increaseDaysWorked(){
        totDaysWorked++;
    }

    public void setWorkingDaysLimit(int workingDaysLimit){
        this.TOT_WORKDAYS_LIMIT = workingDaysLimit;
    }
    
    public void setPartTimeHr(int partTimeHr){
        this.PART_TIME_HR = partTimeHr;
    } 

    public void setFullTimeHr(int fullTimeHr){
        this.FULL_DAY = fullTimeHr;
    }

    public void setWagePerHr(int wagePerHr){
        this.WAGE_PER_HR = wagePerHr;
    }
    //------------------------------------------------------
    
    @Override
    public String toString() {
    	return "Hours Worked: " + hrsWorked + " " + 
    			"Days Worked: "	+ totDaysWorked+ " " + 
    			"Salary: " + salary;
    }
}
