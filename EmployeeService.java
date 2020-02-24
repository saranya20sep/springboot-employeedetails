package employee.solution.springBootApp.service;


import java.util.List;

import employee.solution.springBootApp.entity.Employee;
/**
 * @author saranya
 *
 */
public interface EmployeeService {

	public List<Employee> retrieveEmployees();

	public Employee getEmployee(Long employeeId);

	public void saveEmployee(Employee employee);

	public void deleteEmployee(Long employeeId);

	public void updateEmployee(Employee employee);

	public Employee getEmployeeLocation(String department);

	public List<Employee> getRandomId();





}
