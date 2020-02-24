package employee.solution.springBootApp.employee.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import employee.solution.springBootApp.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

	List<Employee> findStartDateGreaterThan(Date date);
	List<Employee> findSalaryGreaterThan( int salary);
	Optional<Employee> findByDepartment(String department);
	List<Employee> getRandomElement();
	
}
