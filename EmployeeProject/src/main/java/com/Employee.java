package com;

public class Employee{
//removed the implement because Employee is a Address not true
	private int empNo;
	private String empName;
	private double salary;
	private Address address;
	//static Employee obj= new Employee();
	//default constructor
	public Employee() {
		super();
	}
	
	 public Employee(int empNo, String empName, double salary, Address address) {
		// TODO Auto-generated constructor stub
		super();
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
		this.address=address;
	}
	
	public Address getEmployeeAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", salary=" + salary + " " + address
				+ "]";
	}

}
