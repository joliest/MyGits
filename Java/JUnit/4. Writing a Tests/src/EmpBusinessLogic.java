//used for calculating yearly salary and appraisal of the employee
public class EmpBusinessLogic {
	//Calculate the yearly salary of Employee
	public double calculateYearlySalary(EmployeeDetails employeeDetails) {
		double yearlySalary = 0;
		yearlySalary = employeeDetails.getMonthlySalary() * 12;
		return yearlySalary;
	}
	
	//calculate apparaisal amount of employees
	public double calculateAppraisal(EmployeeDetails employeeDetails) {
		double appraisal = 0;
		
		if(employeeDetails.getMonthlySalary() < 10000) {
			appraisal = 500;
		} else {
			appraisal = 1000;
		}
		
		return appraisal;
	}
}
