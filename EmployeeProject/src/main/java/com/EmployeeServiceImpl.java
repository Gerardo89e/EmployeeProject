package com;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeServiceImpl<T> implements EmployeeService{
	/*
	public static Map<Integer, Employee> hm= new HashMap<Integer, Employee>(){
		{
			Employee emp1=new Employee(1,"Lisa",15,new Address("Los Angeles","California"));
			Employee emp2=new Employee(2,"Henry",16000.0,new Address("OakLand","California"));
			Employee emp3=new Employee(3,"Cosmo",17000.0,new Address("Bakersfield","California"));

			
			put(emp1.getEmployeeNo(),(new Employee(1,"Lisa",15,new Address("Los Angeles","California"))));
			put(emp1.getEmployeeNo(),emp1);
			put(emp2.getEmployeeNo(),emp2);

			//put(emp3.getEmployeeNo(),emp3);
			//hm.put(emp1.getEmployeeNo(), (List<Employee>) emp1);
			//hm.put(emp2.getEmployeeNo(), (List<Employee>) emp2);
			//hm.put(emp3.getEmployeeNo(), (List<Employee>) emp3);

		}
};
*/
	//Employee obj=Employee.getInstance();
	public static ArrayList<Employee> list = new ArrayList<Employee>(){ 
	{
		add(new Employee(1,"Lisa",15,new Address("Los Angeles","California")));
		add(new Employee(2,"Henry",16000.0,new Address("OakLand","California")));
		add(new Employee(3,"Cosmo",17000.0,new Address("Bakersfield","California")));
	}
};

	@Override
	public void displayAllEmployee() {
		list.stream().forEach(System.out::println);
		// TODO Auto-generated method sture		
		/*for (Map.Entry<Integer, Employee> me : hm.entrySet()) {
            System.out.print(me.getKey() + ":");
            System.out.println(me.getValue());
        }
		*/
		 
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
		//Map<Integer,Employee>ker=(Map<Integer, Employee>) hm.entrySet().stream().filter(w->w.getKey().equals(hm.get(empNo)))
		//.collect(Collectors.toList());
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
		Employee select = list.stream().filter(var->var.getEmployeeNo() == e1.getEmployeeNo())
			.findFirst().orElse(null);
		select.setEmployeeName(e1.getEmployeeName());
		select.setEmployeeSalary(e1.getEmployeeSalary());
		select.setEmployeeAddress(e1.getEmployeeAddress());

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