package com.employee;
import java.util.Random;

public class EmployeeWageBuilder implements EmployeeWageAPI{

	public static final short IS_FULL_TIME = 1;
    public static final short IS_PART_TIME = 2;
    public static final short IS_PRESENT = 1;

    private int capacity;
    //index-> represents the next position where we have to place our object
    private int index;
    private String[] companyNamesList;
    private Employee[] companyEmployeesList; 

    public EmployeeWageBuilder(){
        capacity = 5;
        index =0;
        companyNamesList = new String[capacity];
        companyEmployeesList = new Employee[capacity];
    }
    
    public void reserve(int requiredSize){
        if(capacity == 0){
            capacity = requiredSize;
            index++;
            companyNamesList = new String[capacity];
            companyEmployeesList = new Employee[capacity];
            return;
        }
        else{
            String[] tempNames = new String[capacity]; 
            Employee[] tempEmp = new Employee[capacity];
            
            for(int i=0; i<index; i++){
                tempNames[i] = companyNamesList[i];
                tempEmp[i] = companyEmployeesList[i];
            }

            capacity += requiredSize;
            String[] companyNamesList = new String[capacity];
            Employee[] companyEmployeesList = new Employee[capacity];

            for(int i=0; i<index; i++){
                companyNamesList[i] = tempNames[i];
                companyEmployeesList[i] = tempEmp[i];
            }
        }
    }

    public void addCompany(String name, Employee emp){
        if(index == -1)             //No array has been created yet
            reserve(5);
        else if(index == capacity)
            reserve(2*capacity + 1);
        
        companyNamesList[index] = name;
        companyEmployeesList[index] = emp;
        index++;
    }
    public int checkAttendance() {
		short empCheck = (short)((Math.random() * 10)%2);
		if(empCheck == IS_PRESENT)
			return 1;
		else
			return 0;
	}

    public void remove(String name){
        if(index == -1){
            System.out.println("Employee Wage Builder is empty");
            return;
        }
        int atIndex = search(name);
        if(atIndex == -1){
            System.out.println(name + " Employee not found!");
            return;
        }
        for(int i = atIndex; i < index-1; i++){
            companyNamesList[i] = companyNamesList[i+1];
            companyEmployeesList[i] = companyEmployeesList[i+1];
        }
        index--;
    }
    
    public int search(String name){
        if(isEmpty()){
            return -1;
        }
        for(int i=0; i<index; i++){
            if(name.equals(companyNamesList[i]))
                return i;
        }
        return -1;
    }

    public void printCompany(String name){
        int atIndex = search(name);
        if( atIndex == -1)
            return;
        System.out.println(name + ": " + 
                companyEmployeesList[atIndex].getSalary());
    }

    public boolean isEmpty(){
        return index == -1 || index == 0;
    }

    public void printMonthlyWageOfEmployee(){
        for(int i=0; i<index; i++){
            System.out.println(companyNamesList[i] + ": " + 
                    companyEmployeesList[i].getSalary());
        }
    }

    @Override
	public void calculateDailyWage(Employee emp) {
        Random rand = new Random();
		int empCheck= checkAttendance();
        if(empCheck == IS_PRESENT){
            int jobType = rand.nextInt(2) + 1;
            int dailyPayment;
		    switch(jobType) {
		        case IS_FULL_TIME:	
				        dailyPayment = emp.getFullDayHr() * emp.getWagePerHr();
                        emp.setHoursWorked(emp.getFullDayHr());
                        emp.increaseDaysWorked();
                        emp.setSalary(emp.getSalary() + dailyPayment);
				        break;
		        case IS_PART_TIME:
				        dailyPayment = emp.getPartTimeHr() *emp.getWagePerHr();
                        emp.setHoursWorked(emp.getPartTimeHr());
                        emp.increaseDaysWorked();
                        emp.setSalary(emp.getSalary() + dailyPayment);
				        break;
		
		        }
        }
    }

    @Override
    public void calculateMonthlyWage(){
        for(int i=0; i<index; i++){
        while(!companyEmployeesList[i].workingDayExceeded() && 
                !companyEmployeesList[i].workingHrExceeded())    
            calculateDailyWage(companyEmployeesList[i]);
        }
    }
    
    @Override
    public int getTotalWage(String company){
        int atIndex = search(company);
        if(atIndex == -1)
            return -1;
        return companyEmployeesList[atIndex].getSalary();
    }
}
