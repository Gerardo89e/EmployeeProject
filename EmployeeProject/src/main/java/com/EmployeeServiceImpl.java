package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeServiceImpl implements EmployeeService{
	public static ArrayList<Employee> list = new ArrayList<Employee>(){ 
	{
		add(new Employee(1,"Lisa",15,new Address("Los Angeles","California")));
		add(new Employee(2,"Henry",16000.0,new Address("OakLand","California")));
		add(new Employee(3,"Cosmo",17000.0,new Address("Bakersfield","California")));
	}
};


//Stream<Employee> myStream;
	//implements all methods for the interface class
	//EmployeeService empSer= new EmployeeService();	

	@Override
	public void displayAllEmployee() {
		// TODO Auto-generated method stub
		list.stream().forEach(System.out::println);
	}

	@Override
	public double calculateYearlySalary(Employee e1) {
		// TODO Auto-generated method stub
		double salary=e1.getEmployeeSalary()*12;
		return salary;
	}

	@Override
	public  Employee findByEmployeeNo(int empNo) {
		// TODO Auto-generated method stub
		//list.stream().filter(w ->w.getEmployeeNo() == empNo);
	
		ArrayList<Employee> fred=(ArrayList<Employee>)list.
		stream().filter(w ->w.getEmployeeNo() == empNo).collect(Collectors.toList());
	
		if(fred.isEmpty()) {
			return null;
		}else {
			return fred.get(0);
		}
	
	
	}

	@Override
	public void updateEmployee(Employee e1) {
		// TODO Auto-geneated method stub
		 //try {
			 Employee select = list.stream().filter(var->var.getEmployeeNo() == e1.getEmployeeNo())
						.findFirst().orElse(null);
					select.setEmployeeName(e1.getEmployeeName());
					select.setEmployeeSalary(e1.getEmployeeSalary());
					select.setEmployeeAddress(e1.getEmployeeAddress() );
	       // }
	        //catch(NullPointerException  e) {
	        //    System.out.println ("User Input the wrong vaule");
	        //}
//another way to do it with a for loop
//		for(int i=0;i<list.size();i++) {
//			if(list.get(i).getEmployeeNo()==e1.getEmployeeNo()) {
//				list.get(i).setEmployeeName(e1.getEmployeeName());
//				list.get(i).setEmployeeSalary(e1.getEmployeeSalary());
//				list.get(i).setEmployeeAddress(e1.getEmployeeAddress());
//				break;
//			}
//		}
	}

	@Override
	public void deleteEmployee(Employee e1) {
		// TODO Auto-generated method stub
		//ArrayList<Employee> newList = new ArrayList<Employee>();	
		/*Iterator<Employee> itr=list.iterator();
			while(itr.hasNext()) {
				Employee t= itr.next();
				if(e1.equals(list.contains(e1))){
					list.remove(e1);
				}
			}*/
			list.remove(e1);
	}


}