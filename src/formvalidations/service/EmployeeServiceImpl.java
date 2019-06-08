package formvalidations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import formvalidations.dao.EmployeeDao;
import formvalidations.model.Employee;


@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Transactional
	@Override
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
	}
	
	@Transactional
	public List<Employee> listEmployeess() {
		return employeeDao.listEmployeess();
	}

	@Transactional
	public Employee getEmployee(int id) {
		return employeeDao.getEmployee(id);
	}
	
	@Transactional
	public void deleteEmployee(int id) {
		employeeDao.deleteEmployee(id);
	}

	

	@Override
	@Transactional
	public void updateEmployee(int id, String salary, String address) {
		// TODO Auto-generated method stub
		employeeDao.updateEmployee(id, salary, address);
	}




	
	
}
