package formvalidations.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import formvalidations.model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
  
	 @Autowired
		private SessionFactory sessionFactory;
		
		public void addEmployee(Employee employee) 
		{
		 sessionFactory.getCurrentSession().saveOrUpdate(employee);
		}
					@SuppressWarnings({ "unchecked" })
				public List<Employee> listEmployeess()
		 {
						List<Employee> emplist=null;
						
						emplist=(List<Employee>) sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
						
						for(Employee emp:emplist)
						{
							emp.setGetpic(Base64.encode(emp.getPic()));
						}
						
			 return emplist;
		}

		public Employee getEmployee(int id) {
			
			
			Employee employee=(Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
			
			return employee;
		}

		public void deleteEmployee(int id) {
			sessionFactory.getCurrentSession().createQuery("DELETE FROM Employee WHERE id="+id).executeUpdate();
		}
		
	
		@Override
		public void updateEmployee(int id, String salary, String address) {
			// TODO Auto-generated method stub
		
		//Employee must be model class name 

			String hql = "update Employee set salary ='"+salary+"',"+"address = '"+address+"' where id = "+id;
		
			
			Session session= sessionFactory.openSession();
			
			 Employee employee= (Employee) session.load(Employee.class, id);
			
			 Query query = session.createQuery(hql);
			 
			
			   employee.setAddress(address);
			 employee.setSalary(salary);
			 
			 query.executeUpdate();
			 
		
		}


}
