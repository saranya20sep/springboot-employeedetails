package employee.solution.springBootApp.controller;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import employee.solution.springBootApp.employee.repository.EmployeeRepository;
import employee.solution.springBootApp.entity.Employee;
import employee.solution.springBootApp.service.EmployeeService;

/**
 * @author saranya
 *
 */
@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmployeeRepository repo;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/api/employees")
	public List<Employee> getEmployees() {
		List<Employee> employees = employeeService.retrieveEmployees();
		return employees;
	}

	@GetMapping("/api/employees/{employeeId}")
	public Employee getEmployee(@PathVariable(name="employeeId")Long employeeId) {
		return employeeService.getEmployee(employeeId);
	}

	@PostMapping("/api/employees")
	public void saveEmployee(Employee employee){
		employeeService.saveEmployee(employee);
		System.out.println("Employee Saved Successfully");
	}

	@DeleteMapping("/api/employees/{employeeId}")
	public void deleteEmployee(@PathVariable(name="employeeId")Long employeeId){
		employeeService.deleteEmployee(employeeId);
		System.out.println("Employee Deleted Successfully");
	}

	@PutMapping("/api/employees/{employeeId}")
	public void updateEmployee(@RequestBody Employee employee,
			@PathVariable(name="employeeId")Long employeeId){
		Employee emp = employeeService.getEmployee(employeeId);
		if(emp != null){
			employeeService.updateEmployee(employee);
		}

	}

	@GetMapping("/api/employees/{date}")
	public List<Employee> getEmployeeWithStartDate(@RequestBody Employee employee,
			@PathVariable(name="date")Date date){
		return repo.findStartDateGreaterThan(date);
	}


	@GetMapping("/api/employees/{salary}")
	public List<Employee> getEmployeeWithSalary(@RequestBody Employee employee,
			@PathVariable(name="salary")int salary){
		return repo.findSalaryGreaterThan(salary);
	}


	@PutMapping("/api/employees/{department}")
	public void updateEmployeeLocation(@RequestBody Employee employee,
			@PathVariable(name="department")String department){
		Employee emp = employeeService.getEmployeeLocation(department);
		if(emp != null){
			employeeService.updateEmployee(employee);
		}

	}

	@GetMapping("/api/employees/monthly/prize")
	public List<Employee> getEmployeesIdForPrize() {
		List<Employee> employees = employeeService.getRandomId();
		return employees;

	}


}


