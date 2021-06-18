package com;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UseEmployee{
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menuSelection=0;
		Scanner sca = new Scanner(System.in);

		EmployeeServiceImpl solution = new EmployeeServiceImpl();
		
		while(menuSelection != 6) {
			//menuDisplay();
			menuSelection=optionSelected();
			switchQuestions(menuSelection, solution,sca);
		}

	}//Include a try catch for one more or more for unexpected user inpput
public static void switchQuestions(int menuSelection,EmployeeServiceImpl solution,Scanner sca) {
	switch(menuSelection) {
	case 1:
		 choice1(solution);
		 break;
	case 2://calculate Employee salary
		 choice2(solution,sca);
		 break;
		 
	case 3://Find employee
		 choice3(solution,sca);
		 break;
	case 4://Update employee
		choice4(solution,sca);
		break;
	case 5:
		choice5(solution,sca);
		break; 
	case 6:
		System.out.println("Program has ended");
		break;
	default:
		System.out.println("Error"+menuSelection 
				+"is not an option");
}	
}
public static void choice1(EmployeeServiceImpl solution) {
		System.out.println("All Employee's listed:");
		 solution.displayAllEmployee();
}

public static void choice2(EmployeeServiceImpl solution,Scanner sca) {
    try {
	System.out.println("Please insert the Employee Number: "); 
    int EmployeeNum2 = sca.nextInt();
	
	Employee su= solution.list.stream()
            .filter( emp -> emp.getEmployeeNo() == EmployeeNum2)
            .findFirst()
            .orElse(null);
	 System.out.println("Employee Salary for "+solution.findByEmployeeNo(EmployeeNum2).empName+"for the year is:"+solution.calculateYearlySalary(su));
    }catch(Exception e) {
    	System.out.println("not the employee");
    }
  }

public static void choice3(EmployeeServiceImpl solution,Scanner sca) {
	//Scanner scanObject = new Scanner(System.in);
	try {
	System.out.println("Please insert the Employee Number: "); 
	 int EmployeeNum = sca.nextInt();
	
	System.out.println(solution.findByEmployeeNo(EmployeeNum).toString());
	/*
	 System.out.println(solution.findByEmployeeNo(EmployeeNum)+" "
			+ "Employee Address ["+solution.findByEmployeeNo(EmployeeNum).getCity()+
			", "+solution.findByEmployeeNo(EmployeeNum).getState()+"]");
			*/
	}catch(NullPointerException e) {
		System.out.println("Error arraylist index is out of bounds");
	}
}
public static void choice4(EmployeeServiceImpl solution,Scanner sca) {
	try {
	System.out.println("Please insert the Employee Number: "); 
	int EmpNum = sca.nextInt();
	sca.nextLine();
	System.out.println("Please insert the Employee Name: "); 
	String EmpName = sca.nextLine();
	
	System.out.println("Please insert the Employee Salary: "); 
	double EmpSalary= sca.nextDouble();
	sca.nextLine();
	System.out.println("Please insert the Employee Address for State: "); 
	String EmpState= sca.nextLine();
	sca.nextLine();
	System.out.println("Please insert the Employee Address for City: "); 
	String EmpCity= sca.nextLine();
	
	solution.updateEmployee(new Employee(EmpNum,EmpName,EmpSalary,new Address(EmpCity,EmpState)));
	System.out.println(solution.findByEmployeeNo(EmpNum).toString());

	//System.out.println("Updated "+solution.toString());
	/*
	System.out.println("Updated "+solution.findByEmployeeNo(1)+" "
	+" Address [ "+solution.findByEmployeeNo(1).getState()+"
	+",  "+solution.findByEmployeeNo(1).getCity()+"]");
	*/
	}catch(InputMismatchException e) {
        System.out.println ("User Input the wrong vaule");
        sca.next();
	}catch (NumberFormatException e1) {
        System.out.println("Invalid input! You have to enter a letter not a number");
	}
	//solution.updateEmployee(new Employee(1,"kia",150.0,new Address("Los","Cali")));
	//function1(solution,EmpNum,EmpName,EmpSalary,EmpSalary,EmpCity,EmpState);
	//function1(solution,EmpNum,EmpName,EmpSalary,EmpCity,EmpState);
	//solution.updateEmployee(solution.list.get(0).setEmployeeName("Bo"));
   // System.out.println(solution.findByEmployeeNo(1));
    //System.out.println(solution.list.get(0).getEmployeeAddress());
    
}
public static void choice5(EmployeeServiceImpl solution,Scanner sca) {
	//Scanner scan = new Scanner(System.in);
	try {
	System.out.println("Please insert the Employee Number to delete: "); 
	int EmployeeNum1 = sca.nextInt();
	Employee suti = solution.list.stream()
            .filter( emp -> emp.getEmployeeNo() == EmployeeNum1)
            .findFirst()
            .orElse(null);
	//Employee suti=solution.list.get(EmployeeNum1-1);
	solution.deleteEmployee(suti);
	System.out.println("Employee List updated: ");
	//solution.displayAllEmployee();
	}catch(ArrayIndexOutOfBoundsException e) {
		System.out.println("Error arraylist index is out of bounds");
		
	}
}
public static void menuDisplay() {
		System.out.println("Please select an option:\n");
		System.out.println("1. List all employee");
		System.out.println("2. Display Yearly Salary");
		System.out.println("3. Display specific employee details");
		System.out.println("4. Modify the employee details");
		System.out.println("5. Delete an employee");
		System.out.println("6. Quit\n");	 
}

public static int optionSelected() {
	 menuDisplay();
	 @SuppressWarnings("resource")
	 Scanner scanObj = new Scanner(System.in);
	 System.out.println("Insert option: ");
	 int menuSelection = scanObj.nextInt();
	 return menuSelection;
}

}
