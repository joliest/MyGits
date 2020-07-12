import static org.junit.Assert.assertEquals;

import org.junit.Test;

//used for testing the methods of EmpBusinessLogic.class
public class TestEmployeeDetails {
	EmployeeDetails employee = new EmployeeDetails();
	EmpBusinessLogic empBusinessLogic = new EmpBusinessLogic();
	
	//test to check appraisal 
	@Test
	public void testCalculateAppraisal() {
		employee.setName("Joliver");
		employee.setAge(25);
		employee.setMonthlySalary(8000);
		
		double appraisal = empBusinessLogic.calculateAppraisal(employee);
		assertEquals(500, appraisal, 0.0);
	}
	
	//test yearly salary
	@Test
	public void testCalculateYearlySalary() {
		employee.setName("Bimby");
		employee.setAge(25);
		employee.setMonthlySalary(8000);
		
		double salary = empBusinessLogic.calculateYearlySalary(employee);
		assertEquals(96000, salary, 0.0);
	}
}
