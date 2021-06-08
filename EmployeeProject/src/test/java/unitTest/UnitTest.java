package unitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.Address;
import com.Employee;
import com.EmployeeServiceImpl;

public class UnitTest {
	EmployeeServiceImpl esi= new EmployeeServiceImpl();
	//Employee esi1 = new Employee(1,”Gary”,1200.0,new Address(“Big”,”state”));
	//Employee(int empNo, String empName, double salary, Address address) 
		Employee esi1=new Employee(1,"Lisa",14000.0,new Address("Los Angeles","California"));
	/*@BeforeEach
	void initEach() {
		esi= new EmployeeServiceImpl();
		//esi1= new Employee();
	}*/
	
	@Test
	void yearlySalary() {
		//esi1.setEmployeeName("Isabel");
		//esi1.setEmployeeSalary(6000);
		double salary = esi.calculateYearlySalary(esi1);
		assertEquals(14000.0,salary);
	}
}
