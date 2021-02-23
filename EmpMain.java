package com.employee;
import com.employee.Employee;

public class EmpMain {

	public static void main(String[] args) {
                int Dmart_WagePerHr = 200;
                int Dmart_FullDayHr = 10;
                int Dmart_PartTimeHr = 6;
                int Dmart_workDaysLimit = 26;
                int Dmart_workHrsLimit = 130;

				Employee Dmart = new Employee(Dmart_WagePerHr, Dmart_FullDayHr,
                       Dmart_PartTimeHr, Dmart_workDaysLimit, Dmart_workHrsLimit );
				
				System.out.println("Welcome to Employee Wage Computation Program");
                while(!Dmart.workingDayExceeded() && !Dmart.workingHrExceeded())    
                    Dmart.calculateDailyWage();
                System.out.println("Monthly wage of Dmart Employee = " + Dmart.salary);
	}

}

