package in.neosoft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.neosoft.entity.Employee;
import in.neosoft.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
		
	}
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).orElse(null);
	}
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee updateEmployee(Long id, Employee updatedEmployee) {
		Optional<Employee> optionalEmp = employeeRepository.findById(id);
		if(optionalEmp.isPresent()) {
			Employee existingEmp = optionalEmp.get();
			
			existingEmp.setName(updatedEmployee.getName());
			existingEmp.setDepartment(updatedEmployee.getDepartment());
			existingEmp.setSalary(updatedEmployee.getSalary());
			
			return employeeRepository.save(existingEmp);
		} else {
			return null;
		}
		
	}
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}

}
