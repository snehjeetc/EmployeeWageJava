package com.employee;
import com.employee.Employee;

public class EmpMain {

	public static void main(String[] args) {
				Employee e = new Employee();
				
				System.out.println("Welcome to Employee Wage Computation Program");
                while(!e.workingDayExceeded() && !e.workingHrExceeded())    
                    e.calculateDailyWage();
                System.out.println("Monthly wage= " + e.salary);
	}

}

