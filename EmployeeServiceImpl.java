package employee.solution.springBootApp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import employee.solution.springBootApp.employee.repository.EmployeeRepository;
import employee.solution.springBootApp.entity.Employee;
import employee.solution.springBootApp.service.EmployeeService;

/**
 * @author saranya
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public List<Employee> retrieveEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

	public Employee getEmployee(Long employeeId) {
		Optional<Employee> optEmp = employeeRepository.findById(employeeId);
		return optEmp.get();
	}

	public void saveEmployee(Employee employee){
		employeeRepository.save(employee);
	}

	public void deleteEmployee(Long employeeId){
		employeeRepository.deleteById(employeeId);
	}

	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
	}


	public Employee getEmployeeLocation(String department) {
		Optional<Employee> optEmp = employeeRepository.findByDepartment(department);
		return optEmp.get();

	}


	public List<Employee> getRandomId() {
		List<Employee> employees = employeeRepository.getRandomElement();
		return employees;
	}













}

