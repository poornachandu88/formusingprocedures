package formvalidations;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import formvalidations.model.Employee;
import formvalidations.service.EmployeeService;

@Controller
public class MyJspController {
	@Autowired
	private EmployeeService employeeService;

	@ModelAttribute("employee")
	public Employee getLoginForm() {
	return new Employee();

	}
	

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView gethomepage() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("title", "HomePage");
		return mv;

	}

	@RequestMapping(value = { "/regform" })
	public ModelAndView regform() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("title", "FormPage");
		mv.addObject("UserClickForm", true);
		return mv;

	}

	@RequestMapping(value = "/listofemp", method = RequestMethod.GET)
	public ModelAndView listEmployees() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("title", "EmployeeList");
		mv.addObject("UserClickEmployeeList", true);
		mv.addObject("employees", employeeService.listEmployeess());
		
		return mv;

	}

	
	@RequestMapping(value = "/regformsubmit", method = RequestMethod.POST)
	public ModelAndView formsubmit(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult,@RequestParam("file") CommonsMultipartFile file) 
	{
		ModelAndView mv = null;
		
		if (bindingResult.hasErrors())
		{
			
			mv = new ModelAndView("home");
			mv.addObject("title", "ErrorPage");
			mv.addObject("UserClickForm", true);
		} 
		else if(employeeService.listEmployeess().isEmpty()) 
		{
			System.out.println("File:" + file.getName());
			System.out.println("ContentType:" + file.getContentType());
			System.out.println("File:" + file.getOriginalFilename());
			
			
			employee.setPic(file.getBytes());
		
			employeeService.addEmployee(employee);
			mv = new ModelAndView("home");
			mv.addObject("title", "FormSuccess");
			mv.addObject("UserClickForm", true);
			mv.addObject("success", "you have successfully given employeedetails");
			mv.addObject("autoid", " your id is :" + employee.getId()+" please use this id at login time");
		}
		else {
				for (Employee emp : employeeService.listEmployeess())
				    {
					if (employee.getId() == emp.getId()) 
					{
						mv = new ModelAndView("home");
						mv.addObject("title", "FormPage");
						mv.addObject("UserClickForm", true);
						mv.addObject("iderror","user already existed with id " + employee.getId() + "  give different id ");
					}
					else
					{

						System.out.println("File:" + file.getName());
						System.out.println("ContentType:" + file.getContentType());
						System.out.println("File:" + file.getOriginalFilename());
						
						employee.setPic(file.getBytes());
					
											
						employeeService.addEmployee(employee);
						mv = new ModelAndView("home");
						mv.addObject("title", "FormSuccess");
						mv.addObject("UserClickForm", true);
						mv.addObject("success", "you have successfully given employeedetails");
						mv.addObject("autoid", " your id is :" + employee.getId()+" please use this id at login time");
					}
				    }
				}
		return mv;
	}

	@RequestMapping(value = "/modifyemployee", method = RequestMethod.GET)
	public ModelAndView addemployee() {

		ModelAndView mv = new ModelAndView("home");

		mv.addObject("title", "ModifyEmployee");
		mv.addObject("UserClickModifyEmployee", true);
		mv.addObject("employees", employeeService.listEmployeess());
		return mv;

	}

	@RequestMapping(value = "/delete/{empid}", method = RequestMethod.GET)
	public ModelAndView deleteemployeedetails(@PathVariable("empid") int empid) {
		Employee employee = new Employee();
		employee.setId(empid);

		int i = empid;

		ModelAndView mv = new ModelAndView("home");
		employeeService.deleteEmployee(employee.getId());
		mv.addObject("title", "DeleteEmployee");
		mv.addObject("UserClickDeleteEmployee", true);
		mv.addObject("employees", employeeService.listEmployeess());
		mv.addObject("msg", "successfully deleted  your id (" + i + " )no longer available in our database");
		return mv;

	}

	@RequestMapping(value = "/edit/{empid}", method = RequestMethod.GET)
	public ModelAndView editemployeedetails(@PathVariable("empid") int empid) {

		ModelAndView mv = new ModelAndView("home");

		mv.addObject("title", "EditEmployee");
		mv.addObject("UserClickEditEmployee", true);
		mv.addObject("employee", employeeService.getEmployee(empid));
		mv.addObject("employees", employeeService.listEmployeess());
		return mv;

	} 

@RequestMapping(value = "/updatesubmit", method = RequestMethod.GET)
	public ModelAndView updatesubmit(@RequestParam int id,@RequestParam ("salary")String salary,@RequestParam ("address")String address) {
 		
	/*	
 		Employee employee=new Employee();
 		employee.setId(id);
 		employee.setSalary(salary);
 		employee.setAddress(address);*/
 		
 			employeeService.updateEmployee(id,salary,address);
			ModelAndView mv = new ModelAndView("home");
			mv.addObject("title", "ModifyFormPage");
			mv.addObject("UserClickModifyForm", true);
			mv.addObject("employees", employeeService.listEmployeess());
			mv.addObject("updatesuccess", "id '"+id + "' employeedetails successfully updated ");

		return mv;
	}
	

	
	
	}


