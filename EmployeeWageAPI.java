package com.employee;

public interface EmployeeWageAPI{
    void calculateDailyWage(Employee emp); 
    void calculateMonthlyWage();
    int getTotalWage(String company); 
}
