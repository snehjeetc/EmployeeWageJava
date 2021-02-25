package com.employee;
import com.employee.Employee;

public class EmpMain {

	public static void main(String[] args) {
        int wagePerHr[] = {200, 300, 400, 150};
        int FullDayHr[] = {8, 10, 7, 9};
        int PartTimeHr[] = {4, 5, 3, 5};
        int workDaysLimit[] = {20, 15, 26, 21};
        int workHrsLimit[] = {120, 140, 150, 160};
        String companyNames[] = {"Dmart", "Reliance", "ShopStop", "BigBazar"};
        int numberOfEmployees = 4;
        for(int i = 0; i < numberOfEmployees; i++){
            Employee emp = new Employee(wagePerHr[i], FullDayHr[i], 
                    PartTimeHr[i], workDaysLimit[i], workHrsLimit[i]);
            EmployeeWageBuilder.addCompany(companyNames[i], emp);
        }
        EmployeeWageBuilder.calculateMonthlyWage();
        String name = "ShopStop";
		EmployeeWageBuilder.printCompany(name);
		System.out.println("Removing " + name);
		EmployeeWageBuilder.remove(name);
		System.out.println("Printing All company monthly wage:");
		EmployeeWageBuilder.printMonthlyWageOfEmployee();
        EmployeeWageBuilder.printMonthlyWageOfEmployee();
	}

}

