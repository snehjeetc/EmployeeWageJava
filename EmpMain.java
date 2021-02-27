package com.employee;
import com.employee.Employee;

public class EmpMain {

	public static void main(String[] args) {
        //Taking dummy 4 Employee Inputs
        //--------------------------------------------------------------------
        int wagePerHr[] = {200, 300, 400, 150};
        int FullDayHr[] = {8, 10, 7, 9};
        int PartTimeHr[] = {4, 5, 3, 5};
        int workDaysLimit[] = {20, 15, 26, 21};
        int workHrsLimit[] = {120, 140, 150, 160};
        String companyNames[] = {"Dmart", "Reliance", "ShopStop", "BigBazar"};
        int numberOfEmployees = 4;
        EmployeeWageBuilder eb = new EmployeeWageBuilder();
        for(int i = 0; i < numberOfEmployees; i++){
            Employee emp = new Employee(wagePerHr[i], FullDayHr[i], 
                    PartTimeHr[i], workDaysLimit[i], workHrsLimit[i]);
            eb.addCompany(companyNames[i], emp);
        }
        //--------------------------------------------------------------------

        eb.calculateMonthlyWage();
		System.out.println("Printing All company monthly wage:");
		eb.printMonthlyWageOfEmployee();

        //Removing a company 
        String name = "ShopStop";
		eb.printCompany(name);
		System.out.println("Removing " + name);
		eb.remove(name);
        System.out.println("Company name: " + name);
        eb.printCompany(name);
        //--------------------------------------------------------------------
        
        
		System.out.println("Printing All company monthly wage:");
		eb.printMonthlyWageOfEmployee();
		
		eb.printTheEmployeeList();

        //--------------------------------------------------------------------
        //Adding a company
		name = "Left";
		Employee emp = new Employee(100, 6, 3, 16, 80);
		eb.addCompany(name, emp);
		eb.calculateMonthlyWage();
		eb.printMonthlyWageOfEmployee();
        //--------------------------------------------------------------------
	}

}
