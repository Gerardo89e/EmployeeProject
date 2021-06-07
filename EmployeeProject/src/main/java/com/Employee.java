package com;

public class Employee extends Address{

	public int empNo;
	public String empName;
	public double salary;
	public Address address;
	Employee(int empNo, String empName, double salary, Address address) {
		// TODO Auto-generated constructor stub
		super(address.getCity(), address.getState());
		//super(city, state);
		this.address=address;
		this.empNo=empNo;
		this.empName=empName;
		this.salary=salary;
	}
	
	//getters and setters for Employee
	public int getEmployeeNo() {
		return empNo;
	}
	
	public String getEmployeeName() {
		return empName;
	}
	
	public double getEmployeeSalary() {
		return salary;
	}
	
	public void setEmployeeNo(int empNo) {
		this.empNo=empNo;		
	}
	
	public void setEmployeeName(String empName) {
		this.empName=empName;
	}
	
	public void setEmployeeSalary(double salary) {
		this.salary=salary;
	}
	public void setEmployeeAddress(Address address) {
		this.city=address.getCity();
		this.state=address.getState();
	}
	
	public Address getEmployeeAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", salary=" + salary + "]";
	}

}
