package com.employee;
import java.util.*;

public class EmployeeWageBuilder implements EmployeeWageAPI{

	private static final short IS_FULL_TIME = 1;
    private static final short IS_PART_TIME = 2;
    private static final short IS_PRESENT = 1;
    private static final Boolean marked = true;

    private LinkedList<Employee> companyEmployeeList; 
    private Map<String, Employee> companyToEmployee;
    private Map<String, Boolean> markCompanyDone;


    public EmployeeWageBuilder(){
        companyEmployeeList = new LinkedList<Employee>();
        companyToEmployee = new HashMap<String, Employee>();
        markCompanyDone = new HashMap<String, Boolean>();
    }
    
    public void addCompany(String name, Employee emp){
        if(!companyEmployeeList.add(emp)){
            System.out.println("Failed to add.");
        }
        companyToEmployee.put(name, emp);
        markCompanyDone.put(name, false);
    }
    public int checkAttendance() {
		short empCheck = (short)((Math.random() * 10)%2);
		if(empCheck == IS_PRESENT)
			return 1;
		else
			return 0;
	}

    public void remove(String name){
        Employee emp = companyToEmployee.remove(name);
        if( emp == null){
            System.out.println(name + " not present!");
            return;
        }
        companyEmployeeList.remove(emp);
        markCompanyDone.remove(name);
    }
    
    public Employee search(String name){
        return companyToEmployee.get(name);
    }

    public void printCompany(String name){
        Employee emp = companyToEmployee.get(name);
        if(emp == null){
            System.out.println(name + " not present!");
            return;
        }
        System.out.println(name + ": " + emp.getSalary());
    }

    public boolean isEmpty(){
        return companyEmployeeList.size() == 0;
    }

    public void printMonthlyWageOfEmployee(){
        for(Map.Entry<String, Employee> entry : companyToEmployee.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue().getSalary());
        }
    }

    public void reset(){
        for(Map.Entry<String, Employee> entry : companyToEmployee.entrySet()){
            entry.getValue().setSalary(0);
            markCompanyDone.put(entry.getKey(), false);
        }
    }

    public void reset(String companyName){
        Employee emp = companyToEmployee.get(companyName);
        if(emp == null){
            System.out.println(companyName + " not present!");
            return;
        }
        emp.setSalary(0);
        markCompanyDone.put(companyName, false);
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
        for(Map.Entry<String, Employee> entry : companyToEmployee.entrySet()){
        if(!markCompanyDone.get(entry.getKey()).equals(marked)){
            Employee emp = entry.getValue();
            
            while(!emp.workingDayExceeded() && !emp.workingHrExceeded()){  
                    calculateDailyWage(emp);
                }
            markCompanyDone.put(entry.getKey(), true);
        	}
        }
    }
    
    @Override
    public int getTotalWage(String company){
        Employee emp = companyToEmployee.get(company);
        if(emp == null)
            return -1;
        return emp.getSalary();
    }
    public void printTheEmployeeList() {
    	ListIterator<Employee> listIterator = companyEmployeeList.listIterator();
    	while(listIterator.hasNext()) {
    		System.out.println(listIterator.next());
    	}
    }
}
