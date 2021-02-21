package com.employee;
import com.employee.Employee;

public class EmpMain {

	public static void main(String[] args) {
				Employee e = new Employee();
				
				System.out.println("Welcome to Employee Wage Computation Program");
                for(int i=0; i<=30; i++)
                    e.calculateDailyWage();
                System.out.println("Monthly wage= " + e.salary);
	}

}

