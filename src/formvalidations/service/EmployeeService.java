package formvalidations.service;

import java.util.List;

import formvalidations.model.Employee;

public interface EmployeeService {
	
	public void addEmployee(Employee employee);

	public List<Employee> listEmployeess();
	
	public Employee getEmployee(int id);
	
	public void deleteEmployee(int id);

	public void updateEmployee(int id,String salary,String address);

}
