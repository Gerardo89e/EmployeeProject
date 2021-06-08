package com;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UseEmployee{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menuSelection=0;

		EmployeeServiceImpl solution = new EmployeeServiceImpl();
		
	//System.out.println(solution.list.get(1));

		while(menuSelection != 6) {
			//menuDisplay();
			menuSelection=optionSelected();

				
				switch(menuSelection) {
					case 1:
						 System.out.println("All Employee's listed:");
						 solution.displayAllEmployee();
						 break;
					case 2://calculate Employee salary
						Scanner sca = new Scanner(System.in);
					    System.out.println("Please insert the Employee Number: "); 
					    int EmployeeNum2 = sca.nextInt();
						
						Employee su= solution.list.stream()
			                    .filter( emp -> emp.getEmployeeNo() == EmployeeNum2)
			                    .findFirst()
			                    .orElse(null);
						 System.out.println("Employee Salary for "+solution.findByEmployeeNo(EmployeeNum2).empName+"for the year is:"+solution.calculateYearlySalary(su));
						 break;
						 
					case 3://Find employee
					try {
						Scanner scanObject = new Scanner(System.in);
						System.out.println("Please insert the Employee Number: "); 
						 int EmployeeNum = scanObject.nextInt();
						//System.out.println(solution.findByEmployeeNo(EmployeeNum)+" Employee Address ["+solution.findByEmployeeNo(EmployeeNum).getCity()+", "+solution.findByEmployeeNo(EmployeeNum).getState()+"]");
					    //updated below output
						 System.out.println(solution.findByEmployeeNo(EmployeeNum)+" "+solution.findByEmployeeNo(EmployeeNum).getEmployeeAddress());
					}catch( NullPointerException e) {
						System.out.println("Error arraylist index is out of bounds");
					}
						 break;
					case 4://Update employee
						try {
						Scanner st = new Scanner(System.in);
						System.out.println("Please insert the Employee Number: "); 
						int EmpNum = st.nextInt();
						st.nextLine();
						System.out.println("Please insert the Employee Name: "); 
						String EmpName = st.nextLine();
						
						System.out.println("Please insert the Employee Salary: "); 
						double EmpSalary= st.nextDouble();
						st.nextLine();
						System.out.println("Please insert the Employee Address for State: "); 
						String EmpState= st.nextLine();
						st.nextLine();
						System.out.println("Please insert the Employee Address for City: "); 
						String EmpCity= st.nextLine();

						//solution.updateEmployee(new Employee(1,"kia",150.0,new Address("Los","Cali")));
						//function1(solution,EmpNum,EmpName,EmpSalary,EmpSalary,EmpCity,EmpState);
						 passEmployeeInfoUpdate(solution,EmpNum,EmpName,EmpSalary,EmpCity,EmpState);
						//solution.updateEmployee(solution.list.get(0).setEmployeeName("Bo"));
					   // System.out.println(solution.findByEmployeeNo(1));
					    //System.out.println(solution.list.get(0).getEmployeeAddress());
						}catch(InputMismatchException  e) {
				            System.out.println ("User Input the wrong vaule");
						}
					    
						break;
					case 5:
						Scanner scan = new Scanner(System.in);
						System.out.println("Please insert the Employee Number to delete: "); 
						int EmployeeNum1 = scan.nextInt();
						Employee suti = solution.list.stream()
			                    .filter( emp -> emp.getEmployeeNo() == EmployeeNum1)
			                    .findFirst()
			                    .orElse(null);
						//Employee suti=solution.list.get(EmployeeNum1-1);
						solution.deleteEmployee(suti);
						System.out.println("Employee List updated: ");
						solution.displayAllEmployee();
						break; 
					case 6:
						System.out.println("Program has ended");
						break;
					default:
						System.out.println("Error"+menuSelection 
								+"is not an option");
				}	
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

public static void passEmployeeInfoUpdate(EmployeeServiceImpl solution,int empNo,String empName,double empSalary,String city,String state) {
	solution.updateEmployee(new Employee(empNo,empName,empSalary,new Address(city,state)));
	//solution.updateEmployee(new Employee(empNo,"kia",150.0,new Address("Los","Cali")));

	displayEmployeeUpdate(solution,empNo);
}

public static void displayEmployeeUpdate(EmployeeServiceImpl solution, int empNo) {
	//System.out.println("Updated "+solution.findByEmployeeNo(1));
	System.out.println("Updated "+solution.findByEmployeeNo(empNo).getEmployeeAddress());
    //System.out.println(solution.findByEmployeeNo(1).getEmployeeAddress());
    //System.out.println("updated State "+solution.findByEmployeeNo(1).getState());
	//System.out.println("updated City "+solution.findByEmployeeNo(1).getCity());
}

}
