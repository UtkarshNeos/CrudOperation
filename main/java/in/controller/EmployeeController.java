package in.neosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.neosoft.entity.Employee;
import in.neosoft.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeServices;
	
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeServices.getAllEmployees();
	}
	@GetMapping("/{id}")
	 public Employee getAllEmployeeById(@PathVariable("id") Long id) {
		 return employeeServices.getEmployeeById(id);
		 
	 }
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeServices.createEmployee(employee);
	}

	@PutMapping("/{id}")
public Employee updateEmployee(@PathVariable("id") Long id,  @RequestBody Employee employee) {
	return employeeServices.updateEmployee(id, employee);
}

@DeleteMapping("/{id}")
public void deleteEmployee(@PathVariable("id") Long id ) {
	  employeeServices.deleteEmployee(id);
}


}
