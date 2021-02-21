package com.employee;
import com.employee.Employee;

public class EmpMain {

	public static void main(String[] args) {
				Employee e = new Employee();
				if(e.checkAttendance()==1)
					System.out.println("Employee is present");
				else
					System.out.println("Employee is absent");
			
	}

}

